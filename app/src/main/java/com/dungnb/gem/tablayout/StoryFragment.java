package com.dungnb.gem.tablayout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class StoryFragment extends Fragment {
  private static final String STORY_NAME = "story_name";
  TextView tvNameStory;
  String strStoryName;
  static StoryFragment mInstance;

  public static StoryFragment newInstance(String storyName) {
    Bundle bundle = new Bundle();
    bundle.putSerializable(STORY_NAME, storyName);
    StoryFragment storyFragment = new StoryFragment();
    storyFragment.setArguments(bundle);
    mInstance = storyFragment;
    return storyFragment;
  }

  public static StoryFragment getInstance() {
    return mInstance;
  }


  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_story, container, false);
    tvNameStory = view.findViewById(R.id.tvStoryName);
    Bundle bundle = getArguments();
    this.strStoryName = (String) bundle.get(STORY_NAME);
    tvNameStory.setText(this.strStoryName);
    return view;
  }
}
