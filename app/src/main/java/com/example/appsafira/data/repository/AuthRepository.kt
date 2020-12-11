package com.example.appsafira.data.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.appsafira.data.local.AuthPref
import com.example.appsafira.data.model.ActionState
import com.example.appsafira.data.model.AuthUser

class AuthRepository (val context: Context){
    private val autPref: AuthPref by lazy { AuthPref(context) }

    val authUser = MutableLiveData<AuthUser>(autPref.authUser)
    val isLogin = MutableLiveData<Boolean>(autPref.isLogin)

    suspend fun login(email: String, password: String) : ActionState<AuthUser> {
        return autPref.login(email, password)
    }

    suspend fun register(user: AuthUser) : ActionState<AuthUser> {
        return autPref.register(user)
    }

    suspend fun logout() : ActionState<Boolean>{
        return autPref.logout()
    }
}