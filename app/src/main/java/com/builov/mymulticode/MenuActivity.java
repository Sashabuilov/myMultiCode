package com.builov.mymulticode;

import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub

        int id = item.getItemId();
        View view = this.getWindow().getDecorView();
        Toast toast;

        switch (id) {
            case R.id.item1:
                toast = Toast.makeText(getApplication(), "item1", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            case  R.id.item2:
                toast = Toast.makeText(getApplication(), "item2", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            case  R.id.item3:
                toast = Toast.makeText(getApplication(), "item3", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            case  R.id.item4:
                toast = Toast.makeText(getApplication(), "item4", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}