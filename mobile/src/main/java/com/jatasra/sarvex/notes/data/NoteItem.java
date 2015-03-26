package com.jatasra.sarvex.notes.data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Sarvex on 26/03/2015.
 */
public class NoteItem {

    private String key;
    private String text;

    public NoteItem(String key, String text) {
        this.key = key;
        this.text = text;
    }

    public static NoteItem getNew() {

        Locale locale = new Locale("en-US");
        Locale.setDefault(locale);

        String pattern = "yyyy-MM-dd HH:mm:ss Z";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, Locale.getDefault());
        String key = formatter.format(new Date());

        NoteItem note = new NoteItem(key, "");

        return note;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
