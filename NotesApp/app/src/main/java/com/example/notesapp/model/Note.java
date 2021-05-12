package com.example.notesapp.model;

public class Note {
    private int note_id;
    private String note_title;

    public Note(String note_title) {
        this.note_title = note_title;
    }

    public Note() {
    }

    public int getNote_id() {
        return note_id;
    }

    public void setNote_id(int note_id) {
        this.note_id = note_id;
    }

    public String getNote_title() {
        return note_title;
    }

    public void setNote_title(String note_title) {
        this.note_title = note_title;
    }
}
