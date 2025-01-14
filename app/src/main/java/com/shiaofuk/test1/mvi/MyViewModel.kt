package com.shiaofuk.test1.mvi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


data class LoginState(val username: String = "", val password: String = "", val loading: Boolean = false, val error: String? = null)

class MyViewModel {

    private val _loginState = MutableLiveData(LoginState())
    val loginState : LiveData<LoginState> get() = _loginState


    fun processIntent(intent: MyIntent) {
        when (intent) {
            is MyIntent.UsernameChanged -> {
                _loginState.value = _loginState.value?.copy(username = intent.username)
            }
            is MyIntent.PasswordChanged -> {
                _loginState.value = _loginState.value?.copy(password = intent.password)
            }
            MyIntent.Login -> {
                _loginState.value = _loginState.value?.copy(loading = true)
                if (login(loginState.value?.username, loginState.value?.password)) {
                    _loginState.value = _loginState.value?.copy(loading = false)
                } else {
                    _loginState.value = _loginState.value?.copy(loading = false, error = "Login failed")
                }
            }
        }
    }

    private fun login(username: String?, password: String?): Boolean {
        // 网络请求
        if (username == null || password == null) {
            return false
        }
        return username == "admin" && password == "admin"
    }
}


