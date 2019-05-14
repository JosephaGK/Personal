package com.joseph.encryption.bothway.symmetry;

import com.joseph.encryption.single.BASE64Util;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;

/**
 * @author Joseph
 */
@Slf4j
public class DESUtil {

	/**
	 * 定义加密算法，DESede(即3DES)
 	 */
	private static final String DESede = "DESede";

	private static final String PASSWORD_CRYPT_KEY = "2015mengzhenbinStudyForSecurity@DESede";

	/**
	 * 加密方法
	 * @param src 源数据的字节数组
	 * @return
	 */
	public static byte[] encryptMode(byte[] src) {
		try {
			// 生成密钥
			SecretKey deskey = new SecretKeySpec(build3DesKey(PASSWORD_CRYPT_KEY), DESede);
			// 实例化负责加密/解密的Cipher工具类
			Cipher c1 = Cipher.getInstance(DESede);
			// 初始化为加密模式
			c1.init(Cipher.ENCRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (Exception e) {
			log.error("DesUtil.encryptMode error", e);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 加密方法(BASE64编码返回)
	 * @param src 源数据的字节数组
	 * @return
	 */
	public static String encryptModeBase64(byte[] src) {
		try {
			// 生成密钥
			SecretKey deskey = new SecretKeySpec(build3DesKey(PASSWORD_CRYPT_KEY), DESede);
			// 实例化负责加密/解密的Cipher工具类
			Cipher c1 = Cipher.getInstance(DESede);
			// 初始化为加密模式
			c1.init(Cipher.ENCRYPT_MODE, deskey);
			return BASE64Util.base64Encode(c1.doFinal(src));
		} catch (Exception e) {
			log.error("DesUtil.encryptMode error", e);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解密函数
	 *
	 * @param src
	 *            密文的字节数组
	 * @return
	 */
	public static byte[] decryptMode(byte[] src) {
		try {
			SecretKey deskey = new SecretKeySpec(build3DesKey(PASSWORD_CRYPT_KEY), DESede);
			Cipher c1 = Cipher.getInstance(DESede);
			// 初始化为解密模式
			c1.init(Cipher.DECRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (Exception e) {
			log.error("DesUtil.decryptMode error", e);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解密函数(BASE64解码后解密)
	 * @param src 密文的字节数组
	 * @return
	 */
	public static String decryptModeBase64(String src) {
		try {
			SecretKey deskey = new SecretKeySpec(build3DesKey(PASSWORD_CRYPT_KEY), DESede);
			Cipher c1 = Cipher.getInstance(DESede);
			// 初始化为解密模式
			c1.init(Cipher.DECRYPT_MODE, deskey);
			return new String(c1.doFinal(BASE64Util.base64Decode(src)));
		} catch (Exception e) {
			log.error("DesUtil.decryptMode error", e);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据字符串生成密钥字节数组
	 * @param keyStr 密钥字符串
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static byte[] build3DesKey(String keyStr) throws UnsupportedEncodingException {
		// 声明一个24位的字节数组，默认里面都是0
		byte[] key = new byte[24];
		// 将字符串转成字节数组
		byte[] temp = keyStr.getBytes("UTF-8");
		//执行数组拷贝 System.arraycopy(源数组，从源数组哪里开始拷贝，目标数组，拷贝多少位)
		if (key.length > temp.length) {
			// 如果temp不够24位，则拷贝temp数组整个长度的内容到key数组中
			System.arraycopy(temp, 0, key, 0, temp.length);
		} else {
			// 如果temp大于24位，则拷贝temp数组24个长度的内容到key数组中
			System.arraycopy(temp, 0, key, 0, key.length);
		}
		return key;
	}
}
