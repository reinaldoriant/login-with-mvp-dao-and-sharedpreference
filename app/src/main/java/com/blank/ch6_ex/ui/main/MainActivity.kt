package com.blank.ch6_ex.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.blank.ch6_ex.R
import com.blank.ch6_ex.data.model.Users
import com.blank.ch6_ex.ui.login.LoginActivity
import com.blank.ch6_ex.ui.register.RegisterActivity

class MainActivity : AppCompatActivity(), MainView {

    private var rvMain: RecyclerView? = null
    private lateinit var presenter: MainActivityPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val id = intent.getIntExtra("id", 0)
        presenter = MainPresenterImp(this)
        presenter.getUser(id)
        val butLogout = findViewById<Button>(R.id.btLogout)
        butLogout.setOnClickListener{
            presenter.logout()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    override fun onSuccess(user: Users) {
        val data = findViewById<TextView>(R.id.tvGetUser)
        data.text = user.toString()
    }
}