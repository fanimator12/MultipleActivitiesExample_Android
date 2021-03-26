package com.example.multipleactivities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.multipleactivities.MainActivity.EXTRA_MESSAGE;

public class SecondActivity extends AppCompatActivity {

    TextView sentInfo;
    TextView info;
    EditText replyMessage;
    Button replyButton;

    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.d(TAG, "onCreate was called");

        info = findViewById(R.id.info);
        sentInfo = findViewById(R.id.sentInfo);
        replyButton = findViewById(R.id.replyButton);
        replyMessage = findViewById(R.id.replyMessage);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null && bundle.containsKey(EXTRA_MESSAGE)) {
            String message = bundle.getString(EXTRA_MESSAGE);
            sentInfo.setText(message);
        }

        replyButton.setOnClickListener(view -> {
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);
            intent.putExtra(EXTRA_MESSAGE, replyMessage.getText().toString());
            startActivity(intent);
        });
    }
}
