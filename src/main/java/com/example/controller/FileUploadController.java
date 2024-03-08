package com.example.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.example.pojo.BaseResponse;
import com.example.pojo.UploadInfo;
import com.example.pojo.User;
import com.example.util.WebUtil;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class FileUploadController {

    Logger logger = Logger.getLogger(this.getClass().getName());


    private File tmpDir ;
    private ServletContext sc;
    private String contextPath;

    public FileUploadController(ServletContext sc)
    {
        this.sc = sc;
        this.contextPath = sc.getContextPath();

        // 图片上传到临时目录
        tmpDir = new File( sc.getRealPath("/tmp"));
        tmpDir.mkdirs();
    }

    @RequestMapping("/user/fileUpload.do")
    public BaseResponse upload(
            HttpServletRequest request,
                               HttpServletResponse response,
                               HttpSession session) throws Exception
    {
        User user = (User) session.getAttribute("user");
        UploadInfo uploadInfo = (UploadInfo) parseUpload(request, response,user);
        session.setAttribute("uploadInfo",uploadInfo);
        return BaseResponse.success(uploadInfo);
    }

    // 从 request 中提取上传数据，并保存到临时文件
    private Object parseUpload(HttpServletRequest request, HttpServletResponse response,User user) throws Exception
    {

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart)
            throw new Exception("请求编码必须为: multipart/form-data !");

        request.setCharacterEncoding("UTF-8");
        logger.error(contextPath);

        // ServletFileUpload ： commons 包里提供的工具类
        ServletFileUpload upload = new ServletFileUpload(); // 解析请求
        FileItemIterator iter = upload.getItemIterator(request);
        while (iter.hasNext())
        {
            // 表单域
            FileItemStream item = iter.next();
            String fieldName = item.getFieldName();
            InputStream fieldStream = item.openStream();
            if (item.isFormField())
            {
                // 普通表单域: 直接读取值
                // 指的是<input>,<select>,<textarea>输入控件的值, 字符串类型
                String fieldValue = Streams.asString(fieldStream, "UTF-8");
                logger.error("普通表单字段:" + fieldName + "=" + fieldValue);
            } else
            {
                // 文件域, 指<file>控件的值，指文件的数据
                // 生成唯一的文件名
                UploadInfo info = new UploadInfo();
                info.realName = item.getName(); // 原始文件名
                info.suffix = WebUtil.getSuffix(info.realName); // 后缀
                info.tmpFileName = WebUtil.createTmpName(info.suffix); // 服务器临时文件名
                info.tmpFile = new File(tmpDir, info.tmpFileName); // 临时文件
                info.fileSize = 0; // 文件大小

                logger.error("文件上传开始: " + info.realName + " >> " + info.tmpFile);

                // 从FieldStream读取数据, 保存到目标文件
                info.tmpFile.getParentFile().mkdirs();
                FileOutputStream fileStream = new FileOutputStream(info.tmpFile);
                try
                {
                    // 从请求里读取文件数据，保存到本地文件
                    info.fileSize = saveUpload(fieldStream, fileStream, 1000000*100);
                } finally
                {
                    try{
                        fileStream.close();
                    } catch (Exception e){}

                }

                // 进一步处理文件
                return handleFile( info ,user,fieldName);
            }
        }

        throw new Exception("请求中没有文件域数据!");// 不应该发生这种情况
    }

    // 读取上传数据，保存至临时文件中
    private long saveUpload(InputStream in, OutputStream out, long limit) throws Exception
    {
        long count = 0;
        byte[] buf = new byte[8192];
        while (true)
        {
            int n = in.read(buf);
            if (n < 0)
                break;
            if (n == 0)
                continue;
            out.write(buf, 0, n);

            count += n;
            if(count > limit)
                throw new Exception("上传文件大小超出限制 > " + limit);
        }
        return count;
    }

    // 进一步处理文件
    protected Object handleFile(UploadInfo info, User user,String fieldName) throws Exception
    {
        logger.error("文件上传完成: " + info.realName + ", size=" + info.fileSize + ", tmpFile=" + info.tmpFile.getAbsolutePath());
        if (fieldName.equals("avatar")){
            // 上传头像
            String dir = sc.getRealPath("/") + "data/user/";
            File destFile = new File(dir + info.tmpFile.getName());
            if (destFile.exists()){
                FileUtils.delete(destFile);
            }
            FileUtils.copyFile(info.tmpFile,destFile);
        } else if (fieldName.equals("undefined")) {
            // 添加商品封面
            return info;
            
        } else{

            String dir = sc.getRealPath("/") + "data/goods/" + fieldName + "/";
            new File(dir).mkdirs();
            File destFile = new File(dir + info.tmpFile.getName());
            if (destFile.exists()){
                FileUtils.delete(destFile);
            }
            FileUtils.copyFile(info.tmpFile,destFile);
        }

        return info;
    }

}