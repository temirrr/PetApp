package com.example.temirrr;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    @ColumnInfo(name = "pet")
    private String petType;

    private String description;

    private int priority;

    //constructor is needed for <Note> object for us and "Room" to be able to recreate objects
    public Note(String title, String petType, String description, int priority) {
        this.title = title;
        this.petType = petType;
        this.description = description;
        this.priority = priority;
    }

    //setter is needed for auto-generated IDs
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPetType() {
        return petType;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}
