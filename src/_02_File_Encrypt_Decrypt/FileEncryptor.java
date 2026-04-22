package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user.
	 * Use the key to shift each letter in the users input and save the final result to a file.
	 */

	public static void main(String[] args) {
		encryptor(14, "wow i sure hope this works abcdefghijklmnopqrstuvwxyz");
	}

	public static void encryptor(int key, String message) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String encryptedText = "";

		for (int i=0; i < message.length(); i++) {
			if (message.charAt(i)!=' ') {
				for (int e=0; e<alphabet.length(); e++) {
					if (message.charAt(i) == alphabet.charAt(e)) {
						if (e+1>alphabet.length()-key) {
							encryptedText = encryptedText + alphabet.charAt(e+key-alphabet.length());
						} else {
							encryptedText = encryptedText + alphabet.charAt(e+key);	
						}
					}
				}
			} else {
				encryptedText = encryptedText + ' ';
			}

		}

		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/message.txt");

			fw.write(encryptedText);

			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
