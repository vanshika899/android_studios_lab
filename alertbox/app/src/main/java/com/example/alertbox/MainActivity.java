package com.example.alertbox;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        loginBtn=findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user=username.getText().toString();
                String pass=password.getText().toString();

                boolean match=false;

                try{

                    BufferedReader reader=new BufferedReader(
                            new InputStreamReader(getAssets().open("users.txt"))
                    );

                    String line;

                    while((line=reader.readLine())!=null){

                        String[] data=line.split("\t");

                        if(data[0].equals(user) && data[1].equals(pass)){
                            match=true;
                            break;
                        }

                    }

                    reader.close();

                }catch(Exception e){
                    e.printStackTrace();
                }

                AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);

                if(match){
                    dialog.setMessage("Login Successful");
                }else{
                    dialog.setMessage("Login Failed");
                }

                dialog.setPositiveButton("OK",null);
                dialog.show();

            }
        });

    }
}