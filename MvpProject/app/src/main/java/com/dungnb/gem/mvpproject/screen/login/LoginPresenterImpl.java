package com.dungnb.gem.mvpproject.screen.login;

import android.text.TextUtils;

public class LoginPresenterImpl implements LoginPresenter {
  private LoginView loginView;

  public LoginPresenterImpl(LoginView loginView) {
    this.loginView = loginView;
  }

  @Override
  public void login(String user_name, String pass_word) {
    loginView.showProgress();
    boolean error = false;
    if (TextUtils.isEmpty(user_name)) {
      onUserNameError();
      error = true;
    } else if (TextUtils.isEmpty(pass_word)) {
      onPassWordError();
      error = true;
    }
    if (!error)
      onSuccess();
  }

  public void onUserNameError() {
    loginView.setUserNameError();
    loginView.hideProgress();
  }

  public void onPassWordError() {
    loginView.setPassWordError();
    loginView.hideProgress();
  }

  public void onSuccess() {
    loginView.navigateHome();
  }
}
