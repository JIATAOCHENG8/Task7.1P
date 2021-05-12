package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.notesapp.data.DatabaseHelper;
import com.example.notesapp.model.Note;

import org.w3c.dom.Text;

public class createActivity extends AppCompatActivity {
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        EditText noteEditText = findViewById(R.id.noteEditText);
        Button saveButton = findViewById(R.id.saveButton);
        db = new DatabaseHelper(this);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = noteEditText.getText().toString();

                long result = db.insertNote(new Note(title));
                if(result>0)
                {
                    Toast.makeText(createActivity.this,"Note successfully!", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(createActivity.this,"Note error", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}