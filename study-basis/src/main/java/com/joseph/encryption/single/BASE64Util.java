package com.joseph.encryption.single;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author Joseph
 */
public class BASE64Util {
	/**
	 * @param bytes 待编码的byte[]
	 * @return 编码后的base 64 code
	 */
	public static String base64Encode(byte[] bytes) {
		return new BASE64Encoder().encode(bytes);
	}

	/**
	 * @param base64Code 待解码的base 64 code
	 * @return 解码后的byte[]
	 * @throws Exception
	 */
	public static byte[] base64Decode(String base64Code) throws Exception {
		return new BASE64Decoder().decodeBuffer(base64Code);
	}
}
