package com.example.administrator.test;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by My on 2017/12/7.
 */

public class FileUtil {
    public static boolean save(Context context, String username, String password) {
        SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        return editor.commit();
    }

    public static HashMap<String, String> read(Context context) {
        HashMap<String, String> hashMap = new HashMap<>();
        SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        String username = sp.getString("username", "administrator");
        String password = sp.getString("password", "123456");
        hashMap.put("username", username);
        hashMap.put("password", password);
        return hashMap;
    }

}
