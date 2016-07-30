package yonyou.esn.openapi.palmyy;

import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

//import sun.misc.BASE64Decoder;

public class DesEncrypt {
	
	 private static DesEncrypt inst = null;
	 
	 private static final String DES_KEY = "G51-NIPR";
	 
	 private static final byte[] DES_IV = {(byte)0x12, (byte)0x34, (byte)0x56, (byte)0x78, (byte)0x90, (byte)0xAB, (byte)0xCD, (byte)0xEF};
	 
	 private AlgorithmParameterSpec iv = null;
	 
	 private Key key = null; 
	 
	 private Cipher cipher = null;
	 
	 /**
	  * @throws Exception
	  */
	 private DesEncrypt() throws Exception
	 {
		 DESKeySpec keySpec = new DESKeySpec(DES_KEY.getBytes("UTF-8"));
		 iv = new IvParameterSpec(DES_IV);
		 SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		 key = keyFactory.generateSecret(keySpec);
		 cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
	 }
	 	 
	 /**
	  * @return
	  * @throws Exception
	  */
	 public synchronized byte[] encode(byte[] data) throws Exception {
		 cipher.init(Cipher.ENCRYPT_MODE, key, iv);
		 byte[] pasByte = cipher.doFinal(data); 
		 return pasByte;  
	 }  

	 /**
	  * @return
	  * @throws Exception
	  */
	 public synchronized byte[] decode(byte[] data) throws Exception { 
		 cipher.init(Cipher.DECRYPT_MODE, key, iv);
		 byte[] pasByte = cipher.doFinal(data);  
		 return pasByte;
	 } 
	 
	 
	 /**
	  * @return
	  * @throws Exception
	  */
	 public  static DesEncrypt getInstance() throws Exception {
		 if (inst == null) {
			 inst = new DesEncrypt();
		 }
		 return inst;
	 }
	 
	 
}
