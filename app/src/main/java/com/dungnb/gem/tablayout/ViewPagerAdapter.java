package com.dungnb.gem.tablayout;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
  private Context context;
  private ArrayList<String> storyNames;

  public ViewPagerAdapter(FragmentManager fm, Context context, ArrayList<String> storyList) {
    super(fm);
    this.context = context;
    this.storyNames = storyList;
  }

  @Override
  public Fragment getItem(int i) {
    return StoryFragment.newInstance(this.storyNames.get(i));
  }

  @Override
  public int getCount() {
    return this.storyNames.size();
  }

  @Nullable
  @Override
  public CharSequence getPageTitle(int position) {
    return storyNames.get(position);
  }
}
