package com.dungnb.gem.mvpproject.screen.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dungnb.gem.mvpproject.R;
import com.dungnb.gem.mvpproject.screen.home.HomeActivity;

public class LoginActivity extends AppCompatActivity implements LoginView {
  TextView tvDescription;
  EditText edtUserName, edtPassWord;
  Button btnLogin;
  LoginPresenter loginPresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    loginPresenter = new LoginPresenterImpl(this);
    addControls();
    addEvents();
  }

  private void addControls() {
    tvDescription = findViewById(R.id.tvDescription);
    edtPassWord = findViewById(R.id.edtPassWord);
    edtUserName = findViewById(R.id.edtUserName);
    btnLogin = findViewById(R.id.btnLogin);
  }

  private void addEvents() {
    btnLogin.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        loginPresenter.login(edtUserName.getText().toString(), edtPassWord.getText().toString());
      }
    });
  }

  @Override
  public void showProgress() {

  }

  @Override
  public void hideProgress() {

  }

  @Override
  public void setUserNameError() {
    tvDescription.setText(R.string.error_user_name);
  }

  @Override
  public void setPassWordError() {
    tvDescription.setText(R.string.error_pass_word);
  }

  @Override
  public void navigateHome() {
    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
    startActivity(intent);
  }
}
