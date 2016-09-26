package com.dineo.bmi;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double height = 0;
    double BMI_result;

    EditText height_input;
    RadioGroup weight_input;
    RadioButton small;
    RadioButton med;
    RadioButton large;

    Button btnCalculate;
    TextView BMI_result_txt;
    String ans =(" "+ BMI_result);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height_input = (EditText)findViewById(R.id.edt_Height);
        weight_input =(RadioGroup)findViewById(R.id.weight_rg);
        btnCalculate =(Button)findViewById(R.id.btn_Calc);
        BMI_result_txt = (TextView)findViewById(R.id.results_txt);
        small = (RadioButton)findViewById(R.id.small_rgb);
        med = (RadioButton)findViewById(R.id.medium_rgb);
        large = (RadioButton)findViewById(R.id.large_rgb);


        btnCalculate.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                calculateBMI();
            }

        });



    }
    public void Weights(View v){
        int id = v.getId();




       /* String small = (" "+rg_small);
        String medium = (" "+rg_med);
        String large = (" "+rg_large);
        String ans =(" "+ BMI_result);*/
//        height = Double.valueOf( (height_input.getText().toString()));
        try{
            if(String.valueOf(height) == "1.0"){
                switch (id){
                    case R.id.small_rgb:
                        calculateBMI();
                        break;

                    case R.id.medium_rgb:
                        calculateBMI();
                        break;

                    case R.id.large_rgb:
                        calculateBMI();
                        break;

                }}


        }catch (NumberFormatException e){
        BMI_result_txt.setText("ENTER HEIGHT");

    }}



    public void calculateBMI(){


        double rg_small = 49.0;
        double rg_med = 65.0;
        double rg_large = 100.0;
        String ans =(" "+ BMI_result);

        if(small.isChecked()){
            calculator(rg_small);
            Toast.makeText(this,ans,Toast.LENGTH_SHORT).show();
            BMI_result_txt.setText(Double.toString(BMI_result));
        }

        if(med.isChecked()){
            calculator(rg_med);
            BMI_result_txt.setText(Double.toString(BMI_result));

        }
        if(large.isChecked()){
            calculator(rg_large);
            BMI_result_txt.setText(Double.toString(BMI_result));
        }




        }
    private double calculator(double weight){

        height = Double.parseDouble( (height_input.getText().toString()));
        BMI_result = weight /(Math.pow(height,2));
        return BMI_result;
    }

    }

