package com.jianhua.katdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {

    private lateinit var textview : TextView
    private lateinit var timerViewModel : TimerViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textview = findViewById(R.id.text);

        timerViewModel = ViewModelProviders.of(this).get(TimerViewModel::class.java)

        timerViewModel.getTime().observe(this, Observer {
            textview.text = ""+it.toString()
        });
    }

    fun add(view: View) {
        //timerViewModel.add()
        startActivity(intent.setClass(this,DemoActivity::class.java))

    }
}
