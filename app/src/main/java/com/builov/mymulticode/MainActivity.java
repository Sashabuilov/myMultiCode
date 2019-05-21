package com.builov.mymulticode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.builov.mymulticode.IntentDataTransfer.FirstIntentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView (R.id.myAnimation)
    Button myAnimation;
    @BindView (R.id.myMenu)
    Button myMenu;
    @BindView (R.id.myIntentDataTransfer)
    Button myIntentDataTransfer;
    @BindView(R.id.calc)
    Button myCalc;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

       myAnimation.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent animationIntent = new Intent(MainActivity.this, AnimationActivity.class);
               startActivity(animationIntent);
           }
       });

       myMenu.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent menuIntent = new Intent(MainActivity.this, MenuActivity.class);
               startActivity(menuIntent);
           }
       });

       myIntentDataTransfer.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent dataTransferIntent = new Intent(MainActivity.this, FirstIntentActivity.class);
               startActivity(dataTransferIntent);
           }
       });

       myCalc.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent CalcIntent = new Intent( MainActivity.this, CalcActivity.class);
               startActivity(CalcIntent);
           }
       });
    }
}
