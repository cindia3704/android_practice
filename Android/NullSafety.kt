package com.example.myapplication.Android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.R

class NullSafety : AppCompatActivity() {

    lateinit var lateCar:Car

    class Car(val number: Int){


    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_null_safety)

        val number:Int =10
        val number1:Int?=20

        // val number5:Int=number1+10           <-- error bc number1 = null or int but number 5= int!
        // 하지만, 개발하는 내가, number1이 무조건 null이 아니라는 걸 100% 알때 ==> !! 하면 위 에러가 없어짐
        val number5:Int=number1!! + 10              // 사람이 보장하는 것이기 때문에 실수가 있을수 있음 <-- 따라서 사용하지 않는게 좋음!

       // val number3= number? + number1        <-- Error
        val number3=number1?.plus(number)           // number1이 null이여서 뒷부분 실행 X!!
        Log.d("number","number3: "+number3)


        // 삼항 연산자  --> 엘비스 연산자
        // Null Safety를 위함! (결과가 null일 리가 없음)
        val number4=number1 ?: 10          // number1이 null 이 아니면--> number 4 == number1 ,, null이면 10!
        Log.d("number","number4: "+number4)

        lateCar=Car(10)     // 여기세 세팅후 사용해야 에러 발생 안함
        Log.d("number","late car: "+lateCar.number)
        // lateCar=Car(10)  세팅전에 사용하면 어플이 크래시!
    }

    fun plus(a: Int, b:Int?):Int{
        if(b!=null) return a+b
        else return a
    }

    fun plus2(a: Int, b:Int?):Int?{
       return b?.plus(a)
    }
}