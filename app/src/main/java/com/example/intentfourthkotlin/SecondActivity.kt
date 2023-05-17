package com.example.intentfourthkotlin

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.intentfourthkotlin.model.Member
import com.example.intentfourthkotlin.model.User

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initView()
    }

    fun initView() {
        var b_second =findViewById<Button>(R.id.b_second_check)
        var tv_second = findViewById<TextView>(R.id.tv_second)
        var user  = intent.getSerializableExtra("user")
        tv_second.text = user.toString()

        b_second.setOnClickListener {
            var member = Member (6 ,"PDP")
            backToFinish(member)
        }


    }

    fun backToFinish(member : Member) {
        var returnIntent = Intent()
        returnIntent.putExtra("member" , member)
        setResult(RESULT_OK , returnIntent)
        finish()

    }
}