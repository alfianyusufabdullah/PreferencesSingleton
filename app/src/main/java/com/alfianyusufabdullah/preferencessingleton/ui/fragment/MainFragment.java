package com.alfianyusufabdullah.preferencessingleton.ui.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alfianyusufabdullah.preferencessingleton.Model.User;
import com.alfianyusufabdullah.preferencessingleton.R;
import com.alfianyusufabdullah.preferencessingleton.preferences.UserPreferences;

import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    @BindViews({R.id.textName, R.id.textEmail, R.id.textAddress, R.id.textPhone})
    List<TextView> textUser;

    public MainFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null && activity.getSupportActionBar() != null) {
            activity.getSupportActionBar().setTitle("User");
            activity.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }

        User user = UserPreferences.getUser();

        textUser.get(0).setText(user.getName());
        textUser.get(1).setText(user.getEmail());
        textUser.get(2).setText(user.getAddress());
        textUser.get(3).setText(user.getPhone());
    }
}
