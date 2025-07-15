package opening;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyFiles {
	private FileOutputStream out;
	private FileInputStream in;
	
	public MyFiles(String inputFilesName, String outputFileName) {
		openInput(inputFilesName);
		openInput(outputFileName);	
		
	}
	
	public void openInput(String fileName) {		
		try {
			in = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	 }
	
	public void write(int aByte) {
		try {
			out.write(aByte);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int read() {
		int readValue = 0;
		try {
			readValue = in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return readValue;
	}
	
	public void close() {
		try {
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void caesar(int n) {
		final int EOF = -1;
		int readByte;
		int encodedByte;
		do {
			readByte = read();
			encodedByte = (readByte + n) % 256;
			write(encodedByte);
		} while (readByte != EOF);
	}
}
