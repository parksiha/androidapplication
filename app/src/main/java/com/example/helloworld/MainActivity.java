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
    public static final int REQUEST_CODE_LOCATE = 134;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button timebutton = findViewById(R.id.buttontime);
        timebutton.setOnClickListener(new View.OnClickListener(){
            @Override
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
        Button buttonlocate = findViewById(R.id.button3);
        buttonlocate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), locateActivity.class);
                startActivityForResult(intent, REQUEST_CODE_LOCATE);

            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data != null) {
            if(requestCode == REQUEST_CODE_TIME){
                if(resultCode == RESULT_OK){
                    String name = data.getStringExtra("name");
                    Toast.makeText(getApplicationContext(), "메인으로 돌아옴 name : " + name,
                            Toast.LENGTH_LONG).show();
                }
            }
            if (requestCode == REQUEST_CODE_MEMO) {
                if (resultCode == RESULT_OK) {
                    String name = data.getStringExtra("name");
                    Toast.makeText(getApplicationContext(), "메인으로 돌아옴 name : " + name,
                            Toast.LENGTH_LONG).show();
                }
            }
            if (requestCode == REQUEST_CODE_LOCATE) {
                if (resultCode == RESULT_OK) {
                    String name = data.getStringExtra("name");
                    Toast.makeText(getApplicationContext(), "메인으로 돌아옴 name : " + name,
                            Toast.LENGTH_LONG).show();
                }
            }
        }

    }
}