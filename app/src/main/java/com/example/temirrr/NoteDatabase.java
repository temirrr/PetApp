package com.example.temirrr;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//this abstract class is for Room Database, which will connect all the parts and create an instance of DB

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase instance; //creating a singleton to use only this instance everywhere in the app

    public abstract NoteDao noteDao(); //we will later use it to access Dao and its methods

    /* "synchronized" means that only 1 thread at a time can access this method
    => avoid creation of multiple instances */
    public static synchronized NoteDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    NoteDatabase.class, "note_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
