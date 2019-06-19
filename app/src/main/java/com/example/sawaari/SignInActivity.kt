package com.example.sawaari

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        supportActionBar!!.hide()

        findViewById<TextView>(R.id.sign_up).setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
            findViewById<Button>(R.id.email_sign_in_button).setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
        }
    }
}
