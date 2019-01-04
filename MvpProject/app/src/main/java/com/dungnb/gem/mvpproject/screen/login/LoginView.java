package com.dungnb.gem.mvpproject.screen.login;

public interface LoginView {
  void showProgress();
  void hideProgress();
  void setUserNameError();
  void setPassWordError();
  void navigateHome();
}
