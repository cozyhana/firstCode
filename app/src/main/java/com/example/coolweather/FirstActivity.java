package com.example.coolweather;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {


    private static final String TAG = "FirstActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Log.d(TAG, this.toString());
        Button button = (Button) findViewById(R.id.button1_f);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
//                1
//                Toast.makeText(FirstActivity.this, "You click me",Toast.LENGTH_SHORT).show();
//                2
//                finish();
//                3
//                Intent intent = new Intent(FirstActivity.this,ThirdActivity.class);
//                startActivity(intent);
//                4 --- 无法打开本系统浏览器，打开的是手机浏览器，看ThirdActivity
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.baidu.com"));
//                startActivity(intent);
//                5
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:10086"));
//                startActivity(intent);
//                6
//                String data = "Hi First";
//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                intent.putExtra("extra_data",data);
//                startActivity(intent);
//                7
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivityForResult(intent,1);

            }
        });

        Button button2  = (Button) findViewById(R.id.button2_f);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               SecondActivity.actionStart(FirstActivity.this,"data1","data2");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("FirstActivity", String.valueOf(requestCode));
        Log.e("FirstActivity", String.valueOf(resultCode));
        switch (requestCode){
            case 1:
                if(resultCode == 1){
                    String returnedData = data.getStringExtra("data_return");
                    Log.e("FirstActivity", returnedData );
                }
                break;
            default:
                break;
        }
    }
}