package com.example.bmiweightcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtHeight = findViewById(R.id.edt_Height);
    EditText edtWeight = findViewById(R.id.edt_Weight);
    Button btnCalculate= findViewById(R.id.btn_Calculate);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public double BmiCalculator(int weight , int height){
        double bmi = 0;

        return bmi;
    }
}
