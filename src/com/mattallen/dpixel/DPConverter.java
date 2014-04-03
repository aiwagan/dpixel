package com.mattallen.dpixel;

import java.text.DecimalFormat;

public class DPConverter {

	public static final double	
	MDPI = 1,
	LDPI = 0.75,
	HDPI = 1.5,
	XHDPI = 2,
	XXHDPI = 3,
	XXXHDPI = 4;
	
	private static DecimalFormat df = new DecimalFormat("#.#");
	
	public static String dpToPixel(double dp, double convertTo){
		return df.format(dp*convertTo)+"px";
	}
	
	public static String pixelToDP(double pixels, double convertFrom){
		return df.format(pixels/convertFrom)+"dp";
	}
}