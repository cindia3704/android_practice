package com.example.myapplication.Android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_list_view.*
import java.util.ArrayList

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val carList=ArrayList<CarForList>()
        for(i in 0 until 50){
            carList.add(CarForList(""+i+"번째 자동차", ""+i+" 순위 엔진"))
        }

        val adapter=ListViewAdapter(carList, LayoutInflater.from(this@ListViewActivity))
        listView.adapter=adapter

        listView.setOnItemClickListener { adapterView, view, i, l ->
            val carName=(adapter.getItem(i) as CarForList).name
            val carEngine=(adapter.getItem(i) as CarForList).engine

            Toast.makeText(this,carName+" "+carEngine,Toast.LENGTH_SHORT).show()
        }

    }
}

// Adapter은 화면에 총 몇개를 보여줄건지 조종하는 것
class ListViewAdapter(
    val carForList:ArrayList<CarForList>,
    val layoutInflater: LayoutInflater
): BaseAdapter(){
    //뷰를 그리는 부분
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        // addView에서 한것과 정말 유사
//        val view=layoutInflater.inflate(R.layout.item_view,null)
//        var carNameTextView=view.findViewById<TextView>(R.id.car_name)
//        var carEngineTextview=view.findViewById<TextView>(R.id.car_engine)
//
//        carNameTextView.setText(carForList.get(p0).name)
//        carEngineTextview.setText(carForList.get(p0).engine)
//        return view

        // View Holder사용해서 개선하기
        val view: View
        val holder: ViewHolder


        if(p1==null){
            // 재활용할게 없다면 뷰를 만들어주기
            Log.d("convert","1")
            view=layoutInflater.inflate(R.layout.item_view,null)
            holder= ViewHolder()
            // 홀더에 view에 대한거를 다 넣어줌
            holder.carName=view.findViewById(R.id.car_name)
            holder.carEngine=view.findViewById(R.id.car_engine)

            // 뷰를 찾을 수 있게 태그 달아주기
            view.tag=holder
        }else{
            Log.d("convert","2")
            // 재사용할게 있으면
            holder=p1.tag as ViewHolder
            view=p1
        }
        //holder가 null이 아닌경우에 setText ==> ? 사용
        holder.carName?.setText(carForList.get(p0).name)
        holder.carEngine?.setText(carForList.get(p0).engine)
        return view
    }

    override fun getItem(p0: Int): Any {
        //그리고자 하는 아이템 리스트의 하나(포지션에 해당하는)를 알려주면 됨
        return carForList.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        // 리스트를 그리려면 각각 아이디가 있어야하는데, 이 아이디를 포지션으로 해주겠다는 뜻
        // 해당 포지션에 위치해 있는 아이템 뷰의 아이디 설정
        return p0.toLong()
    }

    override fun getCount(): Int {
        //내가 가지고 있는 리스트의 숫자를 알려줘야함
        // 그리고자 하는 아이템 리스트의 전체 갯수
        return carForList.size
    }
}

class ViewHolder{
    var carName:TextView? = null
    var carEngine:TextView?=null
}