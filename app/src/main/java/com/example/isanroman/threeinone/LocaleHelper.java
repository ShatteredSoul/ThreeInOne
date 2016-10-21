package com.example.isanroman.threeinone;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.preference.PreferenceManager;

import java.util.Locale;

/**
 * Created by isanroman on 10/21/2016.
 * gunhansancar.com/change-language-programmatically-in-android/
 */

public class LocaleHelper {

    private static final String SELECTED_LANGUAGE = "Locale.Helper.Selected.Language";

    public static void onCreate(Context context){
        String lang = getPersistedData(context, Locale.getDefault().getLanguage());
    }

    public static void onCreate(Context context, String defaultLanguage){
        String lang = getPersistedData(context, defaultLanguage);
        setLocale(context, lang);
    }

    public static String getLanguage(Context context){
        return getPersistedData(context, Locale.getDefault().getLanguage());
    }

    public static void setLocale(Context context, String language){
        persist(context, language);
        updateResources(context,language);
    }

    private static String getPersistedData(Context context, String defaultLanguage){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(SELECTED_LANGUAGE, defaultLanguage);
    }

    private static void persist(Context context, String language){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(SELECTED_LANGUAGE, language);
        editor.apply();
    }

    private static void updateResources(Context context, String lanuage){
        Locale locale = new Locale(lanuage);
        Locale.setDefault(locale);

        Resources resources = context.getResources();

        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;

        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }
}
