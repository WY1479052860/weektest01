package com.bawei.wangyi20200224.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 网络工具类
 */
public class NetUtils {
    //单例模式
    public static NetUtils netUtils=new NetUtils();

    public NetUtils() {
    }
    public static NetUtils getNetUtils() {
        return netUtils;
    }
    //创建Handler
    private Handler handler=new Handler();
    //接口回调
    public interface ICallBack{
        void Success(String json);
        void Error(String msg);
    }
    //网络判断的方法
    public boolean isNet(Context context){
       ConnectivityManager cm= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
       NetworkInfo info = cm.getActiveNetworkInfo();
       if(info!=null){
           return true;
       }
        return false;
    }
    //网络获取json文件
    public void getJson(final String JsonUrl, final ICallBack iCallBack){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(JsonUrl);
                    HttpURLConnection conn= (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setConnectTimeout(5000);
                    conn.setReadTimeout(5000);
                    int responseCode = conn.getResponseCode();
                    if(responseCode==200){
                        InputStream inputStream = conn.getInputStream();
                        int len=0;
                        byte[] by=new byte[1024];
                        StringBuffer sb = new StringBuffer();
                        while((len=inputStream.read(by))!=-1){
                            String s = new String(by, 0, len);
                            sb.append(s);
                        }
                        inputStream.close();
                        final String json = sb.toString();
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                if(iCallBack!=null){
                                    iCallBack.Success(json);
                                }
                            }
                        });

                    }else{
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                if(iCallBack!=null){
                                    iCallBack.Error("请求失败");
                                }
                            }
                        });
                    }

                } catch (final Exception e) {
                    e.printStackTrace();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            if(iCallBack!=null){
                                iCallBack.Error(e.toString());
                            }
                        }
                    });
                }
                }

        }).start();

    }
}
