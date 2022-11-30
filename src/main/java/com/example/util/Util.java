package com.example.util;

import com.example.mapper.GoodsMapper;
import com.example.pojo.BaseResponse;
import com.example.pojo.Goods;
import com.example.pojo.UploadInfo;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class Util
{
	// 生成GUID
	public static String guid()
	{
		 String s = UUID.randomUUID().toString(); 
	     String s2 = s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24); 
	     //return s2.toLowerCase();
	     return s2;
	}
	
	// 获取文件名后缀，例如 "mp4"
	public static String getSuffix(String filePath)
	{
		// 分隔符可能是 / 或者 \
		int p1 = filePath.lastIndexOf('/');
		int p2 = filePath.lastIndexOf('\\');
		if(p2>p1) p1 = p2;
		
		int p3 = filePath.lastIndexOf('.');
		if(p3 > p1)
		{
			return filePath.substring(p3+1);
		}
		return "";
	}

//	public Object coverUrl(UploadInfo uploadInfo, Goods goods, GoodsMapper goodsMapper){
//		if (uploadInfo != null){
//			File dir = uploadInfo.tmpFile.getParentFile().getParentFile();
//			try {
//				if (uploadInfo.tmpFile.exists()){
//					FileUtils.delete(uploadInfo.tmpFile);
//				}
//				File srcFile = new File(dir,"/data/goods/" + goods.getId() + "/" + uploadInfo.tmpFileName);
//				Goods goodsed = goodsMapper.getGoods(goods.getId());
//				File fileed = new File(dir, goodsed.getCover());
//				if (fileed.exists()){
//					FileUtils.delete(fileed);
//				}
//				goods.setCover("/data/goods/" + goods.getId() + "/" + srcFile.getName());
//			} catch (IOException e) {
//				return BaseResponse.error(e);
//			}
//		}
//	}
}
