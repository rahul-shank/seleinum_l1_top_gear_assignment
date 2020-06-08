/*
 * 
 * Author: Rahul S
 * Emp Id: RA20081501
 * Last Modified: 08/06/2020
 * 
 * Topic: Topgear Selenium Hands-on
 * 
 * Features used: Selenium, Data driven(Excel), Maven-TestNG framework
 * 
 */

package Utils;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilesUtils {

	static FileWriter f;
	static FileReader fr;
	static BufferedWriter b;

	public FilesUtils(String filePath) {

		// projectPath = System.getProperty("user.dir");
		// System.out.println(projectPath);
		try {
			f = new FileWriter(filePath);
			b = new BufferedWriter(f);
			fr = new FileReader(filePath);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static void writeString(String str) {

		try {
			// b.flush();
			b.write(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void readString() {

		try {

			fr.read();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void closeFile() {

		try {
			f.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
