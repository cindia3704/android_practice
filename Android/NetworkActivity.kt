package com.example.myapplication.Android

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatViewInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_network.*
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.reflect.typeOf

class NetworkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)

        NetworkTask(
            recycler_person,
            LayoutInflater.from(this@NetworkActivity)
        ).execute()

    }
}

class NetworkTask(
    val recyclerView: RecyclerView,
    val inflater: LayoutInflater
): AsyncTask<Any?, Any?, Array<PersonFromServer>>(){
    override fun onPostExecute(result:Array<PersonFromServer>?) {
        // mainthread로 돌아가는 부분!! <-- 이건 메인 쓰레드에서 실행됨! 따라서 UI 에 접근 가능!
        // 여기에 recycler_view 그려주면 됨
        Log.d("conn","result:"+ result)
        val adapter=PersonAdapter(result!!,inflater)
        recyclerView.adapter=adapter
        super.onPostExecute(result)
    }

    override fun doInBackground(vararg p0: Any?): Array<PersonFromServer> {
        val urlString :String = "http://mellowcode.org/json/students/"
        val url: URL= URL(urlString)
        val connection: HttpURLConnection=url.openConnection() as HttpURLConnection         // 요청 보내기

        connection.requestMethod="GET"
        connection.setRequestProperty("Content-Type","application/json")        // 헤더를 작성한것

        var buffer=""
        if(connection.responseCode== HttpURLConnection.HTTP_OK){

            Log.d("connn","inputstream: "+ connection.inputStream)
            // BufferedReader = 뭉탱이로 읽는다
            // InputStreamREader = connection.inputStream을 읽는다 -- utf-8형식으로 읽는다   <-- 컴퓨터는 바이트로 통신해서 이걸 우리가 알아들을 수 는 없다
            val reader= BufferedReader(
                InputStreamReader(
                    connection.inputStream,
                    "UTF-8"
                )
            )
            buffer=reader.readLine()            // 우리가 알고있는 언어로!
            Log.d("connn","buffer: "+buffer)

            // 이제 우리가 틀을 만들어서 틀안에 넣어서 객체를 생성 시켜야함!
        }
        // 직접 스트링을 파싱해서 틀에 넣어주는것을 다음과 같이 불편하다 ==> library 사용!
//        val temp=buffer.get(7)
//        Log.d("connn","tmep:"+temp)

        val data= Gson().fromJson(buffer,Array<PersonFromServer>::class.java)
        Log.d("connn","data: "+data[0].age)
        Log.d("connn","data: "+data[1].age)
        //val age=data[0].age
        //Log.d("connn","age:"+age)
        return data
    }
}

// RecyclerView 사용하려면 adapter를 만들어야함!!
class PersonAdapter(
    val personList:Array<PersonFromServer>,
    val inflater: LayoutInflater
): RecyclerView.Adapter<PersonAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val name:TextView
        val age:TextView
        val intro:TextView

        init {
            name=itemView.findViewById(R.id.person_name)
            age=itemView.findViewById(R.id.person_age)
            intro=itemView.findViewById(R.id.person_intro)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =inflater.inflate(R.layout.person_list_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       // Log.d("conn","size: "+personList.size.toString())
        return personList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("conn","position:"+position)
        holder.name.setText(personList[position].name ?:"")
        holder.age.setText(personList[position].age.toString())
        holder.intro.setText(personList[position].intro ?:"")

    }
}

