public class ceaser {
     public static String encrypt(String text,int shift)
     {
           StringBuilder encryptedText = new StringBuilder();
           for (int i=0;i<text.length();i++)
           {
                char ch = text.charAt(i);
                if (Character.isUpperCase(ch))
                {
                     char enc = (char)('A'+(ch-'A'+shift)%26);
                     encryptedText.append(enc);
                }
                else if(Character.isLowerCase(ch))
                {
                     char enc = (char)('a'+(ch-'a'+shift)%26);
                     encryptedText.append(enc);
                }
                else
                {
                     encryptedText.append(ch);
                }
           }
           return encryptedText.toString();
     }
     public static String decrypt(String text, int shift)
     {
           return encrypt(text,26-shift);
     }
     public static void main(String args[])
     {
           System.out.println(encrypt("Hello world",3));
           System.out.println(decrypt(encrypt("Hello world",3),3));
     }
 }