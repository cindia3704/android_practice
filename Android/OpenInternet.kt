package com.example.myapplication.Android

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_open_internet.*

class OpenInternet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open_internet)

        open.setOnClickListener {
            val address=address_edit_text.text.toString()
            val intent=Intent(Intent.ACTION_VIEW, Uri.parse(address))
            startActivity(intent)
        }

        address_edit_text.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                if(p0.toString()=="abc"){
                    Log.d("edit","text is ABC")
                }
                Log.d("edit","afterTextChanged: "+p0)
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("edit","beforTextChanged: "+p0)
                Log.d("bf","p1:"+p1.toString())
                Log.d("bf","p2:"+p2.toString())
                Log.d("bf","p3:"+p3.toString())
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("edit","onTextChanged: "+p0)
            }
        })
    }

}