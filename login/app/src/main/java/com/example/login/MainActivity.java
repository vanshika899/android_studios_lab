package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.app.AlertDialog;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(v -> checkLogin());
    }

    void checkLogin() {

        String user = username.getText().toString();
        String pass = password.getText().toString();
        boolean found = false;

        try {

            InputStream is = getAssets().open("users.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String line;

            while((line = reader.readLine()) != null){

                String[] data = line.split("\t");

                if(data[0].equals(user) && data[1].equals(pass)){
                    found = true;
                    break;
                }
            }

            reader.close();

        } catch(Exception e){
            e.printStackTrace();
        }

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        if(found)
            dialog.setMessage("Login Successful");
        else
            dialog.setMessage("Login Failed");

        dialog.setPositiveButton("OK", null);
        dialog.show();
    }
}