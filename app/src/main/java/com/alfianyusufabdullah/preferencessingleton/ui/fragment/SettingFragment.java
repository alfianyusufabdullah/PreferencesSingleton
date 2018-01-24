package com.alfianyusufabdullah.preferencessingleton.ui.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alfianyusufabdullah.preferencessingleton.Model.User;
import com.alfianyusufabdullah.preferencessingleton.R;
import com.alfianyusufabdullah.preferencessingleton.preferences.UserPreferences;

import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {

    @BindViews({R.id.inputName, R.id.inputEmail, R.id.inputAddress, R.id.inputPhone})
    List<TextInputLayout> inputUser;

    @BindViews({R.id.editName, R.id.editEmail, R.id.editAddress, R.id.editPhone})
    List<TextInputEditText> editUser;

    @OnClick(R.id.buttonSave)
    public void saveUser() {

        String Name = editUser.get(0).getText().toString();
        String Email = editUser.get(1).getText().toString();
        String Address = editUser.get(2).getText().toString();
        String Phone = editUser.get(3).getText().toString();

        if (Name.isEmpty()) {
            inputUser.get(0).setError("Insert Name");
            return;
        }

        if (Email.isEmpty()) {
            inputUser.get(1).setError("Insert Email");
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            inputUser.get(1).setError("Insert Valid Email");
            return;
        }

        if (Address.isEmpty()) {
            inputUser.get(2).setError("Insert Address");
            return;
        }

        if (Phone.isEmpty()) {
            inputUser.get(3).setError("Insert Phone");
            return;
        }

        User user = new User.Builder()
                .setName(Name)
                .setEmail(Email)
                .setAddress(Address)
                .setPhone(Phone)
                .build();

        UserPreferences.setUser(user);
        Toast.makeText(getContext() , "Saved!" , Toast.LENGTH_SHORT).show();
    }

    public SettingFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null && activity.getSupportActionBar() != null) {
            activity.getSupportActionBar().setTitle("User Setting");
            activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        User user = UserPreferences.getUser();

        editUser.get(0).setText(user.getName());
        editUser.get(1).setText(user.getEmail());
        editUser.get(2).setText(user.getAddress());
        editUser.get(3).setText(user.getPhone());
    }
}
