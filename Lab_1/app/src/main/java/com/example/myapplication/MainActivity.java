package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText userText;
    private TextView content;
    private Button button1;
    private RadioButton radio1;
    private RadioButton radio2;
    private RadioButton radio3;
    private RadioGroup radios;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userText = (EditText)findViewById(R.id.userText);
        content = (TextView)findViewById(R.id.content);
        Button button2 = (Button) findViewById(R.id.button2);
        button1 = (Button)findViewById(R.id.button1);
        radios = (RadioGroup)findViewById(R.id.radios);
        builder = new AlertDialog.Builder(this);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = userText.getText().toString();
                if (text.length() > 0) {
                    content.setText(text);
                }
                else{
                    builder.setTitle("Alert!!!")
                            .setMessage("Please fill the text field")
                            .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                }
                            })
                            .show();
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = null;
                content.setText(text);
            }
        });

        radios.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i)
                {
                    case R.id.radio1:
                        content.setTextColor(getResources().getColor(R.color.textGreen));
                        break;
                    case R.id.radio2:
                        content.setTextColor(getResources().getColor(R.color.textRed));
                        break;
                    case R.id.radio3:
                        content.setTextColor(getResources().getColor(R.color.textBlue));
                        break;
                }
            }
        });
    }
}