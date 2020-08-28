package com.example.talku_talku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeScreen extends AppCompatActivity {
    private Button button;
    private Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        button = findViewById(R.id.signInButton);
        signUpButton = findViewById(R.id.signUpButton);

        // sign In button to open the activity when clicked
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeScreen.this, SignIn.class);
                startActivity(intent);
            }
        });

        // sign Up button to open the activity when clicked
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeScreen.this, SignUp.class);
                startActivity(intent);
            }
        });

    }

}