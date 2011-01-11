import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.StringBuffer;
import java.security.*;

public class ComputeSHA {
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream(args[0]);
			byte[] buffer = new byte[8192];
			int length;
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			while ( (length = in.read(buffer)) != -1 ) {
				md.update(buffer, 0, length);
			}
			
			byte[] fileDigest = md.digest();
			for ( byte b : fileDigest ) {
				System.out.printf( "%x", b );
			}
			System.out.print('\n');
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}
}