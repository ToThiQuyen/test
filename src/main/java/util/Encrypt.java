package util;

import java.security.MessageDigest;
import java.util.Base64;

public class Encrypt {
	public static String toSHA1(String str) {
		String salt = "fkajaegsgs@vdv/:dsfheg)sgfsagsa";
		String result =null;
		str = str + salt;
		try {
			byte[] data = str.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			result = Base64.getEncoder().encodeToString(md.digest(data));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
