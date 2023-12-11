package com.example.hw_android3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText emailText;
    private TextInputEditText themeText;
    private TextInputEditText messageText;
    private MaterialButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailText = findViewById(R.id.email_text);
        themeText = findViewById(R.id.theme_text);
        messageText = findViewById(R.id.message_text);
        button = findViewById(R.id.material_button);

        button.setOnClickListener(view -> {
            System.out.println(emailText.getText().toString());
            String[] TO = {emailText.getText().toString()};
            final Intent intent = new Intent(android.content.Intent.ACTION_SEND, Uri.fromParts("mailto", "", null))
                    .setType("plain/text")
                    .putExtra(android.content.Intent.EXTRA_EMAIL, TO)
                    .putExtra(Intent.EXTRA_SUBJECT, themeText.getText().toString())
                    .putExtra(Intent.EXTRA_TEXT, messageText.getText().toString());
            startActivity(intent);
        });


    }
}