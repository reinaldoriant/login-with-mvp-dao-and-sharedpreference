package com.blank.ch6_ex.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.blank.ch6_ex.R
import com.blank.ch6_ex.ui.main.MainActivity
import com.blank.ch6_ex.ui.register.RegisterActivity
import com.blank.ch6_ex.utils.text

class LoginActivity : AppCompatActivity(), LoginView {
    private var presenter: LoginPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter = LoginPresenterImp(this)
        if (presenter?.checkIsLogin() == true) {
            presenter?.getId()?.let { onSuccess(it) }
        }

        val username = findViewById<EditText>(R.id.etUsername)
        val password = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnLogin.setOnClickListener {
            presenter?.login(username.text(), password.text())
        }

        btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    override fun onSuccess(id:Int) {
        val intent =Intent(this, MainActivity::class.java)
        intent.putExtra("id",id)
        startActivity(intent)
        finish()
    }

    override fun onError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}