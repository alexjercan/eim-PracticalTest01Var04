package ro.pub.cs.systems.eim.practicaltest01var04;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var04SecondaryActivity extends AppCompatActivity {
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

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(okButtonClickListener);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(cancelButtonClickListener);
    }

    private OkButtonClickListener okButtonClickListener = new OkButtonClickListener();
    private class OkButtonClickListener implements Button.OnClickListener {

        @Override
        public void onClick(View v) {
            setResult(Activity.RESULT_OK, new Intent());
            finish();
        }
    }

    private CancelButtonClickListener cancelButtonClickListener = new CancelButtonClickListener();
    private class CancelButtonClickListener implements Button.OnClickListener {

        @Override
        public void onClick(View v) {
            setResult(Activity.RESULT_CANCELED, new Intent());
            finish();
        }
    }
}