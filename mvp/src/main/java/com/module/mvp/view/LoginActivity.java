package com.module.mvp.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.module.mvp.R;
import com.module.mvp.model.PersonModel;
import com.module.mvp.presenter.LoginPresenter;
import com.module.mvp.presenter.LoginView;
import com.module.mvp.presenter.impl.LoginPresenterImpl;

public class LoginActivity extends Activity implements LoginView, View.OnClickListener {

    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private LoginPresenter presenter;
    private PersonModel personModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = (ProgressBar) findViewById(R.id.progress);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        findViewById(R.id.button).setOnClickListener(this);

        presenter = new LoginPresenterImpl(this);
    }

    @Override protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onLoginError(String errorMsg) {
        Toast.makeText(LoginActivity.this,"" + errorMsg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginSuccess() {
        Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override public void onClick(View v) {
        personModel = new PersonModel("" + username.getText(),"" + password.getText());
        presenter.validateCredentials(personModel);
    }
}
