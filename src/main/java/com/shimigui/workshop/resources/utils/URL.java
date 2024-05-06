package com.shimigui.workshop.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.Instant;

public class URL {
	public static String decodeparam(String arg) {
		try {
			return URLDecoder.decode(arg, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static Instant convertDate(String textDate) {
		return convertDate(textDate, Instant.now());
	}
	
	public static Instant convertDate(String textDate, Instant defaultInstant) {
		try {
			return Instant.parse(textDate); 
		}
		catch (RuntimeException e) {
			return defaultInstant;
		}
	}
}
