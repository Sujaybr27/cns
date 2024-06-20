import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
public class sha {
     public static String encrypt(String input)
     {
          
          try {
               MessageDigest md = MessageDigest.getInstance("SHA-512");
               byte[] inp = md.digest(input.getBytes());
               BigInteger no = new BigInteger(1,inp);
               String n = no.toString(16);
               while(n.length()<32)
               {
                    n = "0" + n;
               }
               return n; 
          } 
          catch (NoSuchAlgorithmException e) {
               throw new RuntimeException(e); 
          }
          
     }
     public static void main(String[] args) {
          sha sha = new sha();
          System.out.println(sha.encrypt("abcd"));
     }
}
