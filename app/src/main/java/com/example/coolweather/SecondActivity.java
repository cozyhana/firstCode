package com.example.coolweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends BaseActivity {

    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
//        1
        Intent intent = getIntent();
        String data = intent.getStringExtra("param1");
        Log.d(TAG, "onCreate: " + data);
//        2
//        Button button = (Button) findViewById(R.id.button2);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent();
//                intent.putExtra("data_return","Hi First");
//                setResult(1,intent);
//                finish();
//            }
//        });
    }

    public static void actionStart(Context context,String data1,String data2){
        Intent intent = new Intent(context,SecondActivity.class);
        intent.putExtra("param1",data1);
        intent.putExtra("param2",data2);
        Log.d(TAG, "actionStart: "+ data1);
        context.startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return","hi back Fisrt");
        setResult(1,intent);
        finish();
    }
}