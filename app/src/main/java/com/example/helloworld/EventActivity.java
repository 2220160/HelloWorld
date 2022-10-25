package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class EventActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        //  呼び画面から
        Intent intent=getIntent();
        int age = intent.getIntExtra("age",25);

        //確認
        Toast.makeText(this,"年齢"+age,Toast.LENGTH_SHORT).show();

        //画面のパーツを登録
        TextView textProfile = findViewById(R.id.textprofile);
        EditText namae2 = findViewById(R.id.namae2);
        EditText password = findViewById(R.id.password);
        Button clearButtom = findViewById(R.id.clearbuttom);
        Button clearButtom2 = findViewById(R.id.clearbuttom2);
        CheckBox check10 = findViewById(R.id.check10);
        CheckBox check20 = findViewById(R.id.check20);
        CheckBox check30 = findViewById(R.id.check30);
        RadioButton radioButton = findViewById(R.id.rbMan);
        RadioButton radioButton1 = findViewById(R.id.rbWoman);
        Button comfirmButtom = findViewById(R.id.comfirmButton);


        clearButtom.setOnClickListener(this);
        clearButtom2.setOnClickListener(this);
        comfirmButtom.setOnClickListener(this);


        clearButtom.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                setTitle(password.getText());
                return false;
            }
        });

        comfirmButtom.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
           public boolean onLongClick(View view) {
                if (radioButton.isChecked() == true) {
                    Toast.makeText(getApplicationContext(),R.string.man, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),R.string.woman, Toast.LENGTH_SHORT).show();
                }
                finish();//画面消える

                return false;

            }
        });
    }

        @Override
        public void onClick (View view){
            EditText namae2 = findViewById(R.id.namae2);
            EditText password = findViewById(R.id.password);
            switch (view.getId()) {
                case R.id.clearbuttom2:
                    namae2.setText("");
                    break;
                case R.id.clearbuttom:
                    password.setText("");
                    setTitle(R.string.app_name);
                    break;
                case R.id.comfirmButton:
                    Toast.makeText(this, namae2.getText(), Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }