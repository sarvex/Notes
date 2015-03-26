package com.jatasra.sarvex.notes.data;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by Sarvex on 26/03/2015.
 */
public class NoteDataSource {

    private static final String PREFERENCE_KEY = "notes";
    private SharedPreferences preferences;

    public NoteDataSource(Context context) {

        preferences = context.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE);
    }

    public List<NoteItem> findAll() {

        Map<String, ?> notesMap = preferences.getAll();
        SortedSet<String> keys = new TreeSet<>(notesMap.keySet());

        List<NoteItem> notes = new ArrayList<>();

        for (String key : keys) {
            NoteItem note = new NoteItem(key, (String) notesMap.get(key));
            notes.add(note);
        }

        return notes;
    }

    public boolean update(NoteItem note) {

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(note.getKey(), note.getText());
        editor.apply();

        return true;
    }

    public boolean remove(NoteItem note) {

        if (preferences.contains(note.getKey())) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.remove(note.getKey());
            editor.apply();
        }

        return true;
    }
}
