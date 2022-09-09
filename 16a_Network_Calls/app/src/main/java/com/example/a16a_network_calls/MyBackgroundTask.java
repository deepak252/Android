package com.example.a16a_network_calls;

import android.os.AsyncTask;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyBackgroundTask extends AsyncTask{
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d("MyBackgroundTask","onPreExecute");
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        Log.d("MyBackgroundTask","doInBackground");
        String result="";
        HttpURLConnection conn;
        try{
            URL url = new URL((String) objects[0]);
            conn = (HttpURLConnection)url.openConnection();
            InputStream in = conn.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            int data = reader.read();
            while(data!=-1){
                char current = (char)data;
                result+=current;
                data = reader.read();
            }
        }catch (Exception e){
            e.printStackTrace();
            return "doInBackground: Something went wrong -> "+e.toString();
        }

        return result;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        Log.d("MyBackgroundTask","onPostExecute");
        Log.d("MyBackgroundTask",o.toString());
    }

//    @Override
//    protected String doInBackground(String... urls) {
//        Log.d("MyBackgroundTask","doInBackground");
//        String result="";
//        HttpURLConnection conn;
//        try{
//            URL url = new URL(urls[0]);
//            conn = (HttpURLConnection)url.openConnection();
//            InputStream in = conn.getInputStream();
//            InputStreamReader reader = new InputStreamReader(in);
//            int data = reader.read();
//            while(data!=-1){
//                char current = (char)data;
//                result+=current;
//                data = reader.read();
//            }
//        }catch (Exception e){
//            return "Something went wrong";
//        }
//
//        return result;
//    }
}
