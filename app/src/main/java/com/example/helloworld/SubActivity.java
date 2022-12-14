package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_sub);
         setContentView(R.layout.activity_const);
       // setContentView(R.layout.activity_const2);

        //setTitle("Sub Activity");
        // 画面上のパーツ

        TextView namelabel = findViewById(R.id.nameLabel);
        EditText nameText = findViewById(R.id.namae2);
        Button clearButton = findViewById(R.id.clearButton2);
        Button sendButton = findViewById(R.id.sendButton);
        Button comfirmButton = findViewById(R.id.comfirmButton);


        namelabel.setText("Name");

        sendButton.setOnClickListener(this);
        comfirmButton.setOnClickListener(this);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameText.setText("");
            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent( this ,EventActivity.class);

        setTitle("Buttom Clicked");

        switch(view.getId())
        {
            case R.id.comfirmButton:
                setTitle("確認Button Clicked");
                Toast.makeText(this,"確認クリック", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sendButton:
                setTitle("送信Button Clicked");
                Toast.makeText(this,"送信クリック", Toast.LENGTH_SHORT).show();
                intent.putExtra("age", 19);
                startActivity(intent);
                break;
        }
    }
}