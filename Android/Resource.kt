package com.example.myapplication.Android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_resource.*

class Resource : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)

        //1
        val ment=resources.getString(R.string.hello)
        Log.d("mentt","ment: "+ment)

        //2
        val ment2=getString(R.string.hello)
        Log.d("mentt","ment2: "+ment2)


        val color=getColor(R.color.textView_color)
        Log.d("mentt","color: "+color)

        // 버튼의 색 바꾸기!
        buttonResource.setBackgroundColor(getColor(R.color.textView_color))



    }
}