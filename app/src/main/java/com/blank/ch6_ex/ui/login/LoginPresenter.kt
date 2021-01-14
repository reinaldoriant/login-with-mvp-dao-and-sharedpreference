package com.blank.ch6_ex.ui.login

interface LoginPresenter {
    fun login(username: String, passwrd: String)
    fun checkIsLogin(): Boolean
    fun getId():Int?
}