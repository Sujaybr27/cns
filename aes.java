import java.util.*;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.KeyGenerator;


public class aes {
     public static SecretKey genKey() throws Exception
     {
          KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
          keyGenerator.init(128);
          return keyGenerator.generateKey();
     }     
     public static String encrypt(String planeText , SecretKey secretKey) throws Exception
     {
          Cipher c = Cipher.getInstance("AES");
          c.init(c.ENCRYPT_MODE, secretKey);
          byte enc[] = c.doFinal(planeText.getBytes("UTF8"));
          return Base64.getEncoder().encodeToString(enc);
     }
     public static String decrypt(String encodedString, SecretKey secretKey) throws Exception
     {
          Cipher cipher = Cipher.getInstance("AES");
          cipher.init(cipher.DECRYPT_MODE,secretKey);
          byte enc[] = cipher.doFinal(Base64.getDecoder().decode(encodedString));
          return new String(enc);
     }
     public static void main(String[] args) throws Exception{
          SecretKey s = genKey();
          System.out.println(encrypt("plane", s));
          System.out.println(decrypt(encrypt("plane", s), s));
     }
}
