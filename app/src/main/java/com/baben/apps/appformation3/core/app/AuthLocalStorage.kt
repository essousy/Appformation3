package com.baben.apps.appformation3.core.app

import android.content.Context
import android.content.SharedPreferences

class AuthLocalStorage(private val context: Context){

    companion object {
        const val TOKEN_Key: String = "com.baben.apps.appformation3.core.app.tokenKey"
        const val SHARD_PREFERENCE_KEY: String = "com.baben.apps.appformation3.core.app.shardPrefeneceKey"
        const val DEFAULT_TOKEN_VALUE: String = ""
    }

    val sharedPreference=context.getSharedPreferences(SHARD_PREFERENCE_KEY,Context.MODE_PRIVATE)
    private val editor = sharedPreference.edit()
    fun saveToken(token: String) {
        editor.putString(TOKEN_Key, token).apply()
    }

    fun getToken(): String {
            return sharedPreference.getString(TOKEN_Key, "") ?: DEFAULT_TOKEN_VALUE
    }

    fun clearToken() {
        editor.remove(TOKEN_Key).apply()
    }

    fun isLogged(): Boolean {
        return getToken() != DEFAULT_TOKEN_VALUE
    }


    /*
    companion object {
        private const val PREF_NAME = "AuthPrefs"
        private val KEY_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOjIsInVzZXIiOiJtb3JfMjMxNCIsImlhdCI6MTcxMTU0MjE4N30.Cou_74reS5KsyMyh8PA2AjQwsJFN6yEJc0Nkh0_AMWk"

    }
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    override fun saveAuthToken(token: String) {
        sharedPreferences.edit().putString(KEY_TOKEN, token).apply()
    }

    override fun getAuthToken(): String? {
        return sharedPreferences.getString(KEY_TOKEN, null)
    }
    override fun isLoggedIn(): Boolean {
        return getAuthToken() != null
    }

     */

}