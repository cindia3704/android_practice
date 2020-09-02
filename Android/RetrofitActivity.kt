package com.example.myapplication.Android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatViewInflater
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_recycler_view.*
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        // http://mellowcode.org/json/students/
        // http://mellowcode.org/test/code/
        val retrofit=Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")                      // url의 공통부분! 
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var personList:ArrayList<PersonFromServer>?=null
        val service = retrofit.create(RetrofitService::class.java)

        // GET 요청
        service.getStudentsList().enqueue(object : Callback<ArrayList<PersonFromServer>> {
            override fun onFailure(call: Call<ArrayList<PersonFromServer>>, t: Throwable) {
                // 통신 실패 시 호출
                Log.d("retrofit", "ERROR")
//                call.isCanceled
//                call.isExecuted
//                call.cancel()
            }

            override fun onResponse(
                call: Call<ArrayList<PersonFromServer>>,
                response: Response<ArrayList<PersonFromServer>>
            ) {
                if(response.isSuccessful()){
                    // isSuccessful() <-- 200번대면 true!
                    personList = response.body()                // 앞에서 buffer 어쩌고 부분 (이전 액티비티에서)
                    Log.d("retrofit", "res: "+personList?.get(0)?.age)

                    val code = response.code()
                    Log.d("retrofit", "code: "+code)

                    val error = response.errorBody()
                    Log.d("retrofit", "error: "+error)

                    val header=response.headers()
                    Log.d("retrofit", "header: "+header)


                }
            }
        })
        // POST 요청 (1)
//        val params = HashMap<String,Any>()
//        params.put("name","김개똥")
//        params.put("age",20)
//        params.put("intro","안녕하세요")
//
//       service.createStudnet(params).enqueue(object : Callback<PersonFromServer>{
//           override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {
//
//           }
//
//           override fun onResponse(
//               call: Call<PersonFromServer>,
//               response: Response<PersonFromServer>
//           ) {
//               if(response.isSuccessful){
//                   val person=response.body()
//                   Log.d("retro","name:"+person?.name)
//               }
//           }
//       })

        //POST요청 (2)
        val person = PersonFromServer(name="박개똥",age=30,intro="좋은하")
        service.createStudentEasy(person).enqueue(object : Callback<PersonFromServer> {
            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<PersonFromServer>,
                response: Response<PersonFromServer>
            ) {
                val person = response.body()
                Log.d("retro","nameee: "+ person?.name)
            }
        })
    }
}

//class PersonRetroAdapter(
//    val personList:ArrayList<PersonFromServer>,
//    val inflater: LayoutInflater
//):RecyclerView.Adapter<PersonRetroAdapter.ViewHolder>(){
//
//    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
//        var name:TextView
//        var age: TextView
//        var intro:TextView
//
//        init {
//            name=itemView.findViewById(R.id.person_name)
//            age=itemView.findViewById(R.id.person_age)
//            intro=itemView.findViewById(R.id.person_intro)
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view=inflater.inflate(R.layout.person_list_item,parent,false)
//        return ViewHolder(view)
//    }
//
//    override fun getItemCount(): Int {
//        return personList.size
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//       holder.name.setText(personList.get(position).name)
//        holder.age.setText(personList.get(position).age.toString())
//        holder.intro.setText(personList.get(position).intro)
//    }
//}