package com.alfianyusufabdullah.preferencessingleton;

import android.app.Application;

import com.alfianyusufabdullah.preferencessingleton.preferences.UserPreferences;

/**
 * Created by jonesrandom on 1/23/18.
 *
 * @site www.androidexample.web.id
 * @github @alfianyusufabdullah
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UserPreferences.initPreferences(this);
    }
}
