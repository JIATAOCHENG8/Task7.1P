package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.notesapp.data.DatabaseHelper;
import com.example.notesapp.model.Note;

public class detaiNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detai_note);
        EditText detailEditText = findViewById(R.id.detailEditText);
        Button updateButton = findViewById(R.id.updateButton);
        Button deleteButton = findViewById(R.id.deleteButton);
        DatabaseHelper db = new DatabaseHelper(this);

        Intent detailIntent = getIntent();
        String detail = detailIntent.getStringExtra("detail");
        detailEditText.setText(detail);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newDetail = detailEditText.getText().toString();

                db.updateNote(new Note(newDetail));

                    Toast.makeText(detaiNoteActivity.this,"update successfully!",Toast.LENGTH_LONG).show();
                    Intent anIntent = new Intent(detaiNoteActivity.this, showNotesActivity.class);
                    startActivity(anIntent);

                }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteNote(new Note(detailEditText.getText().toString()));
                Toast.makeText(detaiNoteActivity.this,"delete successfully!",Toast.LENGTH_LONG).show();
                Intent anIntent = new Intent(detaiNoteActivity.this, showNotesActivity.class);
                startActivity(anIntent);
            }
        });
    }
}