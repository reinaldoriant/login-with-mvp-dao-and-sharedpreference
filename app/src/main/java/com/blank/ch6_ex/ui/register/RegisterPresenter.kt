package com.blank.ch6_ex.ui.register

interface RegisterPresenter {
    fun register(username: String, umur: String, password: String, gender: String)
}