package com.jd.omega.jdutil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtilJD {
	
	public static String TextFileRead(String path) {
		String cmd = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String st;			
			while ((st = br.readLine()) != null) {
				cmd += st + "\n";
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cmd;
	}
}
