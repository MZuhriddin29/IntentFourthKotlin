package com.example.intentfourthkotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.example.intentfourthkotlin.model.Member
import com.example.intentfourthkotlin.model.User

class MainActivity : AppCompatActivity() {
    val LAUNCH_SECOND = 29
    lateinit var tv_main :TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }
    var detailLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){result ->
        if (result.resultCode == Activity.RESULT_OK){
            val data :Intent? = result.data
            var member :Member = data!!.getSerializableExtra("member") as Member
            tv_main.text = member.toString()
        }
        }



    fun initView() {
         tv_main = findViewById<TextView>(R.id.tv_main)
        var b_main_check = findViewById<Button>(R.id.b_main_check)
        b_main_check.setOnClickListener {
            var user = User (21 , "Zuhriddin")
            openSecondActivity(user)
        }
    }

    fun openSecondActivity(user: User) {
        var intentz = Intent(this , SecondActivity::class.java)
        intentz.putExtra("user" , user)
        detailLauncher.launch(intentz)
    }
}