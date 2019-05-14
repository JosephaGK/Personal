package com.joseph.encryption;



import com.joseph.encryption.bothway.asymmetry.RSAUtil;
import com.joseph.encryption.bothway.symmetry.AESUtil;
import com.joseph.encryption.bothway.symmetry.DESUtil;
import com.joseph.encryption.single.BASE64Util;
import com.joseph.encryption.single.MD5Util;
import com.joseph.encryption.single.SHAUtil;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;

/**
 * 1.概念
 * 明文：加密前的信息
 * 密文：机密后的信息
 * 算法：加密或解密的算法
 * 密钥：算法使用的钥匙
 *
 * 2.例子
 * 将123456每位数字都加1后得到234567，
 * 其中123456就是明文，234567就是密文，加密密钥就是1，加密算法是每位加
 *
 * 3.对称加密和非对称加密
 * 123456-->234567的加密密钥就是1，加密算法是每位+
 * 234567-->123456的解密密钥也是1，解密算法是每位-
 *
 * 加密算法（+）和解密算法（-）相对称，这种加密算法就称作对称加密，
 * 加密算法和解密算法不对称就称之为非对称加密。
 *
 * 4.算法类型
 * 单项加密
 * 		单项加密指通过对数据进行摘要计算生成密文，密文不可逆推还原，Base64、MD5、SHA等；
 * 	 	经典的哈希算法：MD2、MD4、MD5 和 SHA-1（目的是将任意长输入通过算法变为固定长输出，且保证输入变化一点输出都不同，且不能反向解密）
 * 双向加密
 * 		可以把密文逆推还原成明文，其中双向加密又分为对称加密和非对称加密。
 * 	    对称加密是指数据使用者必须拥有同样的密钥才可以进行加密解密，就像大家共同约定了一组暗号一样，
 * 而非对称加密相对于对称加密而言，无需拥有同一组密钥，它是一种“信息公开的密钥交换协议”。
 * 非对称加密需要公开密钥和私有密钥两组密钥，公开密钥和私有密钥是配对起来的，也就是说使用公开密钥进行数据加密，只有对应的私有密钥才能进行解密。
 * 对称加密算法：DES算法，3DES算法，TDEA算法，Blowfish算法，RC5算法，IDEA算法，AES算法。
 * 非对称加密算法：RSA、DSA、Elgamal、背包算法、Rabin、D-H、ECC。
 * @author Joseph
 */
public class EncodeUtilTest {

	public static void main(String[] args) throws Exception {
		String msg = "Eat our own dog food";
		System.out.println("转换前：" + msg);
		//==Base64==
		String base64Str = BASE64Util.base64Encode(msg.getBytes());
		System.out.println("Base64转换后：" + base64Str);
		System.out.println("Base64解码后：" + new String(BASE64Util.base64Decode(base64Str)));

		//==Md5==
		String md5Base64Str = MD5Util.md5Base64(msg);
		byte[] md5 = MD5Util.md5(msg);
		System.out.println("Md5转换后：" + md5);
		System.out.println("Md5后Base编码转换后：" + md5Base64Str);

		//==SHA==
		//==SHA1==
		String sha = SHAUtil.SHA(msg);
		String sha1 = SHAUtil.SHA1(msg);
		System.out.println("SHA转换后：" + sha);
		System.out.println("SHA-1转换后：" + sha1);

		//==Des==
		byte[] des = DESUtil.encryptMode(msg.getBytes());
		byte[] myMsgArr = DESUtil.decryptMode(des);
		System.out.println("DES加密后：" + new String(des));
		System.out.println("DES解密后：" + new String(myMsgArr));
		String desBase64Str = DESUtil.encryptModeBase64(msg.getBytes());
		System.out.println("Des后Base64编码转换后：" + desBase64Str);
		System.out.println("Base64解码后Des转换后：" + new String(DESUtil.decryptModeBase64(desBase64Str)));

		//==Aes==
		String aesKey = "123456";
		String aesEnStr= AESUtil.aesEncrypt(msg,aesKey);
		System.out.println("AES加密Base64编码后：" +aesEnStr);
		String aesDeStr = AESUtil.aesDecrypt(aesEnStr,aesKey);
		System.out.println("Base64解码AES解密后：" +aesDeStr);

		//==Rsa==
		HashMap<String, Object> keys = RSAUtil.getKeys();
		RSAPublicKey publicKey = (RSAPublicKey) keys.get("public");
		RSAPrivateKey privateKey =  (RSAPrivateKey) keys.get("private");
		RSAPublicKey pubKey = RSAUtil.getPublicKey(publicKey.getModulus().toString(), publicKey.getPublicExponent().toString());
		RSAPrivateKey priKey = RSAUtil.getPrivateKey(privateKey.getModulus().toString(), privateKey.getPrivateExponent().toString());
		String rsaEnStr = RSAUtil.encryptByPublicKey(msg, pubKey);
		System.out.println("RSA公钥加密后：" +rsaEnStr);
		String rsaDeStr= RSAUtil.decryptByPrivateKey(rsaEnStr, priKey);
		System.out.println("RSA私钥解密后：" +rsaDeStr);
	}
}
