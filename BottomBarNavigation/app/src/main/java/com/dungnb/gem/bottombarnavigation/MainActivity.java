package com.dungnb.gem.bottombarnavigation;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.dungnb.gem.bottombarnavigation.fragment_home.HomeFragment;
import com.dungnb.gem.bottombarnavigation.fragment_home.MailFragment;
import com.dungnb.gem.bottombarnavigation.fragment_home.SettingFragment;
import com.dungnb.gem.bottombarnavigation.fragment_home.ShopFragment;
import com.dungnb.gem.bottombarnavigation.fragment_home.SocialFragment;
import com.dungnb.gem.bottombarnavigation.util.BottomNavigationHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
  BottomNavigationView bottomBar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    addControls();
    addEvents();
    //Add Home Fragment for First Fragment;
    handleNavigationSelected(R.id.tabHome);
  }

  private void addControls() {
    setUpBotombar();
  }

  private void setUpBotombar() {
    bottomBar = findViewById(R.id.bottomBar);
    BottomNavigationHelper.removeShiftMode(bottomBar);
  }

  private void addEvents() {
    bottomBar.setOnNavigationItemSelectedListener(this);
  }

  @Override
  public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
    handleNavigationSelected(menuItem.getItemId());
    return true;
  }

  private void handleNavigationSelected(int itemId) {
    switch (itemId) {
      case R.id.tabHome:
        addOrShowFragment(HomeFragment.getmInstance("Tab Home"), null, false, String.valueOf(R.id.tabHome));
        break;
      case R.id.tabShop:
        addOrShowFragment(ShopFragment.getmInstance("Tab Shop"), null, false, String.valueOf(R.id.tabShop));
        break;
      case R.id.tabMail:
        addOrShowFragment(MailFragment.getmInstance("Tab Mail"), null, false, String.valueOf(R.id.tabMail));
        break;
      case R.id.tabSocial:
        addOrShowFragment(SocialFragment.getmInstance("Tab Social"), null, false, String.valueOf(R.id.tabSocial));
        break;
      case R.id.tabSetting:
        addOrShowFragment(SettingFragment.getmInstance("Tab Setting"), null, false, String.valueOf(R.id.tabSetting));
        break;
      default:
        addOrShowFragment(HomeFragment.getmInstance("Tab Home"), null, false, String.valueOf(R.id.tabHome));
        break;
    }
  }

  private void addOrShowFragment(Fragment fragment, Bundle bundle, boolean addToBackStack, String tag) {
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction transaction = fragmentManager.beginTransaction();
    if (bundle != null)
      fragment.setArguments(bundle);

    List<Fragment> fragments = fragmentManager.getFragments();
    if (fragments.isEmpty())
      addFragment(fragment, bundle, addToBackStack, tag);
    else {
      //Hide all fragment before when add or show new fragment.
      for (Fragment frag : fragments) {
        if (frag != null)
          transaction.hide(frag);
      }
      Fragment fragmentFind = fragmentManager.findFragmentByTag(tag);
      if (fragmentFind != null)
        transaction.show(fragmentFind);
      else addFragment(fragment, bundle, addToBackStack, tag);
    }
    transaction.commit();
  }

  private void addFragment(Fragment fragment, Bundle bundle, boolean addToBackStack, String tag) {
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction transaction = fragmentManager.beginTransaction();
    transaction.add(R.id.container, fragment, tag);
    if (addToBackStack)
      transaction.addToBackStack(fragment.getClass().getSimpleName());
    transaction.commit();
  }

  public void addChildFragment(Fragment fragment) {
    addFragmentTransaction(fragment, null, true, fragment.getClass().getSimpleName());
  }

  private void addFragmentTransaction(Fragment fragment, Bundle bundle, boolean addToBackStack, String tag) {
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction transaction = fragmentManager.beginTransaction();
    transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    transaction.add(R.id.container, fragment, tag);
    if (addToBackStack)
      transaction.addToBackStack(fragment.getClass().getSimpleName());
    transaction.commit();
  }

}
