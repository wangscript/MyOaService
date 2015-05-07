package com.dafy.myoaservice.parserutil;

public class ParserUtil {

	public static String parseTableName(String tableName)
	{
		String[] ss = tableName.split("_");
		String result = "";
		int n = 0;
		for(String s:ss)
		{
			if(n==0)
			{
				n++;
				continue;
			}
			s = s.toLowerCase();
			s = s.substring(0, 1).toUpperCase()+s.replaceFirst("\\w","");
			result+=s;
			n++;
		}
		return result;
	}
	public static String parseFilePath(String tableName)
	{
		String[] ss = tableName.split("_");
		String result = "";
		int n = 0;
		for(String s:ss)
		{
			s = s.toLowerCase();
			s = s.substring(0, 1).toUpperCase()+s.replaceFirst("\\w","");
			result+=s+"/";
			n++;
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		
		System.out.println(parseTableName("aaaa_bbbb_ccCC"));
	}
	
}
