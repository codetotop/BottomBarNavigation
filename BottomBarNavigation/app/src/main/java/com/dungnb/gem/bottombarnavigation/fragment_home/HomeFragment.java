package com.dungnb.gem.bottombarnavigation.fragment_home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dungnb.gem.bottombarnavigation.Constant;
import com.dungnb.gem.bottombarnavigation.R;

public class HomeFragment extends Fragment {
  private static String name;
  private static TextView tvName;
  public static HomeFragment mInstance;

  public static HomeFragment newInstance(String name) {

    Bundle args = new Bundle();
    args.putString(Constant.NAME, name);
    HomeFragment fragment = new HomeFragment();
    mInstance = fragment;
    fragment.setArguments(args);
    return fragment;
  }

  public static HomeFragment getmInstance() {
    return mInstance;
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_home, container, false);
    this.tvName = view.findViewById(R.id.tvHomeName);
    Bundle bundle = getArguments();
    this.name = bundle.getString(Constant.NAME);
    this.tvName.setText(this.name);
    return view;
  }
}
