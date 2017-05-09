package com.wnascimento.com.me_adote_mob.presentation.addeditpet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.wnascimento.com.me_adote_mob.R;
import com.wnascimento.com.me_adote_mob.domain.pet.PetBuilder;

import javax.inject.Inject;

public class AddEditPetActivity extends AppCompatActivity implements AddEditPetContract.View {

    private Toolbar toolbar;
    private Spinner spinnerGender;

    @Inject
    AddEditPetPresenter presenter;

    private AddEditPetContract.Presenter addEditPetPresenter;
    private ImageView imagePet;

    private EditText editName;
    private TextInputLayout textInputName;


    private EditText editBreed;
    private TextInputLayout textInputBreed;

    private EditText editDateBirth;
    private TextInputLayout textInputDateBirth;

    private CheckBox checkBoxAdopted;

    private EditText editWeight;
    private TextInputLayout textInputWeight;

    private EditText editHeight;
    private TextInputLayout textInputHeight;

    private EditText editNotes;
    private TextInputLayout textInputNotes;

    private PetBuilder petBuilder;

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
        textInputName = (TextInputLayout) findViewById(R.id.text_input_name);
        textInputBreed = (TextInputLayout) findViewById(R.id.text_input_breed);
        textInputDateBirth = (TextInputLayout) findViewById(R.id.text_input_date_birth);
        textInputWeight = (TextInputLayout) findViewById(R.id.text_input_weight);
        textInputHeight = (TextInputLayout) findViewById(R.id.text_input_height);
        textInputNotes = (TextInputLayout) findViewById(R.id.text_input_notes);

        editName = (EditText) findViewById(R.id.edit_name);
        editBreed = (EditText) findViewById(R.id.edit_breed);
        editDateBirth = (EditText) findViewById(R.id.edit_date_birth);
        editWeight = (EditText) findViewById(R.id.edit_weight);
        editHeight = (EditText) findViewById(R.id.edit_height);
        editNotes = (EditText) findViewById(R.id.edit_notes);

        imagePet = (ImageView) findViewById(R.id.image_pet);

        checkBoxAdopted = (CheckBox) findViewById(R.id.checkBox_adopted);

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

    @Override
    public void attachPresenter(AddEditPetContract.Presenter presenter) {
        addEditPetPresenter = presenter;
    }

    @Override
    public void goToTimeline() {

//        petBuilder
//                .setName(editName.getText().toString().toLowerCase())
//                .setBreed(editBreed.getText().toString())
//                .setDateBirth(System.currentTimeMillis())
//                .setAdopted(checkBoxAdopted.isChecked())
//                .setWeight(Double.parseDouble(editWeight.getText().toString()))
//                .setHeight(Double.parseDouble(editHeight.getText().toString()))
//                .setNotes(editNotes.getText().toString());
//
//        addEditPetPresenter.savePet(petBuilder.build());

    }

    @Override
    public void showMessageErrorSavePet() {

    }
}
