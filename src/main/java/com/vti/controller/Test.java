package com.vti.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Test {
	public static void main(String[] args) throws InterruptedException, ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sdate1 = format.format(new Date());
		String sDate2="2021-04-24 19:00:00";  
		
		Date date1 = format.parse(sdate1);
		Date date2 = format.parse(sDate2);
		long rs = (date2.getTime() - date1.getTime())/(60000);
		System.out.println(rs);
	}
}
