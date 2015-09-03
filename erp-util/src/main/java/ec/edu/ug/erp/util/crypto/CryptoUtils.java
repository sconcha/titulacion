package ec.edu.ug.erp.util.crypto;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CryptoUtils {

	private static PasswordEncoder encoder=new BCryptPasswordEncoder();
	private static ShaPasswordEncoder eSha=new ShaPasswordEncoder();
	private static Md5PasswordEncoder eMd5=new Md5PasswordEncoder();
	
	private static final String key="T!tuL@C10n.C15c.2015";
	
	public static String encode(String password){		
		return encoder.encode(password);
	}
	
	
	public static String encodeSHA(String password){		
		return eSha.encodePassword(password, key);
	}
	
	public static String encodeMD5(String password){	
		return eMd5.encodePassword(password, key);
	}
	
	
	
	public static PasswordEncoder getEncoder() {
		return encoder;
	}
	
	public static void main(String[] args) {
		
		String password="12345";
		System.out.println("BCRYPT "+encode(password));
		System.out.println("MD5 "+encodeMD5(password));
		System.out.println("SHA "+encodeSHA(password));


	}
}
