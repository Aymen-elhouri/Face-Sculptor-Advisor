package com.example.facesculptguide26;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {

    private TextView resultTextView;
    private String operand1 = "";
    private String operator = "";
    private boolean isOperand1Ready = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);



        resultTextView = findViewById(R.id.resultTextView);
    }

    public void onDigitClick(View view) {
        Button button = (Button) view;
        String digit = button.getText().toString();

        if (isOperand1Ready) {
            resultTextView.setText("");
            isOperand1Ready = false;
        }

        operand1 += digit;
        resultTextView.append(digit);
    }

    public void onOperatorClick(View view) {
        Button button = (Button) view;
        operator = button.getText().toString();
        isOperand1Ready = true;
    }

    public void onEqualClick(View view) {
        if (isOperand1Ready) {
            return; // Do nothing if there is no second operand
        }

        String operand2 = resultTextView.getText().toString();
        double result = performOperation(Double.parseDouble(operand1), Double.parseDouble(operand2), operator);
        resultTextView.setText(String.valueOf(result));
        operand1 = String.valueOf(result);
        isOperand1Ready = true;
    }

    private double performOperation(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "x":
                return operand1 * operand2;
            case "/":
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    return Double.NaN; // Handle division by zero
                }
            default:
                return Double.NaN; // Handle unsupported operator
        }
    }

    public void onClearClick(View view) {
        operand1 = "";
        operator = "";
        isOperand1Ready = false;
        resultTextView.setText("");
    }
}
