package com.example.myapplication.Android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_recycler_view.*
import java.util.ArrayList

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val carList=ArrayList<CarForList>()
        for(i in 0 until 30){
            carList.add(CarForList(""+i+"번째 자동차", ""+i+" 순위 엔진"))
        }

        val adapter=RecylerViewAdapter(carList, LayoutInflater.from(this@RecyclerViewActivity))
        recycler_view.adapter=adapter
        recycler_view.layoutManager=LinearLayoutManager(this@RecyclerViewActivity)
        //recycler_view.layoutManager=GridLayoutManager(this,2)
    }
}

class RecylerViewAdapter(
    val itemList:ArrayList<CarForList>,
    val inflater:LayoutInflater
):RecyclerView.Adapter<RecylerViewAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val carName:TextView
        val carEngine:TextView

        init{
            carName=itemView.findViewById(R.id.car_name)
            carEngine=itemView.findViewById(R.id.car_engine)
            itemView.setOnClickListener{
                val position:Int= adapterPosition
                val engineName= itemList.get(position).engine
                Log.d("engine",""+engineName)
               // Toast.makeText(this,"Engine is: "+engineName,Toast.LENGTH_SHORT)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=inflater.inflate(R.layout.item_view,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.carName.setText(itemList.get(position).name)
        holder.carEngine.setText(itemList.get(position).engine)
    }
}