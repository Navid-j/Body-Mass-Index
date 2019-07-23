package com.example.bmiweightcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtHeight;
    EditText edtWeight;
    Button btnCalculate;

    ImageView bodyIcons;
    TextView tvBMI;
    TextView tvRecommendation;
    TextView tvBodyStatus;
    ConstraintLayout aboutLayout;
    ConstraintLayout resultLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtHeight = findViewById(R.id.edt_Height);
        edtWeight = findViewById(R.id.edt_Weight);
        btnCalculate= findViewById(R.id.btn_Calculate);

        bodyIcons = findViewById(R.id.img_Body_icons);
        tvBMI = findViewById(R.id.tv_BMI);
        tvRecommendation = findViewById(R.id.tv_Recommendation);
        tvBodyStatus = findViewById(R.id.tv_Body_Status);
        aboutLayout = findViewById(R.id.about);
        resultLayout = findViewById(R.id.layout_Result);

        final InputMethodManager keybord = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //Empty Check
                if (edtHeight.getText().toString().isEmpty() ||
                        edtWeight.getText().toString().isEmpty() ||
                        edtHeight.getText().toString().matches("0") ||
                        edtWeight.getText().toString().matches("0")) {
                    Toast.makeText(MainActivity.this, R.string.warn, Toast.LENGTH_LONG).show();

                }else {

                    keybord.hideSoftInputFromWindow(edtWeight.getWindowToken(),0);

                    int height = Integer.parseInt(edtHeight.getText().toString());
                    int weight = Integer.parseInt(edtWeight.getText().toString());

                    resultLayout.setVisibility(View.VISIBLE);
                    aboutLayout.setVisibility(View.GONE);
                    float result = BmiCalculator(weight,height);

                    tvBMI.setText(Float.toString(result));

                    if (result <= 18.5){
                        tvRecommendation.setText(R.string.under_Weight_Recommendation);
                        tvBodyStatus.setText(R.string.under_Weight);
                        tvBodyStatus.setBackgroundResource(R.color.colorBlue);
                        bodyIcons.setBackgroundResource(R.drawable.ic_under_weight);
                    }else if (result <= 24.9){
                        tvRecommendation.setText(R.string.normal_Weight_Recommendation);
                        tvBodyStatus.setText(R.string.normal_Weight);
                        tvBodyStatus.setBackgroundResource(R.color.colorGreen);
                        bodyIcons.setBackgroundResource(R.drawable.ic_normal_weight);
                    }else if (result <= 34.9){
                        tvRecommendation.setText(R.string.fat_Recommendation);
                        tvBodyStatus.setText(R.string.fat);
                        tvBodyStatus.setBackgroundResource(R.color.colorOrange);
                        bodyIcons.setBackgroundResource(R.drawable.ic_fat);
                    }else if (result >= 35){
                        tvRecommendation.setText(R.string.very_fat_Recommendation);
                        tvBodyStatus.setText(R.string.very_fat);
                        tvBodyStatus.setBackgroundResource(R.color.colorRed);
                        bodyIcons.setBackgroundResource(R.drawable.ic_very_fat);
                    }
                }
            }
        });
    }

    public Float BmiCalculator(int weight , int height){

        float h = (float) height / 100;
        float heightSquared = h*h;

        return weight / heightSquared;
    }
}
