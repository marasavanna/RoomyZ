package com.example.mara.roomiez.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.mara.roomiez.R;

public class UserDescriptionActivity extends AppCompatActivity {

    private Spinner estateTypeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_description);

        estateTypeSpinner = findViewById(R.id.type_real_estate_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.estate_types));

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        estateTypeSpinner.setAdapter(adapter);
    }
}
