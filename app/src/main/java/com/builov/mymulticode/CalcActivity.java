package com.builov.mymulticode;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalcActivity extends AppCompatActivity {
    //массивы кнопок
    Button[] btn = new Button[10];
    Button[] btnmath = new Button[4];
    Button btnClear;
    Button btnItog;
    Button btnDot;
    EditText mEditText;
    Float first, second;
    String count,tvtemp;
    TextView tvLog;
    //Файл настройки
    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_RESULT = "result";
    private SharedPreferences mPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        //обьявление файла с настройками и доступом к нему
        mPreferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        //определяем прокручивающийся список
        tvLog = findViewById(R.id.tvlog);
        //определяем цифры
        btn[0] = findViewById(R.id.btn0);
        btn[1] = findViewById(R.id.btn1);
        btn[2] = findViewById(R.id.btn2);
        btn[3] = findViewById(R.id.btn3);
        btn[4] = findViewById(R.id.btn4);
        btn[5] = findViewById(R.id.btn5);
        btn[6] = findViewById(R.id.btn6);
        btn[7] = findViewById(R.id.btn7);
        btn[8] = findViewById(R.id.btn8);
        btn[9] = findViewById(R.id.btn9);
        btnDot = findViewById(R.id.btndot);
        //определяем математические знаки
        btnmath[0] = findViewById(R.id.btnplus);
        btnmath[1] = findViewById(R.id.btnminus);
        btnmath[2] = findViewById(R.id.btnmultipli);
        btnmath[3] = findViewById(R.id.btndel);
        //кнопка с точкой
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText().toString()+".");
            }
        });
        //кнопка очистки и равно
        btnClear = findViewById(R.id.btnclear);
        btnItog = findViewById(R.id.btnitog);
        //строка ввода и ее обнуление при запуске
        mEditText = findViewById(R.id.enterNumber);
        mEditText.setText("0");
        //очистка
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText("");
            }
        });
        btnClear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvLog.setText("");
                return false;
            }
        });
        //Обработка нажатия кнопки =
        btnItog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString().equals("")){
                 MakeToast("Введите значение");
                } else {
                    makeResult();}
            }
        });
        //метод ввода чисел
        for (int i = 0; i <= 9; i++) {
            onClick(btn[i]);
        }
        //метод ввода математического знака
        for (int j = 0; j <= 3; j++) {
            onMathClick(btnmath[j]);
        }
    }
    //обработка нажатия кнопок с цифрами
    private void onClick(final Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString().equals("0")){mEditText.setText("");}
                mEditText.setText(mEditText.getText() + button.getText().toString());
            }
        });
    }
    //обработка нажатия кнопок с математическими знаками
    private void onMathClick(final Button buttonmath) {
        buttonmath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = buttonmath.getText().toString();
                first = Float.valueOf(mEditText.getText().toString());
                tvLog.append(first.toString()+" "+buttonmath.getText().toString());
                mEditText.setText("");
            }
        });
    }
    @Override
    protected void onPause(){
        super.onPause();
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString(APP_PREFERENCES_RESULT, tvLog.getText().toString());
        editor.apply();
    }
    @Override
    protected void onResume(){
        super.onResume();
        if (mPreferences.contains(APP_PREFERENCES_RESULT)){
          tvtemp = mPreferences.getString(APP_PREFERENCES_RESULT,tvLog.getText().toString());
          tvLog.setText(tvtemp);
        }
    }
    private void makeResult(){
        if (mEditText.getText().toString().equals("")){
            MakeToast("Введите первое значение");
        } else if (count.equals("+")) {
            first = first + (Float.parseFloat(mEditText.getText().toString()));
            ui();
        } else if (count.equals("-")) {
            first = first - (Float.parseFloat(mEditText.getText().toString()));
            ui();
        } else if (count.equals("*")) {
            first = first * (Float.parseFloat(mEditText.getText().toString()));
            ui();
        } else if (count.equals("/")) {
            if (first.equals(0)) {
                MakeToast("На 0 делить нельзя");
            } else {
                first = first / (Float.parseFloat(mEditText.getText().toString()));
                ui();
            }
        }
    }
    private void MakeToast(String text){
        Toast toast = Toast.makeText(CalcActivity.this, text,Toast.LENGTH_SHORT);
        toast.show();
    }
    private void ui (){
        second = Float.parseFloat(mEditText.getText().toString());
        mEditText.setText(Float.valueOf(first).toString());
        tvLog.append(" " + second + " = " + mEditText.getText().toString() + "\n");
    }
}
