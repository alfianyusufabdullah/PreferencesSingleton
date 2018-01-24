package com.alfianyusufabdullah.preferencessingleton.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.alfianyusufabdullah.preferencessingleton.Model.User;

/**
 * Created by jonesrandom on 1/23/18.
 *
 * @site www.androidexample.web.id
 * @github @alfianyusufabdullah
 */

public class UserPreferences {

    private static SharedPreferences preferences;

    private static String PREF_NAME = "Name";
    private static String PREF_EMAIL = "Email";
    private static String PREF_ADDRESS = "Address";
    private static String PREF_PHONE = "Phone";

    private UserPreferences(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void initPreferences(Context context) {
        new UserPreferences(context);
    }

    public static void setUser(User user) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(PREF_NAME, user.getName());
        editor.putString(PREF_EMAIL, user.getEmail());
        editor.putString(PREF_ADDRESS, user.getAddress());
        editor.putString(PREF_PHONE, user.getPhone());
        editor.apply();
    }

    public static User getUser() {
        return new User.Builder()
                .setName(preferences.getString(PREF_NAME, "Name"))
                .setEmail(preferences.getString(PREF_EMAIL, "Email"))
                .setAddress(preferences.getString(PREF_ADDRESS, "Address"))
                .setPhone(preferences.getString(PREF_PHONE, "+62"))
                .build();
    }
}
