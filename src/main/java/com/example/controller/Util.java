package com.example.controller;

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
}
