package com.example.myapplication.Android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_thread.*

class ThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)

        // interface 구현
        val runnable: Runnable= object:Runnable{
            override fun run() {
                Log.d("Thread-1","Thread1 is made")
            }
        }
        val thread : Thread= Thread(runnable)

        // 버튼 클릭하면 쓰레드 시작
        button.setOnClickListener {
            // 쓰레드 실행하기
            thread.start()
        }

        // 위 방법과 동일한 2개의 방식들:
        // lambda를 사용하지 않은 방식
        Thread(object :Runnable{
            override fun run() {
                Log.d("Thread-1","Thread2 is made")
            }
        }).start()

        //lambda 방식
        Thread(Runnable {
            Thread.sleep(2000)                  // 쓰레드가 실행되고, 2초동안 잔후 로그 실행 시킴
            Log.d("Thread-1","Thread3 is made")
            // UI 쓰레드만 이런 버튼같은거에 접근할 수 있음
            //button.setBackgroundColor(getColor(R.color.textView_color))
            runOnUiThread{      // 이걸 추가하면 앱 크래시 안남 b/c 이건 main thread!
                button.setBackgroundColor(getColor(R.color.textView_color))     // 2초 뒤에 버튼 색 바뀜
            }
        }).start()



    }
}