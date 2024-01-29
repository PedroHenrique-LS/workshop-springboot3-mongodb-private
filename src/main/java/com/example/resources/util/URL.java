package com.example.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class URL {
	
	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static LocalDateTime convertDate(String texDate, LocalDateTime defaultValue) {
		try {
		    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		    LocalDate date = LocalDate.parse(texDate, fmt);
		    System.out.println(date.atStartOfDay());
			return date.atStartOfDay(); 
		} catch (DateTimeParseException e) {
			return defaultValue;
		}
	}

}
