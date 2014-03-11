package org.bdigital.ocd.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilsString {

	public static String stringDateWStoStringDateWeb(String inputString) throws ParseException {
		if(inputString!=null && !"".equals(inputString)){
			return UtilsString.dateToString(UtilsString.stringtoDate(inputString, Constants.FORMAT_DATE_WS), Constants.FORMAT_DATE_WEB);
		}else{
			return inputString;
		}
	}
	public static String stringDateWebtoStringDateWS(String inputString) throws ParseException {
		if(inputString!=null && !"".equals(inputString)){
			return UtilsString.dateToString(UtilsString.stringtoDate(inputString, Constants.FORMAT_DATE_WEB), Constants.FORMAT_DATE_WS);
		}else{
			return inputString;
		}
	}
	public static String stringDateHourWStoStringDateHourWeb(String inputString) throws ParseException {
		if(inputString!=null && !"".equals(inputString)){
			return UtilsString.dateToString(UtilsString.stringtoDate(inputString, Constants.FORMAT_DATEHOUR_WS), Constants.FORMAT_DATEHOUR_WEB);
		}else{
			return inputString;
		}
	}
	public static Date stringtoDate(String inputString, String formatString) throws ParseException {
		
		SimpleDateFormat fromUser = new SimpleDateFormat(formatString);

		return fromUser.parse(inputString);
	}

	public static String dateToString(Date inputDate, String formatString) throws ParseException {
		
		SimpleDateFormat myFormat = new SimpleDateFormat(formatString);

		return myFormat.format(inputDate);
	}

}
