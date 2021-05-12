package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.notesapp.data.DatabaseHelper;
import com.example.notesapp.model.Note;

import java.util.ArrayList;
import java.util.List;

public class showNotesActivity extends AppCompatActivity {
    ListView notesListView;

    ArrayList<String> notesArrayList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_notes);
        notesListView = findViewById(R.id.notesListView);
        notesArrayList = new ArrayList<>();
        DatabaseHelper db = new DatabaseHelper(showNotesActivity.this);

        List<Note> noteList = db.fetchAllNotes();
        for(Note note : noteList)
        {
            notesArrayList.add(note.getNote_title());
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notesArrayList);
        notesListView.setAdapter(adapter);

        notesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 Note note = noteList.get(position);
                 Intent anIntent = new Intent(showNotesActivity.this, detaiNoteActivity.class);
                 anIntent.putExtra("detail",note.getNote_title());
                 startActivity(anIntent);
            }
        });

    }


}