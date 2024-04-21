package com.shimigui.workshop.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
	public static String decodeparam(String arg) {
		try {
			return URLDecoder.decode(arg, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
