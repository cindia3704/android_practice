package com.example.myapplication.Android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_library.*
import kotlinx.android.synthetic.main.activity_phone_book_main.*
import java.util.ArrayList

class PhoneBookMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book_main)

        Glide.with(this@PhoneBookMain)
            .load("https://www.pngfind.com/pngs/m/104-1043692_search-icon-transparent-white-search-icon-apple-png.png")
            .centerCrop()
            .into(search)

        fun addSetOnClickListener(person:Person, view: View){
            view.setOnClickListener{
                val intent= Intent(this@PhoneBookMain,PhoneBookSpecific::class.java)
                intent.apply{
                    this.putExtra("name",person.name)
                    this.putExtra("phoneNumber",person.phoneNum)
                    this.putExtra("type",person.type)
                }
                startActivity(intent)
            }
        }

        val contactList=ArrayList<Person>()
        contactList.add(Person("Jisoo Kim","01081110000","ipad"))
        contactList.add(Person("Cindia Kim","01099991111"))
        contactList.add(Person("Soyeon Lim","01022882299"))
        contactList.add(Person("Kevin Park","01011882299"))
        contactList.add(Person("Jason Lee","01088332299"))
        contactList.add(Person("Mindy Park","01011801111"))
        contactList.add(Person("Cindy Lim","01099999999"))
        contactList.add(Person("Jay Kim","01022222222"))
        contactList.add(Person("Eunbee Yoo","01011114444"))
        contactList.add(Person("Amy Yoon","01011004455"))
        contactList.add(Person("Ken Duarte","01044112244"))
        contactList.add(Person("Tae Park","01077777777"))
        val container=findViewById<LinearLayout>(R.id.phonebookContainer)
        val inflater=LayoutInflater.from(this@PhoneBookMain)
        for(i in 0 until contactList.size) {
            val itemView = inflater.inflate(R.layout.phonenumber_item, null)
            val initialName = itemView.findViewById<TextView>(R.id.name_initial)
            val fullName = itemView.findViewById<TextView>(R.id.name_full)
            // initialName.setText(contactList[i].initial)
            initialName.setText(contactList.get(i).initialName)
            fullName.setText(contactList.get(i).name)
            addSetOnClickListener(contactList.get(i), itemView)
            container.addView(itemView)
        }
    }
}

class Person(var name:String, var phoneNum:String, var type:String="Mobile"){
    var initialName=this.name[0].toString()
}