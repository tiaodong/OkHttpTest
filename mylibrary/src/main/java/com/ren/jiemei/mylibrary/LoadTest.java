package com.ren.jiemei.mylibrary;

import android.os.AsyncTask;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2016/12/26 0026.
 */

public class LoadTest extends AsyncTask<Void,Void,byte[]>{

    public static LoadTest loadtest;

    private byte[] data;

    private String url;
    public setDataL listence;


    public void setDataListence(setDataL l){
        this.listence = l;
    }
    public byte[] getload(){

        return data;
    }

    public void  setUrl(String s){
        this.url = s;
    }
    @Override
    protected byte[] doInBackground(Void... params) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            URL urlimage = new URL(url);
            HttpURLConnection urlconn = (HttpURLConnection) urlimage.openConnection();
            urlconn.setConnectTimeout(5000);
            urlconn.setRequestMethod("GET");
            int sumLenght = urlconn.getContentLength();
            LogUtil.shoelog(this.getClass().getCanonicalName(),sumLenght+"");
            InputStream errorStream = urlconn.getErrorStream();
            int code = urlconn.getResponseCode();
            if (HttpURLConnection.HTTP_OK == code){
                InputStream is = urlconn.getInputStream();
                byte[] buff = new byte[512];
                int len;
                while ((len = is.read(buff))!= -1){
                    outputStream.write(buff,0,len);

                }
                is.close();
                outputStream.flush();
                data = outputStream.toByteArray();

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    protected void onPostExecute(byte[] datainfo) {
        if (null != datainfo){

            listence.getData(datainfo);
        }else {

            super.onPostExecute(datainfo);
        }
    }

    public interface setDataL{
        void getData(byte[] data);
    }

}
