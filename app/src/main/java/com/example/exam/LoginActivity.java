package com.example.exam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class  LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button loginButton;

    public final static String username_key = "com.example.Exam.username_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.etUsername);
        password = findViewById(R.id.etPassword);
        loginButton = findViewById(R.id.btnLogin);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (username.getText().toString().equals("user") && password.getText().toString().equals("1234")) {
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    String user = username.getText().toString();
                    intent.putExtra(username_key,user);
                    startActivity(intent);
                } else {
                    showAlertDialogButtonClicked();
                }
            }
        });
    }

    public void showAlertDialogButtonClicked() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Authentication Failed");
        builder.setMessage("Username and Password is Wrong,Please try Again!!");
        builder.setPositiveButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}