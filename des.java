import java.util.*;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.KeyGenerator;

public class des {
    public static SecretKey keygen() throws Exception
    {
          KeyGenerator keygen = KeyGenerator.getInstance("DES");
          keygen.init(56);
          return keygen.generateKey();
    }
    public static String encrypt(String plaintext , SecretKey secretkey) throws Exception
    {
          Cipher cipher = Cipher.getInstance("DES");
          cipher.init(Cipher.ENCRYPT_MODE, secretkey);          
          byte[] enc = cipher.doFinal(plaintext.getBytes("UTF8"));
          return Base64.getEncoder().encodeToString(enc);
    }     
    public static String decrypt(String encodedString, SecretKey secretKey) throws Exception
    {
          Cipher cipher = Cipher.getInstance("DES");
          cipher.init(cipher.DECRYPT_MODE,secretKey);
          byte[] dec = cipher.doFinal(Base64.getDecoder().decode(encodedString));
          return new String(dec);
    }
    public static void main(String args[]) throws Exception
    {
          SecretKey s = keygen();
          System.out.println(encrypt("plane", s));
          System.out.println(decrypt(encrypt("plane", s), s));
    }
}