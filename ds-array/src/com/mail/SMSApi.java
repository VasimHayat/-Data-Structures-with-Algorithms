package com.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;

public class SMSApi {

    public static void main(String[] args) throws Exception {
        String msg = sendSms("9958499555","This is testing");
        System.out.println(msg);
    }

    public void apiKeys(){
        ArrayList keyArray = new ArrayList();
        keyArray.add("MzQ2ZDY3NWEzNDQxNDM1MzVhNmQ1NDc1Nzg1MTMxMzQ=");
        keyArray.add("b7kymC+mP6w-3xymyyVOMmpWBGkhEyMVOqnryi2tb3");
    }

    public static String sendSms(String number,String text) {
        try {
            // Construct data
            String apiKey = "apikey=" + "RtLF+I72e1g-0VTdHhSXEB4Y7Ma18EKGeaKikCh41v";
            String message = "&message=" + text;
            String sender = "&sender=" + "Zanimo";
            String numbers = "&numbers=" + number;

            // Send data
            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
            String data = apiKey + numbers + message + sender;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes("UTF-8"));
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            final StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuffer.append(line);
            }
            rd.close();

            return stringBuffer.toString();
        } catch (Exception e) {
            System.out.println("Error SMS "+e);
            return "Error "+e;
        }
    }
}
