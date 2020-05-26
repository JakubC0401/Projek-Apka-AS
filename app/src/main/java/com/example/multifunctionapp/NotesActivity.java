package com.example.multifunctionapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NotesActivity extends AppCompatActivity {

    DataBaseHelper dataBaseHelper;
    ArrayAdapter<String> arrayAdapter;
    ListView IstTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        dataBaseHelper=new DataBaseHelper(this);

        IstTask=(ListView)findViewById(R.id.IstTask);
        
        loadTaskList();
    }

    private void loadTaskList() {
        ArrayList<String> taskList=dataBaseHelper.getTaskList();
        if(arrayAdapter==null){
            arrayAdapter=new ArrayAdapter<String>(this, R.layout.rw,R.id.task_title,taskList);
            IstTask.setAdapter(arrayAdapter);

        }
        else {
            arrayAdapter.clear();
            arrayAdapter.addAll(taskList);
            arrayAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        Drawable icon=menu.getItem(0).getIcon();
        icon.mutate();

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add_task:
                final EditText taskEditText=new EditText(this);
                AlertDialog alertDialog= new AlertDialog.Builder(this)
                        .setTitle("Add new task")
                        .setMessage("What's next?")
                        .setView(taskEditText)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String task= String.valueOf(taskEditText.getText());
                                dataBaseHelper.insertNewTask(task);
                                loadTaskList();
                            }
                        })
                        .setNegativeButton("Cancle",null)
                        .create();
                alertDialog.show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void DeleteTask(View v){
        View parent=(View)v.getParent();
        TextView taskView=(TextView)parent.findViewById(R.id.task_title);
        String task=String.valueOf(taskView.getText());
        dataBaseHelper.deleteTask(task);
        loadTaskList();
    }
}
