package com.example.testpproject.internet;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

public class Internet {

	public static void main(String[] args) {
		BufferedReader buf = null;
		InputStreamReader fr = null;
		try {

			fr = new InputStreamReader(new FileInputStream("F:/file/android/test.txt"), "GBK");
			buf = new BufferedReader(fr);

			String str = null;
			StringBuffer strBuf = new StringBuffer();

			while ((str = buf.readLine()) != null) {
				strBuf.append(str);
			}
			final String string = strBuf.toString();
			System.out.println(string);
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						post(string);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != buf) {
				try {
					buf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (null != fr) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	private static void post(String str) throws Exception {
		URL url = new URL("http://116.62.36.12:8080/gcrobot/NoticeServlet");
		URLConnection conn = url.openConnection();
		conn.setRequestProperty("accept", "*/*");
		conn.setRequestProperty("connection", "Keep-Alive");
		conn.setDoOutput(true);
		//conn.setDoInput(true);

		PrintWriter pw = new PrintWriter(conn.getOutputStream());
		pw.print("date=" + "111");
		pw.flush();

		pw.close();

	}

}
