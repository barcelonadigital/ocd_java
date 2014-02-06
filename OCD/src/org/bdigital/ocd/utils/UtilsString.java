package org.bdigital.ocd.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilsString {

	public static Date stringtoDate(String inputString, String formatString) throws ParseException {
		
		SimpleDateFormat fromUser = new SimpleDateFormat(formatString);

		return fromUser.parse(inputString);
	}

	public static String dateToString(Date inputDate, String formatString) throws ParseException {
		
		SimpleDateFormat myFormat = new SimpleDateFormat(formatString);

		return myFormat.format(inputDate);
	}

}
