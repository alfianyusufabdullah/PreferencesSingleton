package com.alfianyusufabdullah.preferencessingleton.ui;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.alfianyusufabdullah.preferencessingleton.R;
import com.alfianyusufabdullah.preferencessingleton.ui.fragment.MainFragment;
import com.alfianyusufabdullah.preferencessingleton.ui.fragment.SettingFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.floatingSettingButton)
    FloatingActionButton floatingSettingButton;

    @OnClick(R.id.floatingSettingButton)
    public void setting(View v) {
        replaceFragment(new SettingFragment(), true);

        if (v instanceof FloatingActionButton) {
            ((FloatingActionButton) v).hide();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        replaceFragment(new MainFragment(), false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        floatingSettingButton.show();
        super.onBackPressed();
    }

    private void replaceFragment(Fragment fragment, boolean backstate) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
        transaction.replace(R.id.fragmentContainer, fragment);
        if (backstate) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
}
