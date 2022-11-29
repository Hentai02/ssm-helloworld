package com.example.pojo;

import java.io.File;

// 上传信息
public class UploadInfo
{
	public String realName ;  // 原始文件名
	public String suffix ;    // 后缀
	public String tmpFileName ; // 服务器临时文件名
	public File tmpFile ;   // 临时文件
	public long fileSize ;  // 文件大小	
}
