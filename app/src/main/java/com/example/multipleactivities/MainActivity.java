package com.example.multipleactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final String EXTRA_MESSAGE = "com.example.multipleactivities.SEND_MESSAGE";
    Button sendButton;
    EditText info;
    TextView replyInfo;
    TextView sentInfo;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendButton = findViewById(R.id.sendButton);
        info = findViewById(R.id.info);
        sentInfo = findViewById(R.id.sentInfo);
        replyInfo = findViewById(R.id.replyInfo);

        Log.d(TAG, "onCreate was called");

        sendButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra(EXTRA_MESSAGE, info.getText().toString());
            startActivity(intent);
        });

        Bundle bundle = getIntent().getExtras();

        if (bundle != null && bundle.containsKey(EXTRA_MESSAGE)) {
            String message = bundle.getString(EXTRA_MESSAGE);
            sentInfo.setText(message);
            replyInfo.setVisibility(View.VISIBLE);
        }
    }
}