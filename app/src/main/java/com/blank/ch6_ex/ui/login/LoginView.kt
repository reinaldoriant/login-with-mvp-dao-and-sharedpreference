package com.blank.ch6_ex.ui.login

interface LoginView {
    fun onSuccess(id:Int)
    fun onError(msg: String)
}