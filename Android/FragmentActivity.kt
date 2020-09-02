package com.example.myapplication.Android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : AppCompatActivity(), FragmentOne.OnDataPassListener {
    //interface (FragmentOne.OnDataPassListener) 의 함수 구현!
    override fun onDataPass(data: String?) {            // Fragment에서 리스너 종을 울리면 듣는 부분!
        Log.d("pass",""+data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        Log.d("life_cycle","onCreate")

        val fragment1:FragmentOne= FragmentOne()

        // Fragement에 데이터를 넣어주는 방법
        val bundle:Bundle= Bundle()
        bundle.putString("hello","hello")           // key, value 방식
        fragment1.arguments=bundle                  // 프라그먼트에 데이터 넣기

        button.setOnClickListener {
            // 프라그먼트를 동적으로 작동하는 방법
            // Fragment 붙이는 방법 : replace / add
            val fragmentManager:FragmentManager =supportFragmentManager

            // Transaction
            //  - 작업의 단위 ---> 시작과 끝이 있다
            val fragmentTransaction=fragmentManager.beginTransaction()      //이 transaction을 시작하겠다!
            fragmentTransaction.replace(R.id.container,fragment1)
            fragmentTransaction.commit()
            // 끝을 내는 방법: (실제로는 별로 차이가 없음)
            //  - commit        ==> 시간 될 때 해   <-- 조금더 안정적!
            //  - commitnow     ==> 지금 당장해
        }
        buttontwo.setOnClickListener {
           // val fragment1:FragmentOne= FragmentOne()      <-- 여기에 쓰면 fragment가 안사라짐 bc 붙인걸 떼어내야하는데 새로 만들었으니까!
            // Fragment  remove / detach 하는 방법
            // remove <-- 제거 해주고, 다시 붙여주려할때 다시 붙여줌!
            // detach <== 제거 한후 다시 붙일 수 없음
            val fragmentManager=supportFragmentManager
            val fragmentTransaction=fragmentManager.beginTransaction()
            fragmentTransaction.detach(fragment1)
            fragmentTransaction.commit()
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d("life_cycle","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("life_cycle","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("life_cycle","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("life_cycle","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("life_cycle","onDestroy")
    }
}