package com.example.myapplication.Android

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.R

class Fragment3:Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("life_cycle","F onStart")
        // 프라그먼트가 인터페이스를 처음으로 그릴때 호풀된다.
        // inflater --> 뷰를 그려주는 역학
        // container --> 부모뷰 (달라붙을 곳)
        return inflater.inflate(R.layout.fragment_three,container,false)
        //return super.onCreateView(inflater, container, savedInstanceState)
    }
}