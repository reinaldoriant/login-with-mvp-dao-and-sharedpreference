package com.blank.ch6_ex.ui.login

import android.content.Intent
import com.blank.ch6_ex.App
import com.blank.ch6_ex.data.local.SharedPref
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginPresenterImp(private val view: LoginView) : LoginPresenter {

    override fun login(username: String, passwrd: String) {
        val appDb = App.appDb

        GlobalScope.launch(Dispatchers.IO)
        {
            val userEntity = appDb
                ?.dataUser()?.fetchUserbyName(username)
            //launch ini memindahkan ke UI agar bisa ditampillkan, karena launch yang pertama masih proses background (tidak punya UI)
            launch(Dispatchers.Main){
                if (username == userEntity?.nama) {
                    SharedPref.isLogin = true
                    SharedPref.id = userEntity.id
                    view.onSuccess(userEntity.id)
                } else {
                    view.onError("Username atau password kamuuhh salah!!")
                }
            }
        }
    }
    override fun checkIsLogin(): Boolean = SharedPref.isLogin == true
    override fun getId(): Int? =SharedPref.id
}