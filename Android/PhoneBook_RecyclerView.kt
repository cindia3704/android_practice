package com.example.myapplication.Android

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_phone_book__recycler_view.*
import java.util.ArrayList

class PhoneBook_RecyclerView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book__recycler_view)


        val contactList= ArrayList<Person>()
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

        val adapter=PhoneBookRecyclerViewAdapter(itemList = contactList, inflater = LayoutInflater.from(this@PhoneBook_RecyclerView),activity = this)
        phoneBook_recycle.adapter=adapter
        phoneBook_recycle.layoutManager=LinearLayoutManager(this@PhoneBook_RecyclerView)

    }

}

class PhoneBookRecyclerViewAdapter(
    val itemList:ArrayList<Person>,
    val inflater:LayoutInflater,
    val activity: Activity
):RecyclerView.Adapter<PhoneBookRecyclerViewAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val personName:TextView
        val personInitial:TextView
        // val personPhoneNumber:TextView

        init {
            personInitial=itemView.findViewById(R.id.name_initial)
            personName=itemView.findViewById(R.id.name_full)
            itemView.setOnClickListener{
                val intent= Intent(activity,PhoneBookSpecific::class.java)
                intent.apply{
                    this.putExtra("name",itemList.get(adapterPosition).name)
                    this.putExtra("phoneNumber",itemList.get(adapterPosition).phoneNum)
                    this.putExtra("type",itemList.get(adapterPosition).type)
                }
                activity.startActivity(intent)
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=inflater.inflate(R.layout.phonenumber_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.personName.setText(itemList.get(position).name)
        holder.personInitial.setText(itemList.get(position).initialName)
    }
}
