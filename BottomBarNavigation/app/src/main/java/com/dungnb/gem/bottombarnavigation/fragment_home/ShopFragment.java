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

public class ShopFragment extends Fragment {
  private static String name;
  private static TextView tvName;
  public static ShopFragment mInstance;

  public static ShopFragment newInstance(String name) {

    Bundle args = new Bundle();
    args.putString(Constant.NAME, name);
    ShopFragment fragment = new ShopFragment();
    mInstance = fragment;
    fragment.setArguments(args);
    return fragment;
  }

  public static ShopFragment getmInstance() {
    return mInstance;
  }
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_shop, container, false);
    this.tvName = view.findViewById(R.id.tvShopName);
    Bundle bundle = getArguments();
    this.name = bundle.getString(Constant.NAME);
    this.tvName.setText(this.name);
    return view;
  }
}