public class CaesarCipher{
	//Code encryption
	//use StringBuffer for synchronized methods
	public static StringBuffer Encrypt(String plainText, int key){
		StringBuffer EncryptionResult = new StringBuffer();

		//for loop
		for(int i=0; i<plainText.length(); i++){
			char ch = plainText.charAt(i);
			if (ch >= 'A' && ch <= 'Z') {
			    char encrypted = (char) ((ch - 'A' + key) % 26 + 'A');
			    EncryptionResult.append(encrypted);
			}
			else if (ch >= 'a' && ch <= 'z') {
			    char encrypted = (char) ((ch - 'a' + key) % 26 + 'a');
			    EncryptionResult.append(encrypted);
			}
			else {
			    EncryptionResult.append(ch);
			}
		}

		return EncryptionResult;
	}

	//Code decryption
	public static StringBuffer Decrypt(String cipherText, int key){
		StringBuffer DecryptionResult = new StringBuffer();

		//for loop
		for(int i=0; i<cipherText.length(); i++){
			char ch = cipherText.charAt(i);
			if (ch >= 'A' && ch <= 'Z') {
			    char decrypted = (char) ((ch - 'A' - key + 26) % 26 + 'A');
			    DecryptionResult.append(decrypted);
			}
			else if (ch >= 'a' && ch <= 'z') {
			    char decrypted = (char) ((ch - 'a' - key + 26) % 26 + 'a');
			    DecryptionResult.append(decrypted);
			}
			else {
			    DecryptionResult.append(ch);
			}

		}

		return DecryptionResult;
	}

	public static void main(String[] args){
		String plainText = ("Attack At Once");
		int key = 4;
		System.out.println("PLAINTEXT: " + plainText);
		System.out.println("SHIFT: " + key);

		StringBuffer encrypted = Encrypt(plainText, key);
		System.out.println("ENCRYPTED TEXT: " +  encrypted);
		System.out.println("DECRYPTED TEXT: " +  Decrypt(encrypted.toString(), key));
	}
}