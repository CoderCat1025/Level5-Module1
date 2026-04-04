package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Write your message.");
		String message = scan.nextLine();
		try {
			FileWriter fw = new FileWriter("src/_01_File_Recorder/test.txt");
			fw.write(message);
			fw.close();
			scan.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
