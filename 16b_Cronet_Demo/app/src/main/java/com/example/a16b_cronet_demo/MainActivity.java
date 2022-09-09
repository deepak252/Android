package com.example.a16b_cronet_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.chromium.net.CronetEngine;
import org.chromium.net.UrlRequest;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResponse;
    private EditText editTextUrl;
    private Button btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResponse=findViewById(R.id.txtvResponse);
        editTextUrl=findViewById(R.id.edtLink);
        btnSend=findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendRequest(editTextUrl.getText().toString());
            }
        });


    }

    private void sendRequest(String url){CronetEngine.Builder engineBuilder = new CronetEngine.Builder(this);
        CronetEngine engine = engineBuilder.build();
        Executor executor = Executors.newSingleThreadExecutor();
        MyUrlRequestCallback callback = new MyUrlRequestCallback(this);
        UrlRequest.Builder requestBuilder = engine.newUrlRequestBuilder(
                url, callback, executor);
        UrlRequest request = requestBuilder.build();
        request.start();


//        Log.d("MyUrlRequestCallback",this.getFilesDir().getAbsolutePath());
//        Log.d("MyUrlRequestCallback", Environment.getExternalStoragePublicDirectory(
//                Environment.DIRECTORY_DOWNLOADS
//        ).toString());
//        final String storagePath = Environment.getExternalStoragePublicDirectory(
//                Environment.DIRECTORY_DOWNLOADS
//        ).toString();
//        CronetEngine engine = engineBuilder
//                .setStoragePath(storagePath)
//                .enableHttpCache(CronetEngine.Builder.HTTP_CACHE_DISK_NO_HTTP, 100 * 1024)
//                .build();

    }
}