package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class List2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);

        //移行する画面の宣言
        Intent intentSub = new Intent(this,SubActivity.class);
        Intent intentEvent = new Intent(this,EventActivity.class);

        //画面のパーツを変数にセット
        ListView listView = findViewById(R.id.listView);
        EditText dataText = findViewById(R.id.dataText);
        Button tsuikaButtom = findViewById(R.id.tsuikabuttom);

        //1.可変長String配列
        ArrayList<String> dataList = new ArrayList<>();
        //2.配列セット用アダプター宣言
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
        //3.画面上のListViewにアダプターの配列データ表示
        listView.setAdapter(adapter);

        //　データ追加ボタン
        tsuikaButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String tT= dataText.getText().toString();
                if (!tT.equals("")){
                    //1.追加する文字例を可変長配列に追加
                    dataList.add(tT);
                    //2.リスト再表示
                    listView.setAdapter(adapter);
                    //3.テキストをクリア
                    dataText.setText("");
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i % 2){
                    case 1:
                        startActivity(intentEvent);
                        break;
                    case 2:
                        startActivity(intentSub);
                        break;
                }
            }
        });
    }
}