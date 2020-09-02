package com.example.myapplication.Android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_listener.*
import kotlinx.android.synthetic.main.activity_listener.view.*

class Listener : AppCompatActivity() {
    // 정적인 뷰 ==> xml로 그림
    // 동적인 뷰 ==> activity로 뷰를 가져와서 뷰 조작

    var number=10
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listener)
        // 우리가 뷰를 가져오고, 그 뷰에 리스너를 달아줌으로써, 사용자의 인풋을 캐치할 수 있다


        // 뷰를 activity로 가져오는 방법
        // 1. 직접 찾아서 가져온
        // val textView:TextView=findViewById(R.id.hello)다
        // 2. xml을 import해서 가져온다
        //hello.

        // 사용자가 클릭하면  {} 가 호출됨! 밑에 "View" 는 hello
        // 1-> lambda 방식!!<-- 익명함수를 축약해서 쓴거
        hello.setOnClickListener {
            Log.d("click","Click!!")
        }

        // 2-> 익명함수 방식
        // 익명함수 방식으로 작성 (위와 완전히 똑같!)
        hello.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v:View?){
                Log.d("click","Click!!")
            }
        })

        // 3-> 이름이 필요한 경우(click)
        val click = object: View.OnClickListener{
            override fun onClick(v:View?){
                Log.d("click","Click!!")
                hello.setText("안녕하세요")
                image.setImageResource(R.drawable.dog)
                number+=10
                Log.d("number",number.toString())
            }
        }
        hello.setOnClickListener(click)


        // 하나의 뷰에 3개의 리스너를 달았는데, 제일 마지막에 달아준 리스너가 적용된다!


        // 뷰를 조작하는 함수들
        // 1> hello.setText("안녕하세요")
        // 2>image.setImageResource(R.drawable.dog)

        



    }
}