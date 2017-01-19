package com.example.android.pets;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.android.pets.data.PetContract.PetsEntry;

/**
 * Created by priyankanandiraju on 1/18/17.
 */

public class PetsCursorAdapter extends CursorAdapter {
    public PetsCursorAdapter(Context context, Cursor c) {
        super(context, c, 0 /* flags */);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvName = (TextView) view.findViewById(R.id.name);
        TextView tvSummary = (TextView) view.findViewById(R.id.summary);

        String name = cursor.getString(cursor.getColumnIndexOrThrow(PetsEntry.COLUMN_PET_NAME));
        String breed = cursor.getString(cursor.getColumnIndexOrThrow(PetsEntry.COLUMN_PET_BREED));

        if (TextUtils.isEmpty(breed)) {
            breed = context.getString(R.string.unknown_breed);
        }
        tvName.setText(name);
        tvSummary.setText(breed);

    }
}
