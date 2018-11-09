package xyz.e0zoo.todolistapplication.api

import android.content.Context
import android.preference.PreferenceManager

const val KEY_AUTH_TOKEN = "xyz.e0zoo.todolistapplication.api.auth_token"
const val KEY_USER_EMAIL = "xyz.e0zoo.todolistapplication.api.user_email"
const val KEY_USER_PASSWORD = "xyz.e0zoo.todolistapplication.api.user_password"


fun updateToken(context: Context, token: String) {
    PreferenceManager.getDefaultSharedPreferences(context).edit()
            .putString(KEY_AUTH_TOKEN, token)
            .apply()
}

fun getAccessToken(context: Context) : String? {
    return PreferenceManager.getDefaultSharedPreferences(context)
            .getString(KEY_AUTH_TOKEN, null)
}

fun updateUserEmailPassword(context: Context, email: String, password: String){
    PreferenceManager.getDefaultSharedPreferences(context).edit()
            .putString(KEY_USER_EMAIL, email)
            .putString(KEY_USER_PASSWORD, password)
            .apply()
}

fun getUserEmail(context: Context): String? {
    return PreferenceManager.getDefaultSharedPreferences(context)
            .getString(KEY_USER_EMAIL, null)
}

fun getUserPassword(context: Context): String? {
    return PreferenceManager.getDefaultSharedPreferences(context)
            .getString(KEY_USER_PASSWORD, null)
}