package com.builov.mymulticode.IntentDataTransfer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.builov.mymulticode.R;

public class FirstIntentActivity extends Activity {

    Button btn1;
    TextView tv1;
    TextView tv2;
    int i=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent1);
        tv1=findViewById(R.id.resultTV);
        tv2=findViewById(R.id.resultTV2);
        btn1=findViewById(R.id.goButton);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstIntentActivity.this, SecondIntentActivity.class);
                intent.putExtra("count",i);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        Integer name = data.getIntExtra("int", 0);
        i=name;
        tv1.setText("work: " + name + " This" );
    }

    @Override
    protected void onResume() {
        super.onResume();
        tv2.setText(Integer.toString(i));
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        finish();
    }
}
