package ro.pub.cs.systems.eim.practicaltest01var04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PracticalTest01Var04MainActivity extends AppCompatActivity {
    private final Button1ClickListener button1ClickListener = new Button1ClickListener();

    private class Button1ClickListener implements Button.OnClickListener {

        @Override
        public void onClick(View view) {
            EditText editText1 = (EditText) findViewById(R.id.editText1);
            CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
            EditText editText2 = (EditText) findViewById(R.id.editText2);
            CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);


            String text1 = "";
            String text2 = "";

            if (checkBox1.isChecked()) {
                text1 = editText1.getText().toString();
            }
            if (checkBox2.isChecked()) {
                text2 = editText2.getText().toString();
            }

            Intent intent = new Intent(PracticalTest01Var04MainActivity.this, PracticalTest01Var04SecondaryActivity.class);
            intent.setAction(Constants.ACTION_STRING);
            intent.putExtra(Constants.TEXT1_EDIT_TEXT, text1);
            intent.putExtra(Constants.TEXT2_EDIT_TEXT, text2);
            intent.setType("text/plain");
            startActivity(intent);
        }
    }

    private final Button2ClickListener button2ClickListener = new Button2ClickListener();

    private class Button2ClickListener implements Button.OnClickListener {

        @Override
        public void onClick(View view) {
            EditText editText1 = (EditText) findViewById(R.id.editText1);
            CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
            EditText editText2 = (EditText) findViewById(R.id.editText2);
            CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
            TextView textView = (TextView) findViewById(R.id.textView);


            String text1 = editText1.getText().toString();
            String text2 = editText2.getText().toString();
            List<String> strings = new ArrayList<>();

            if (checkBox1.isChecked() && text1.isEmpty()) {
                Toast.makeText(PracticalTest01Var04MainActivity.this, "Error: Complete all fields", Toast.LENGTH_SHORT).show();
            } else if (checkBox1.isChecked()) {
                strings.add(text1);
            }

            if (checkBox2.isChecked() && text2.isEmpty()){
                Toast.makeText(PracticalTest01Var04MainActivity.this, "Error: Complete all fields", Toast.LENGTH_SHORT).show();
            } else if (checkBox2.isChecked()) {
                strings.add(text2);
            }

            textView.setText(this.join(strings));
        }

        private String join(List<String> strings) {
            if (strings.size() == 0)
                return "";
            StringBuilder result = new StringBuilder(strings.get(0));
            for (int i = 1; i < strings.size(); i++) {
                result.append(" ");
                result.append(strings.get(i));
            }
            return result.toString();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_main);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(button2ClickListener);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(button1ClickListener);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(Constants.TEXT1_EDIT_TEXT)) {
                EditText editText = (EditText)findViewById(R.id.editText1);
                editText.setText(savedInstanceState.getString(Constants.TEXT1_EDIT_TEXT));
            }
            if (savedInstanceState.containsKey(Constants.TEXT2_EDIT_TEXT)) {
                EditText editText = (EditText)findViewById(R.id.editText2);
                editText.setText(savedInstanceState.getString(Constants.TEXT2_EDIT_TEXT));
            }
            if (savedInstanceState.containsKey(Constants.CHECK1_BOX)) {
                CheckBox check1 = (CheckBox)findViewById(R.id.checkBox1);
                check1.setChecked(savedInstanceState.getBoolean(Constants.CHECK1_BOX));
            }
            if (savedInstanceState.containsKey(Constants.CHECK2_BOX)) {
                CheckBox check2 = (CheckBox)findViewById(R.id.checkBox2);
                check2.setChecked(savedInstanceState.getBoolean(Constants.CHECK2_BOX));
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        EditText editText1 = (EditText)findViewById(R.id.editText1);
        EditText editText2 = (EditText)findViewById(R.id.editText2);
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        savedInstanceState.putString(Constants.TEXT1_EDIT_TEXT, editText1.getText().toString());
        savedInstanceState.putString(Constants.TEXT2_EDIT_TEXT, editText2.getText().toString());
        savedInstanceState.putBoolean(Constants.CHECK1_BOX, checkBox1.isChecked());
        savedInstanceState.putBoolean(Constants.CHECK2_BOX, checkBox2.isChecked());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey(Constants.TEXT1_EDIT_TEXT)) {
            EditText editText1 = (EditText)findViewById(R.id.editText1);
            editText1.setText(savedInstanceState.getString(Constants.TEXT1_EDIT_TEXT));
        }
        if (savedInstanceState.containsKey(Constants.TEXT2_EDIT_TEXT)) {
            EditText editText2 = (EditText)findViewById(R.id.editText2);
            editText2.setText(savedInstanceState.getString(Constants.TEXT2_EDIT_TEXT));
        }
        if (savedInstanceState.containsKey(Constants.CHECK1_BOX)) {
            CheckBox check1 = (CheckBox)findViewById(R.id.checkBox1);
            check1.setChecked(savedInstanceState.getBoolean(Constants.CHECK1_BOX));
        }
        if (savedInstanceState.containsKey(Constants.CHECK2_BOX)) {
            CheckBox check2 = (CheckBox)findViewById(R.id.checkBox2);
            check2.setChecked(savedInstanceState.getBoolean(Constants.CHECK2_BOX));
        }
    }
}