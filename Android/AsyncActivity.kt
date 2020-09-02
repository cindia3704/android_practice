package com.example.myapplication.Android

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_async.*
import java.lang.Exception

class AsyncActivity : AppCompatActivity() {
    var task:BackgroundAsyncTask?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)


        start.setOnClickListener {
            task= BackgroundAsyncTask(progressbar,ment)             // 버튼 클릭 할때마다 task를 만드는것 ( async는 재사용이 불가하기 때문에 여기에 놓아야함) -- 클릭할때마다 매번 만들어지게
            task?.execute()
        }
        stop.setOnClickListener {
            task?.cancel(true)
        }

    }

    override fun onPause() {
        task?.cancel(true)
        super.onPause()
    }
}

class BackgroundAsyncTask(
    val progressbar:ProgressBar,
    val progressText:TextView
):AsyncTask<Int,Int,Int>(){
    // params -> doInBackground에서 사용할 타임
    // progress -> onProgressUpdate에서 사용할 타입
    // result -> onPostExecute에서 사용할 타입

    var percent:Int =0

    override fun onPreExecute() {
        percent=0
        progressbar.setProgress(percent)
    }

    override fun doInBackground(vararg p0: Int?): Int {
        while(isCancelled()==false){        // 자기가 실행이 됫는지 확인하는 내부적 함수 (override 의 onCancelled()가 아님!)
            percent++
            if(percent>100){
                break
            }else{
                publishProgress(percent)
            }
            try{
                Thread.sleep(100)       // 지금 이 프로그레스바 보기위해 쓰레드를 잠재워줌
            }catch (e:Exception){
                e.printStackTrace()
            }

        }
        return percent
    }

    override fun onProgressUpdate(vararg values: Int?) {
        progressbar.setProgress(values[0] ?:0)          // null 이면 0 -- 엘비스 연산자
        progressText.setText("퍼센트 : "+ values[0])
        super.onProgressUpdate(*values)
    }

    override fun onPostExecute(result: Int?) {
        progressText.setText("작업이 완료되었습니다!")
    }

    override fun onCancelled() {
        progressbar.setProgress(0)
        progressText.setText("작업이 취소되었습니다. ")
    }
}