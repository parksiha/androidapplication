package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MEMO = 101;
    public static final int REQUEST_CODE_TIME = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button timebutton = findViewById(R.id.buttontime);
        timebutton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), timeActivity.class);
                startActivityForResult(intent, REQUEST_CODE_TIME);

            }
        });

        Button memobutton = findViewById(R.id.button2);
        memobutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), memoActivity.class);
                startActivityForResult(intent, REQUEST_CODE_MEMO);

            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data != null) {
            if(requestCode == REQUEST_CODE_TIME){
                Toast.makeText(getApplicationContext(),
                        "홈으로 돌아옴. 요청 코드 : "+ requestCode +
                        ", 결과 코드 : " + resultCode, Toast.LENGTH_LONG).show();
                if(resultCode == RESULT_OK){
                    String name = data.getStringExtra("name");
                    Toast.makeText(getApplicationContext(), "응답으로 전달된 name : " + name,
                            Toast.LENGTH_LONG).show();
                }
            }
            if (requestCode == REQUEST_CODE_MEMO) {
                Toast.makeText(getApplicationContext(),
                        "홈으로 돌아옴. 요청 코드 : " + requestCode +
                                ", 결과 코드 : " + resultCode, Toast.LENGTH_LONG).show();
                if (resultCode == RESULT_OK) {
                    String name = data.getStringExtra("name");
                    Toast.makeText(getApplicationContext(), "응답으로 전달된 name : " + name,
                            Toast.LENGTH_LONG).show();
                }
            }
        }

    }
}