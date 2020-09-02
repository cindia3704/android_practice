package com.example.myapplication.Android

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_intent2.*

class Intent2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent2)

        // intent로 받은 정보 꺼내기
        // defaultValue는 key가 없는 경우를 대비해 default값  넣어줌 (아무 값 넣어줌)
        result.setOnClickListener {
            val number1= intent.getIntExtra("number1",0)
            val number2= intent.getIntExtra("number2",0)
            Log.d("number",number1.toString())
            Log.d("number",number2.toString())
            val result=number1+number2
            val resultIntent=Intent()
            resultIntent.putExtra("result",result)

            // 요청에 대한 결과값 반환 ( result code , intent에 넣어줄 반환해줄 결과 데이터)
            setResult(Activity.RESULT_OK,resultIntent)       // RESULT_OK == -1
            finish()                                        // Activity 종료 ( Intent2가 사라짐! )
            // Activity 는 스택 처럼 작동! ( Intent1 | Intent2 ---> pop ==> Intent1)

        }

    }
}