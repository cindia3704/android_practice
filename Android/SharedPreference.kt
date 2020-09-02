package com.example.myapplication.Android

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_shared_preference.*

class SharedPreference : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)

        // Shared Preference에 저장하는 방법 -- 각각을 구분하기 위해 이름 + 모드=


        // Mode:
        // - MODE_PRIVATE : 생성한 application에서만 사용가능
        // - MODE_WORLD_READABLE :다른 어플에서 사용가능 ==> 읽을 수만 있다
        // - MODE_WORLD_WRITEABLE: 다른 어플에서 사용가능 ===> 읽기 + 기록 가능
        // - MODE_MULTI_PROCESS : 이미 호출되어 사용중인지 체크
        // - MODE_APPEND: 기존 preference에 신규로 추가
        // 보통은 MODE PRIVATE 사용 <-- 보통 앱을 하나만 만들기 때문
        // 예_ 카카오톡 & 카카오페이 ==> MODE_WORLD!


        // data 넣으려 할때 ==> editor를 가져와서 이를 통해 data 넣음
//        val editor: SharedPreferences.Editor=sharedPreference.edit()
//        editor.putString("Hello","안녕하세요!")
//        editor.commit()
//        editor.putString("Hello1","안녕하세요1!")
//        editor.commit()
        //sp1   --> SharedPreference
        //      -->(Key, Value) = ("Hello","안녕하세요!")
        //sp2   --> SharedPreference
        //      -->(Key, Value) = ("Hello","안녕하세요11")
        // 이렇게 한다고 sp1의 Hello 가 바뀌는게 아님! 다른 프리퍼런스!



        save_button.setOnClickListener {
            // SharedPreference에 값을 불러오는 방법
            val sharedPreference= getSharedPreferences("sp1", android.content.Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor=sharedPreference.edit()
            editor.putString("Hello","안녕하세요!")
            editor.putString("GoodBye","안녕히 가세요!")
            editor.commit()
        }
        load_button.setOnClickListener {
            // SharedPreference에 값을 불러오는 방법
            val sharedPreference=getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val value1= sharedPreference.getString("Hello","데이터 없음 ")
            val value2= sharedPreference.getString("GoodBye","데이터 없음 ")
            Log.d("key-value","Value1: "+value1)
            Log.d("key-value","Value2: "+value2)
        }
        delete_button.setOnClickListener {
            val sharedPreference=getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor=sharedPreference.edit()
            editor.remove("Hello")
            editor.commit()
        }
        delete_all_button.setOnClickListener {
            val sharedPreference=getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor=sharedPreference.edit()
            editor.clear()
            editor.commit()
        }
    }
}