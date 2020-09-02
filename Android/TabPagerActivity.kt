package com.example.myapplication.Android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.myapplication.Androidimport.Fragment2
import com.example.myapplication.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tab_pager.*

class TabPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_pager)
        //탭 만들기
        tab_layout.addTab(tab_layout.newTab().setText("ONE"))
        tab_layout.addTab(tab_layout.newTab().setText("TWO"))
        tab_layout.addTab(tab_layout.newTab().setText("THREE"))

        val pagerAdapter=FragmentPagerAdapter(supportFragmentManager,3)
        view_pager.adapter=pagerAdapter
        
        tab_layout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }
            override fun onTabSelected(p0: TabLayout.Tab?) {
                //해당 탭이 클릭됐을때 리스너 장착!
                view_pager.currentItem=p0!!.position
            }
        })

        // 페이져가 이동했을때 탭을 이동시키는 코드
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))

    }
}

//PAGER
// 불편점 ==> 페이져가 3개 있다면 이에 해당하는 프라그먼트를 3개 만들어줘야한다 이
// ====> 프라그먼트 없이 페져 사용하는 방법:
//          - TabPager2Activity 참고!
//------------------
//|       |       |
//|   1   |    2  |
//|       |       |
//=================== 위는 1번 Fragment & 2번 Fragment

class FragmentPagerAdapter(
    fragmentManager: FragmentManager,
    val tabCount:Int
):FragmentStatePagerAdapter(fragmentManager){
    override fun getItem(position: Int): Fragment {
        // position에 해당하는 프라그먼트를 리턴해야함
        when(position){
            0->{
                return Fragment1()
            }
            1->{
                return Fragment2()
            }
            2->{
                return Fragment3()
            }
            else-> return Fragment1()
        }
    }

    override fun getCount(): Int {
        return tabCount
    }
}