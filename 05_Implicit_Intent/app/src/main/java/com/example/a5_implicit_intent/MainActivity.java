package com.example.a5_implicit_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button btnLaunchUrl;
    private Button btnDial;
    private Button btnShare;
    private Button btnEmail;
    private Button btnMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTextPersonName);
        btnLaunchUrl = findViewById(R.id.btnUrlLauncher);
        btnDial = findViewById(R.id.btnDial);
        btnShare = findViewById(R.id.btnShare);
        btnEmail = findViewById(R.id.btnEmail);
        btnMessage = findViewById(R.id.btnMessage);

        btnLaunchUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String url = editText.getText().toString();
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    Toast.makeText(MainActivity.this,url , Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }
        });

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iDial = new Intent(Intent.ACTION_DIAL);
                iDial.setData(Uri.parse("tel: +919354356689"));
                startActivity(iDial);
            }
        });

        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iMessage = new Intent(Intent.ACTION_SENDTO);
                iMessage.setData(Uri.parse("smsto: "+ Uri.encode("+919354356689")));  //receiver's phone number
                iMessage.putExtra("sms_body","Hello there!");  //sms_body key is predefined
                startActivity(iMessage);
            }
        });
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iEmail = new Intent(Intent.ACTION_SEND); // ACTION_SEND used to all apps like whatsapp, email, messenger
                iEmail.setType("message/rfc822"); //rfc822 for email
                iEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"deepakkudc@gmail.com","trojanhorsedc@gmail.com"});  //can pass more than one email here
                iEmail.putExtra(Intent.EXTRA_SUBJECT, "Queries");
                iEmail.putExtra(Intent.EXTRA_TEXT,"Hello everyone, this mail is for email testing");
                startActivity(Intent.createChooser(iEmail,"Email Via")); //Create Bottomsheet for multiple email apps

            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iShare = new Intent(Intent.ACTION_SEND);
                iShare.setType("text/plain");
                iShare.putExtra(Intent.EXTRA_TEXT,"Use this url https://google.com");
                startActivity(Intent.createChooser(iShare,"Share via")); //Bottom sheet for all share apps
            }
        });

    }
}