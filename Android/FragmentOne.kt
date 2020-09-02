package com.example.myapplication.Android

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_fragment.view.*
import kotlinx.android.synthetic.main.fragment_one.*


class FragmentOne: Fragment(){

    // Fragment->ACtivity 위해 리스너 만들기
    interface OnDataPassListener{
        fun onDataPass(data: String?)
    }
    lateinit var dataPassListener: OnDataPassListener           // 당장 initialize하는 것을 늦추기 위해 lateinit

    override fun onAttach(context: Context) {
        Log.d("life_cycle","F onAttach")
        super.onAttach(context)
        dataPassListener=context as OnDataPassListener      // 형변환!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("life_cycle","F onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("life_cycle","F onStart")
        // 프라그먼트가 인터페이스를 처음으로 그릴때 호풀된다.
        // inflater --> 뷰를 그려주는 역학
        // container --> 부모뷰 (달라붙을 곳)
        return inflater.inflate(R.layout.fragment_one,container,false)
        //return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("life_cycle","F onViewCreate")
        super.onViewCreated(view, savedInstanceState)

        // Activity 의 Oncreate에서 헸던 작업(주된 작업)을 여기에서 한다
        // 리스너 달아주기!
        pass.setOnClickListener {
            dataPassListener.onDataPass("Good Bye")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("life_cycle","F onActivityCreate")
        // bundle로 넘어온 데이터 받기
        val data=arguments?.getString("hello")

        Log.d("data",data.toString())

        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d("life_cycle","F onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("life_cycle","F onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("life_cycle","F onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("life_cycle","F onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("life_cycle","F onDestroyView")
        super.onDestroyView()
    }

    override fun onDetach() {
        Log.d("life_cycle","F onDetach")
        super.onDetach()
    }
}