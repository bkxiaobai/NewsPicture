package com.np.tool;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateUtil
{
	//��������ϸ��ʱ��
	public static String getFormalTime()
	{
		return getFormat("yyyy-MM-dd HH-mm-ss");
	}
	
	//�����ַ�����Ϊ�ļ���
	public static String getStringTime()
	{
		return getFormat("yyyyMMddHHmmss");
	}
	//���߷���
	private static String getFormat(String format)
	{
		Date d = new Date();
		DateFormat df = new SimpleDateFormat(format);
		return df.format(d);
	}
}
