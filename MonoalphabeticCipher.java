public class MonoalphabeticCipher {


   public static char[] normalUpper =
        { 'A','B','C','D','E','F','G','H','I','J','K','L','M',
          'N','O','P','Q','R','S','T','U','V','W','X','Y','Z' };

   public static char[] normalLower =
        { 'a','b','c','d','e','f','g','h','i','j','k','l','m',
          'n','o','p','q','r','s','t','u','v','w','x','y','z' };

   public static char[] codedUpper =
        { 'Q','W','E','R','T','Y','U','I','O','P','A','S','D',
          'F','G','H','J','K','L','Z','X','C','V','B','N','M' };

   public static char[] codedLower =
        { 'q','w','e','r','t','y','u','i','o','p','a','s','d',
          'f','g','h','j','k','l','z','x','c','v','b','n','m' };

    // Encryption
   public static String encrypt(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            for (int j = 0; j < 26; j++) {

                if (ch == normalUpper[j]) {
                    result += codedUpper[j];
                    break;
                }

                if (ch == normalLower[j]) {
                    result += codedLower[j];
                    break;
                }

                // If not found after checking all letters
                if (j == 25) {
                    result += ch;
                }
            }
        }
        return result;
    }

    // Decryption (Option 2: early append, no boolean)
  public static String decrypt(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            for (int j = 0; j < 26; j++) {

                if (ch == codedUpper[j]) {
                    result += normalUpper[j];
                    break;
                }

                if (ch == codedLower[j]) {
                    result += normalLower[j];
                    break;
                }


				// ni support huruf besar je
				  //if (s.charAt(i) < 'A' || s.charAt(i) > 'Z')
				                //{
				                   /// decryptedString += s.charAt(i);
				                   /// break;

                // If not found after checking all letters and ni support huruf kecik and besar
                if (j == 25) {
                    result += ch;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String text = "Welcome to geeksforgeeks";
        System.out.println("PLAINTEXT : " + text);

        String encrypted = encrypt(text);
        System.out.println("ENCRYPTED : " + encrypted);

        System.out.println("DECRYPTED : " + decrypt(encrypted));
    }
}
