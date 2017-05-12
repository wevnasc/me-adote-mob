package com.wnascimento.com.me_adote_mob.presentation.addeditpet;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.wnascimento.com.me_adote_mob.MainApplication;
import com.wnascimento.com.me_adote_mob.R;
import com.wnascimento.com.me_adote_mob.domain.pet.Pet;
import com.wnascimento.com.me_adote_mob.presentation.timeline.TimelineActivity;
import com.wnascimento.com.me_adote_mob.util.FileHelper;
import com.wnascimento.com.me_adote_mob.util.ImageHelper;
import com.wnascimento.com.me_adote_mob.util.PermissionHelper;

import org.joda.time.LocalDate;

import java.io.IOException;
import java.util.Calendar;

import javax.inject.Inject;

public class AddEditPetActivity extends AppCompatActivity implements AddEditPetContract.View {


    private static final int REQUEST_IMAGE_CAPTURE = 1;

    private Toolbar toolbar;
    private Spinner spinnerGender;

    @Inject
    AddEditPetPresenter presenter;

    private AddEditPetContract.Presenter addEditPetPresenter;
    private TextInputLayout textInputName;
    private TextInputLayout textInputBreed;
    private TextInputLayout textInputDateBirth;
    private TextInputLayout textInputWeight;
    private TextInputLayout textInputHeight;
    private ImageView imagePet;
    private EditText editName;
    private EditText editBreed;
    private EditText editDateBirth;
    private CheckBox checkBoxAdopted;
    private EditText editWeight;
    private EditText editHeight;
    private EditText editNotes;

    private Pet.PetBuilder petBuilder = new Pet.PetBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_pet);
        initDagger();
        initFields();
        initListeners();
        initSpinnerGender();
        initToolbar();
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, AddEditPetActivity.class);
        context.startActivity(starter);
    }

    private void initDagger() {
        DaggerAddEditPetComponent.builder()
                .mainComponent(MainApplication.mainComponent)
                .repositoryComponent(MainApplication.repositoryComponent)
                .addEditPetModule(new AddEditPetModule(this))
                .build()
                .inject(this);
    }

    private void initFields() {
        textInputName = (TextInputLayout) findViewById(R.id.text_input_name);
        textInputBreed = (TextInputLayout) findViewById(R.id.text_input_breed);
        textInputDateBirth = (TextInputLayout) findViewById(R.id.text_input_date_birth);
        textInputWeight = (TextInputLayout) findViewById(R.id.text_input_weight);
        textInputHeight = (TextInputLayout) findViewById(R.id.text_input_height);

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

    private void initListeners() {
        imagePet.setOnClickListener(new OnClickPicture());
        editDateBirth.setOnClickListener(new OnClickDateBirth());
        spinnerGender.setOnItemSelectedListener(new OnItemSelectedGender());
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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_save:
                savePet();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            try {
                String imagePath = FileHelper.saveBitmap(this, imageBitmap);
                ImageHelper.showImageCircle(this, imagePet, imagePath);
                petBuilder.setImage(imagePath);
            } catch (IOException e) {
                Toast.makeText(this, getString(R.string.error_saving_image), Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PermissionHelper.PERMISSIONS_REQUEST_TAKE_PICTURE: {

                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    dispatchTakePictureIntent();
                }

                break;
            }
        }
    }

    @Override
    public void attachPresenter(AddEditPetContract.Presenter presenter) {
        addEditPetPresenter = presenter;
    }

    @Override
    public void goToTimeline() {
        TimelineActivity.start(this);
    }

    @Override
    public void showMessageErrorSavePet() {

    }

    public boolean isValidForm() {
        boolean valid = true;
        if(editName.getText().toString().isEmpty()) {
            textInputName.setError("The name is required");
            valid = false;
        }

        if(editBreed.getText().toString().isEmpty()) {
            textInputBreed.setError("The breed is required");
            valid = false;
        }

        if(editDateBirth.getText().toString().isEmpty()) {
            textInputDateBirth.setError("The date birth is required");
            valid = false;
        }

        if(spinnerGender.getSelectedItemPosition() == 0) {
            Toast.makeText(this, "the gender is required", Toast.LENGTH_SHORT).show();
            valid = false;
        }

        if(editWeight.getText().toString().isEmpty()) {
            textInputWeight.setError("The name is required");
            valid = false;
        }

        if(editHeight.getText().toString().isEmpty()) {
            textInputHeight.setError("The name is required");
            valid = false;
        }
        return  valid;
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    private void savePet() {
        if(isValidForm()) {

            petBuilder
                    .setName(editName.getText().toString().toLowerCase())
                    .setBreed(editBreed.getText().toString())
                    .setDateBirth(System.currentTimeMillis())
                    .setAdopted(checkBoxAdopted.isChecked())
                    .setWeight(Double.parseDouble(editWeight.getText().toString()))
                    .setHeight(Double.parseDouble(editHeight.getText().toString()))
                    .setNotes(editNotes.getText().toString());

            addEditPetPresenter.savePet(petBuilder.build());

        }

    }

    private final class OnClickPicture implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (PermissionHelper.hasPermissionTakePicture(AddEditPetActivity.this)) {
                dispatchTakePictureIntent();
            } else {
                PermissionHelper.checkTakePicturePermissionDenied(AddEditPetActivity.this);
            }
        }
    }

    private final class OnClickDateBirth implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Calendar calendar = Calendar.getInstance();
            @SuppressLint("WrongConstant")
            DatePickerDialog datePickerDialog = new DatePickerDialog(AddEditPetActivity.this,
                    (view, year, month, dayOfMonth) -> {
                        editDateBirth.setText(String.format("%s/%s/%s", dayOfMonth, month, year));
                        LocalDate dateBirth = new LocalDate(year, month, dayOfMonth);
                        petBuilder.setDateBirth(dateBirth.toDate().getTime());
                    },
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.show();
        }
    }

    private final class OnItemSelectedGender implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            petBuilder.setGender(-1);
            if (position != 0) {
                String[] gender = getResources().getStringArray(R.array.gender);
                int selectedGender = gender[position].contains("Male") ? Pet.MALE : Pet.FEMALE;
                petBuilder.setGender(selectedGender);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

}
