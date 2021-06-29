package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    TextView output;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.tf_username);
        password = findViewById(R.id.tf_password);
        output  = findViewById(R.id.l_output);
        button = findViewById(R.id.btn_login);

        button.setOnClickListener(v -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();

            if (user.isEmpty()){
                username.setError("Empty user name");
                username.requestFocus();
            } else if (pass.isEmpty()){
                password.setError("Empty password");
                password.requestFocus();
            } else {
                /*
                * output.setText("SUCCESS");
                * */

                Intent intent = new Intent(MainActivity.this, HomeScreen.class);
                intent.putExtra("username", user);
                MainActivity.this.startActivity(intent);
            }
        });



    }
}