import java.math.BigInteger;
import java.security.SecureRandom;
public class rsa {
     static BigInteger p , q ,modulus ,phi, publicKey ,privateKey;
     public rsa(int len)
     {
          SecureRandom random = new SecureRandom();
          p = BigInteger.probablePrime(len, random);
          q = BigInteger.probablePrime(len, random);

          modulus = p.multiply(q);
          phi = q.subtract(BigInteger.ONE).multiply(p.subtract(BigInteger.ONE));
          publicKey = new BigInteger("5");
          privateKey = publicKey.modInverse(phi);
     }
     public static BigInteger encrypt(BigInteger message)
     {
          return message.modPow(publicKey, modulus);
     }
     public static BigInteger decrypt(BigInteger encryptedMessage)
     {
          return encryptedMessage.modPow(privateKey, modulus);
     }
     public static void main(String[] args) {
          rsa rsa1 = new rsa(1024);
          BigInteger a = new BigInteger("242442");
          System.out.println(rsa1.encrypt(a));
          System.out.println(rsa1.decrypt(rsa.encrypt(a)));
     }
}