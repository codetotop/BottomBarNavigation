package com.dungnb.gem.tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  TabLayout tlStory;
  ViewPager vpStory;
  ViewPagerAdapter vpAdapterStory;
  ArrayList<String> storyNames;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    addControls();
    addEvents();
  }

  private ArrayList<String> listStory() {
    this.storyNames = new ArrayList<>();
    this.storyNames.add("Dragon Ball");
    this.storyNames.add("Conan");
    this.storyNames.add("Thuỷ thủ mặt trăng");
    this.storyNames.add("Chạng vạng");
    this.storyNames.add("Hai số phận");
    return this.storyNames;
  }

  private void addControls() {
    tlStory = findViewById(R.id.tlStory);
    vpStory = findViewById(R.id.vpStory);

    vpAdapterStory = new ViewPagerAdapter(getSupportFragmentManager(), this, listStory());
    vpStory.setAdapter(vpAdapterStory);
    tlStory.setupWithViewPager(vpStory);
  }

  private void addEvents() {

  }


}
