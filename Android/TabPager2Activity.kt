package com.example.myapplication.Android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.myapplication.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tab_pager.tab_layout
import kotlinx.android.synthetic.main.activity_tab_pager2.*

class TabPager2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_pager2)

        tab_layout2.addTab(tab_layout2.newTab().setText("ONE"))
        tab_layout2.addTab(tab_layout2.newTab().setText("TWO"))
        tab_layout2.addTab(tab_layout2.newTab().setText("THREE"))

        val adapter=ThreePageAdapter(LayoutInflater.from(this@TabPager2Activity))
        view_pager2.adapter=adapter
        view_pager2.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout2))

        tab_layout2.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                view_pager2.setCurrentItem(p0!!.position)
            }
        })
    }
}

class ThreePageAdapter(
    val layoutInflater: LayoutInflater
): PagerAdapter(){
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        // 뷰 생성
        when(position){
            0->{
                val view=layoutInflater.inflate(R.layout.fragment_one,container,false)
                container.addView(view)
                return view
            }
            1->{
                val view=layoutInflater.inflate(R.layout.fragment_two,container,false)
                container.addView(view)
                return view
            }
            2->{
                val view=layoutInflater.inflate(R.layout.fragment_three,container,false)
                container.addView(view)
                return view
            }
            else->{
                val view=layoutInflater.inflate(R.layout.fragment_one,container,false)
                container.addView(view)
                return view
            }
        }
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        // 뷰가 가려질때 / 파기되어야한다 싶을때 호출
        //`object` <-- 이게 뷰!
        // 지금 보고있는 뷰가 너가 붙인 뷰와 같아?
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        // 지금 화면에 나와 있는게 니가 만든게 맞냐?
        //`object`  <-- 자바에서의 키워드여서 ` 이거 붙여줌 (코틀린에서 키워드로 사용중)
        // === <--- 좀더 정확한 비교 (주소값 비교)
        return view ===`object` as View
    }

    override fun getCount(): Int {
        // 페이저의 카운트
        return 3
    }
}