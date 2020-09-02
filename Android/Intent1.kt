package com.example.myapplication.Android

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_intent.*

class Intent1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
        //refactor!!
       // val abc=10
       // val b=abc+10
        //val c=abc*10

        change_activity.setOnClickListener {
            // 명시적 인텐트

            // 인텐트 만들기 (요청 만들기)
            // this <-- 이 클래스를 넣어준다. 왜? 주변 정보를 넣어줘야하는데 이 클래스가 다 알고 있기때문
            // this , this@Intent1 <-- 완전히 동일하지만, 어떨때는 this만 넣어줄때 앱이 크래시 됨! ==> @~~ 도 넣어주는 습관 가지는게 좋음!
            // 두번째 인자 --> 어디로 갈건지!
            //val intent=Intent(this@Intent1,Intent2::class.java)

            // intent에 정보 담아서 보내기 ( intent 에 값넣기)
            // key, value 방식 --> key 와 value를 쌍으로 만들어 저장한다 (dictionary)
            //intent.putExtra("number1",1)
            //intent.putExtra("number2",2)

            // 인텐트 쏘기 (요청 보내기)
            //startActivity(intent)

            // 위와 동일한 기능! ( 더 좋은 방법 )
            //val intent2=Intent(this@Intent1,Intent2::class.java)
            // intent2를 열어서 값 넣음 <-- 블록으로 묶어버림! 가독성이 좋아짐 (intent2에 넣은 걸 다 이 블록 안에 넣음)
            //intent2.apply {
            //    this.putExtra("number1",1)
            //    this.putExtra("number2",2)
            //}
            // 전달만 하는 요청
            //startActivity(intent2)

            // 결과 반환 받는 요청 <-- 인자가 2개 ( Intent2에 요청 보내는게 여러개 있을 수 있어서 unique하게 숫자 정해줌--200)
            //startActivityForResult(intent2,200)



            // 암시적 인텐트
            // ACTION_VIEW= 두번째로 오는걸 보여주라
            val intent=Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com") )
            startActivity(intent)
        }

    }

    // 요청에 대한 결과 받을때 이 함수를 오버라이딩 해줘야함
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==200) {
            Log.d(
                "number",
                "" + requestCode
            ) // requestCode =200
            Log.d(
                "number",
                "" + resultCode
            )                                       // resultCode = Activity.RESULT_OK == -1
            val result=data?.getIntExtra("result",0)
            Log.d("number",result.toString())
        }
    }
}