public class VigenereCipher{

	public static String generateKey(String text, String key){

		String result = "";
		        int keyIndex = 0;

		        for (int i = 0; i < text.length(); i++) {
		            char ch = text.charAt(i);

		            if (Character.isLetter(ch)) {
		                result += key.charAt(keyIndex % key.length());
		                keyIndex++;
		            } else {
		                result += ch;
		            }
		        }
        return result;
	}

	// Encryption
	    static String cipherText(String text, String key) {
	        String cipher = "";

	        for (int i = 0; i < text.length(); i++) {
	            char t = text.charAt(i);
	            char k = key.charAt(i);

	            if (t >= 'A' && t <= 'Z') {
	                int x = (t - 'A' + (k - 'A')) % 26;
	                cipher += (char) (x + 'A');
	            }
	            else if (t >= 'a' && t <= 'z') {
	                int x = (t - 'a' + (k - 'A')) % 26;
	                cipher += (char) (x + 'a');
	            }
	            else {
	                cipher += t;
	            }
	        }
	        return cipher;
	    }

	    // Decryption
	    static String originalText(String cipherText, String key) {
	        String original = "";

	        for (int i = 0; i < cipherText.length(); i++) {
	            char c = cipherText.charAt(i);
	            char k = key.charAt(i);

	            if (c >= 'A' && c <= 'Z') {
	                int x = (c - 'A' - (k - 'A') + 26) % 26;
	                original += (char) (x + 'A');
	            }
	            else if (c >= 'a' && c <= 'z') {
	                int x = (c - 'a' - (k - 'A') + 26) % 26;
	                original += (char) (x + 'a');
	            }
	            else {
	                original += c;
	            }
	        }
	        return original;
	    }

	    public static void main(String[] args) {

	        String text = "GEEKSFORGEEKS";
	        String keyword = "AYUSH";

	        System.out.println("PLAINTEXT : " + text);
	        System.out.println("KEY       : " + keyword);

	        String key = generateKey(text, keyword);

	        String cipher = cipherText(text, key);
	        System.out.println("ENCRYPTED : " + cipher);

	        System.out.println("DECRYPTED : " + originalText(cipher, key));
    }

}