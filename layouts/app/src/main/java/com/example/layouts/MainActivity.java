package com.example.layouts;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText username, password, address, age;
    RadioGroup genderGroup;
    Spinner state;
    DatePicker dob;
    TextView result;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        address = findViewById(R.id.address);
        age = findViewById(R.id.age);
        genderGroup = findViewById(R.id.genderGroup);
        state = findViewById(R.id.state);
        dob = findViewById(R.id.dob);
        result = findViewById(R.id.result);
        submit = findViewById(R.id.submit);

        String states[] = {"Delhi","Mumbai","Gujarat","UP","Bihar"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, states);
        state.setAdapter(adapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = username.getText().toString();
                String pass = password.getText().toString();
                String addr = address.getText().toString();
                String ag = age.getText().toString();

                int selectedId = genderGroup.getCheckedRadioButtonId();
                RadioButton genderBtn = findViewById(selectedId);
                String gender = genderBtn.getText().toString();

                String st = state.getSelectedItem().toString();

                int day = dob.getDayOfMonth();
                int month = dob.getMonth()+1;
                int year = dob.getYear();

                String output =
                        "Username: "+name+
                                "\nPassword: "+pass+
                                "\nAddress: "+addr+
                                "\nGender: "+gender+
                                "\nAge: "+ag+
                                "\nDOB: "+day+"/"+month+"/"+year+
                                "\nState: "+st;

                result.setText(output);
            }
        });
    }
}