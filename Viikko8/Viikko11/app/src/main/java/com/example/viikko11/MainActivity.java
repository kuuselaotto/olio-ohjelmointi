package com.example.viikko11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textOutput;
    private EditText textInput1, textInput2;
    private int n1, n2, sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textOutput = findViewById(R.id.textView);
        textInput1 = findViewById(R.id.textInput1);
        textInput2 = findViewById(R.id.textInput2);

    }

    public void Summary(View view) {

        n1 = Integer.parseInt(textInput1.getText().toString());
        n2 = Integer.parseInt(textInput2.getText().toString());
        sum = n1 + n2;
        textOutput.setText(Integer.toString(sum));
    }

    public void Difference(View view) {

        n1 = Integer.parseInt(textInput1.getText().toString());
        n2 = Integer.parseInt(textInput2.getText().toString());
        sum = n1 - n2;
        textOutput.setText(Integer.toString(sum));

    }

    public void Multiply(View view) {

        n1 = Integer.parseInt(textInput1.getText().toString());
        n2 = Integer.parseInt(textInput2.getText().toString());
        sum = n1 * n2;
        textOutput.setText(Integer.toString(sum));

    }

    public void Division(View view) {

        n1 = Integer.parseInt(textInput1.getText().toString());
        n2 = Integer.parseInt(textInput2.getText().toString());

        if (n2 != 0) {
            sum = n1 / n2;
            textOutput.setText(Integer.toString(sum));

        } else {
            Toast.makeText(this, "Et voi jakaa nollalla!", Toast.LENGTH_SHORT).show();
            textOutput.setText("");
        }
    }
}