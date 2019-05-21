package com.builov.mymulticode.IntentDataTransfer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.builov.mymulticode.R;

public class SecondIntentActivity extends AppCompatActivity {

    TextView tv1;
    Button btn2;
    int m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent2);
        tv1=findViewById(R.id.bottomTV);
        btn2=findViewById(R.id.backButton);
        m=getIntent().getIntExtra("count",0);
        tv1.setText(Integer.toString(m));

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m=m-1;
                Intent intent = new Intent();
                intent.putExtra("int", m);
                setResult(RESULT_OK, intent);
                finish();

            }
        });
    }
}
