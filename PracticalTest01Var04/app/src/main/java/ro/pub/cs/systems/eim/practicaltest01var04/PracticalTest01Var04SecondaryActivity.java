package ro.pub.cs.systems.eim.practicaltest01var04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class PracticalTest01Var04SecondaryActivity extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_secondary);

        Intent intent = getIntent();
        String text1 = intent.getStringExtra(Constants.TEXT1_EDIT_TEXT);
        String text2 = intent.getStringExtra(Constants.TEXT2_EDIT_TEXT);

        TextView textView1 = (TextView) findViewById(R.id.textView1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);

        textView1.setText(text1);
        textView2.setText(text2);
    }
}