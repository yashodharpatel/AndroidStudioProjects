package com.example.unconvert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView2 = findViewById(R.id.textView2);
        editText = findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(editText.getText().toString())){
                    editText.setError("Please enter the value of kg");
                }
                else{
                    String s = editText.getText().toString();
                    long kg = Integer.parseInt(s);
                    double pound = 2.20462 * kg;
                    textView2.setText(kg+" in pounds is "+String.format("%.2f", pound));
                    editText.setText("");
                    Toast.makeText(MainActivity.this, s+" is converted into pounds", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}