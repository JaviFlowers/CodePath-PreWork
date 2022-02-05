package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText etItems;
    Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etItems = findViewById(R.id.etItems);
        btnSave = findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("Edit Item");

        etItems.setText(getIntent().getStringExtra(MainActivity.Key_Item_Text));

        //When the user is done editing, they click the save button
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an Intent which will contain the results
                Intent intent = new Intent();
                // Pass the data (results of editing)
                intent.putExtra(MainActivity.Key_Item_Text, etItems.getText().toString());
                intent.putExtra(MainActivity.Key_Item_Position, getIntent().getExtras().getInt(MainActivity.Key_Item_Position));

                // Set the result of the Intent
                setResult(RESULT_OK, intent);

                // Finish the Activity, close the screen and go back
                finish();
            }
        });
    }
}