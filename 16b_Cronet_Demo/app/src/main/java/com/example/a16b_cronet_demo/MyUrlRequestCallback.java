package com.example.a16b_cronet_demo;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.chromium.net.CronetException;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;

import java.nio.ByteBuffer;

public class MyUrlRequestCallback extends UrlRequest.Callback {
    private static final String TAG = "MyUrlRequestCallback";
    private Context context;

    MyUrlRequestCallback(Context context){
        this.context=context;
    }
    @Override
    public void onRedirectReceived(UrlRequest request, UrlResponseInfo info, String newLocationUrl) throws Exception {
        Log.i(TAG, "onRedirectReceived method called.");
        // You should call the request.followRedirect() method to continue
        // processing the request.
        request.followRedirect();
    }

    @Override
    public void onResponseStarted(UrlRequest request, UrlResponseInfo info) throws Exception {
        Log.i(TAG, "onResponseStarted method called.");
        int statusCode = info.getHttpStatusCode();
        Log.i(TAG, "onResponseStarted: STATUS CODE "+statusCode);
        if (statusCode == 200) {

            // The request was fulfilled. Start reading the response.
        } else if (statusCode == 503) {
            // The service is unavailable. You should still check if the request
            // contains some data.
        }
        // You should call the request.read() method before the request can be
        // further processed. The following instruction provides a ByteBuffer object
        // with a capacity of 102400 bytes for the read() method. The same buffer
        // with data is passed to the onReadCompleted() method.
        request.read(ByteBuffer.allocateDirect(102400));
    }

    @Override
    public void onReadCompleted(UrlRequest request, UrlResponseInfo info, ByteBuffer byteBuffer) throws Exception {
        Log.i(TAG, "onReadCompleted method called.");
        // You should keep reading the request until there's no more data.
        String data = new String(byteBuffer.array(), 0, byteBuffer.position());
        TextView txtvResponse = (TextView) ((Activity)context).findViewById(R.id.txtvResponse);
        ((Activity)context).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                txtvResponse.setText(data);
            }
        });
        Log.i(TAG, "onReadCompleted Data : "+data);
        byteBuffer.clear();
        request.read(byteBuffer);

    }

    @Override
    public void onSucceeded(UrlRequest request, UrlResponseInfo info) {
        Log.i(TAG, "onSucceeded method called.");

    }

    @Override
    public void onFailed(UrlRequest request, UrlResponseInfo info, CronetException error) {
        Log.i(TAG, "onFailed method called.");
//        error.printStackTrace();
        Log.e(TAG, "onFailed, ERROR : ",error);

    }


}
