package com.shiaofuk.test1.mvi

sealed class MyIntent {
    data class UsernameChanged(var username: String): MyIntent()
    data class PasswordChanged(var password: String): MyIntent()
    object Login: MyIntent()
}