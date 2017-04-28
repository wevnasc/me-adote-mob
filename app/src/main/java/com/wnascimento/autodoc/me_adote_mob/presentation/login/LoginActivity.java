package com.wnascimento.autodoc.me_adote_mob.presentation.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wnascimento.autodoc.me_adote_mob.R;

public class LoginActivity extends AppCompatActivity implements LoginContract.View{

    private EditText editEmail;
    private EditText editPassword;
    private Button buttonLogin;

    private LoginContract.Presenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginPresenter = new LoginPresenterFactory().make(this);
        initFields();
        initListeners();
    }

    private void initFields() {
        editEmail = (EditText) findViewById(R.id.editEmail);
        editPassword = (EditText) findViewById(R.id.editPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
    }

    private void initListeners() {
        buttonLogin.setOnClickListener(new OnClickLogin());
    }

    @Override
    public void attachPresenter(LoginContract.Presenter presenter) {
        loginPresenter = presenter;
    }

    @Override
    public void message(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private final class OnClickLogin implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String login = editEmail.getText().toString().toLowerCase();
            String password = editPassword.getText().toString().toLowerCase();
            loginPresenter.login(login, password);
        }
    }

}
