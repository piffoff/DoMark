package ru.ikota.domark;


import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {
    public static final String KEY_SPALSH = "KEY_SPLASH";
    private static PreferenceHelper instance;
    private Context context;
    private SharedPreferences sharedPreferences;

    private PreferenceHelper(){
    }

    public static PreferenceHelper getInstance() {
        if (instance == null) {
            instance = new PreferenceHelper();
        }
        return instance;
    }

    public void init(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("sharedPreferences", context.MODE_PRIVATE);
    }

    public void putBulean(String key, boolean value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean getBoolean(String key){
        return sharedPreferences.getBoolean(key, false);
    }
}
