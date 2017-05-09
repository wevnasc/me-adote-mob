package com.wnascimento.com.me_adote_mob.presentation.addeditpet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.wnascimento.com.me_adote_mob.R;

public class AddEditPetActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Spinner spinnerGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_pet);

        initFields();
        initSpinnerGender();
        initToolbar();
    }


    public static void start(Context context) {
        Intent starter = new Intent(context, AddEditPetActivity.class);
        context.startActivity(starter);
    }

    private void initFields() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        spinnerGender = (Spinner) findViewById(R.id.spinner_gender);
    }

    private void initSpinnerGender() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gender, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(adapter);
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setLogo(R.drawable.ic_small_text_meadote);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return true;
    }
}
