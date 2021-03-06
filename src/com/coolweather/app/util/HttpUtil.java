package com.coolweather.app.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.util.Log;

@SuppressWarnings("unused")
public class HttpUtil {
	public static void sendHttpRequest(final String address, final HttpCallbackListener listener) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				HttpURLConnection connection = null;
				URL url;
				try {
					url = new URL(address);
					connection = (HttpURLConnection) url.openConnection();
					connection.setRequestMethod("GET");
					connection.setConnectTimeout(8000);
					connection.setReadTimeout(8000);
					//connection.setRequestProperty("apikey",  "25ebb13e85cc832df972775571952ac8");
					//connection.connect();
					InputStream in = connection.getInputStream();
					BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
					StringBuilder response = new StringBuilder();
					String line;
					while((line = reader.readLine()) != null) {
						response.append(line);
					}
					if(listener != null) {
						listener.onFinish(response.toString());
						Log.d("HttpUtil", response.toString());
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					if(listener != null) {
						listener.onError(e);
					}
				}finally {
					if(connection != null) {
						connection.disconnect();
					}
						
				}
				
			}
			
		}).start();
	}
}
