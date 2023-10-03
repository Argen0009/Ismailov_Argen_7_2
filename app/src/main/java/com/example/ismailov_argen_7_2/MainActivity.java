package com.example.ismailov_argen_7_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Integer first, second, result;
    private String operation;
    private Boolean isOperationClick;
    private Button nextButton;
    private Intent StyleActivity;
    public static final String KEY = "Amount";
    public void onStyleActivity(View view) {
        String result = textView.getText().toString();
        StyleActivity.putExtra(KEY, result);
        startActivity(StyleActivity);
    }



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
                 Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                StyleActivity = new Intent(this, MainActivity.class);
            nextButton = findViewById(R.id.btn__next);
            nextButton.setVisibility(View.GONE);
            }

    public void onNumberClick(View view) {
        if (view.getId() == R.id.AC) {
            textView.setText("0");
            first = 0;
            second = 0;

        } else {
            String textButton = ((Button) view).getText().toString();
            if (textView.getText().toString().equals("0") || isOperationClick) {
                textView.setText(textButton);
            } else {
                textView.append(textButton);
            }
        }if (view.getId() == R.id.equal) {
        nextButton.setVisibility(View.VISIBLE);
    } else {
        nextButton.setVisibility(View.GONE);
    }
        isOperationClick = false;
    }

        public void onNextActivity(View view) {
            String result = textView.getText().toString();
            StyleActivity.putExtra(KEY, result);
            startActivity(StyleActivity);
        }

    public void onOperationClick(View view) {
        if (view.getId() == R.id.pluss) {
            operation = "+";
            first = Integer.valueOf(textView.getText().toString());
            isOperationClick = true;
        } else if (view.getId() == R.id.min) {
            operation = "-";
            first = Integer.valueOf(textView.getText().toString());
            isOperationClick = true;
        } else if (view.getId() == R.id.multiply) {
            operation = "*";
            first = Integer.valueOf(textView.getText().toString());
            isOperationClick = true;

        } else if (view.getId() == R.id.division) {
            operation = "/";
            first = Integer.valueOf(textView.getText().toString());
            isOperationClick = true;


        } else if (view.getId() == R.id.equal) {
            second = Integer.valueOf(textView.getText().toString());
            if (operation.equals("+")) {
                result = first + second;
                textView.setText(result.toString());
                nextButton.setVisibility(View.VISIBLE);
            } else if (operation.equals("-")) {
                result = first - second;
                textView.setText(result.toString());
                nextButton.setVisibility(View.VISIBLE);
            } else if (operation.equals("*")) {
                result = first * second;
                textView.setText(result.toString());
                nextButton.setVisibility(View.VISIBLE);
            } else if (operation.equals("/")) {
                if(second==0){
                    Toast.makeText(this,"нельзя на ноль делить",Toast.LENGTH_SHORT).show();
                }
                else {
                    result = first / second;
                    textView.setText(result.toString());
                    nextButton.setVisibility(View.VISIBLE);
                }
            }
        }


        isOperationClick = true;
    }
}


