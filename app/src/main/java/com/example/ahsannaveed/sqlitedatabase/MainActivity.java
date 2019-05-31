package com.example.ahsannaveed.sqlitedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edit_text);
        textView = findViewById(R.id.tasks);
        databaseHelper = new DatabaseHelper(this,null ,null ,1 );
    }

    public void addTasks(View view) {
        Tasks tasks = new Tasks(editText.getText().toString());
        databaseHelper.addTasks(tasks);
        printDB();
    }


    public void removeTasks(View view) {
        String input = editText.getText().toString();
        databaseHelper.removeTasks(input);
        printDB();
    }
    public void printDB(){
        String dbString = databaseHelper.dbtoString();
        textView.setText(dbString);
    }
}
