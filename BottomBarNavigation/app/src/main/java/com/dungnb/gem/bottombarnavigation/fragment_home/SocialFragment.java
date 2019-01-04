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

public class SocialFragment extends Fragment {
  private String name;
  private TextView tvName;
  public static SocialFragment mInstance;

  public static SocialFragment newInstance(String name) {

    Bundle args = new Bundle();
    args.putString(Constant.NAME, name);
    SocialFragment fragment = new SocialFragment();
    mInstance = fragment;
    fragment.setArguments(args);
    return fragment;
  }

  public static SocialFragment getmInstance(String name) {
    if(mInstance==null)
      newInstance(name);
    return mInstance;
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_social, container, false);
    tvName = view.findViewById(R.id.tvSocialName);
    Bundle bundle = getArguments();
    name = bundle.getString(Constant.NAME,"");
    tvName.setText(this.name);
    return view;
  }
}