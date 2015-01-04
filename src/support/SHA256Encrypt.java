package support;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Encrypt {
	public static String encrypt(String value) {
		String sha = "";
		MessageDigest sh = null;

		try {
			sh = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		sh.update(value.getBytes());
		byte byteData[] = sh.digest();
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		sha = sb.toString();
		return sha;
	}
}
