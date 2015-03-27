package com.jatasra.sarvex.notes;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jatasra.sarvex.notes.data.NoteItem;

import java.util.List;

/**
 * Created by Sarvex on 26/03/2015.
 */
public class NoteListAdapter extends ArrayAdapter {

    private Context context;
    private boolean useList = true;


    public NoteListAdapter(Context context, int resource, List<NoteItem> items) {
        super(context, resource, items);

        this.context = context;
    }

    private class ViewHolder {
        TextView view;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        NoteListItem item = (NoteListItem) getItem(position);
        View viewToUse;

        LayoutInflater inflater
                = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            if (useList) viewToUse = inflater.inflate(R.layout.note_list_item, null);
            else viewToUse = inflater.inflate(R.layout.note_grid_item, null);

            holder = new ViewHolder();
            holder.view = (TextView) viewToUse.findViewById(R.id.titleTextView);
            viewToUse.setTag(holder);
        } else {
            viewToUse = convertView;
            holder = (ViewHolder) viewToUse.getTag();
        }

        holder.view.setText(item.getTitle());
        return viewToUse;

    }
}
