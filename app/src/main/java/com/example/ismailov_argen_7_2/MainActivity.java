package com.example.ismailov_argen_7_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
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
            isOperationClick = false;
        }
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
            } else if (operation.equals("-")) {
                result = first - second;
                textView.setText(result.toString());
            } else if (operation.equals("*")) {
                result = first * second;
                textView.setText(result.toString());
            } else if (operation.equals("/")) {
                if(second==0){
                    Toast.makeText(this,"нельзя на ноль делить",Toast.LENGTH_SHORT).show();
                }
                else {
                    result = first / second;
                    textView.setText(result.toString());
                }
            }
        }
        isOperationClick = true;

    }
}


