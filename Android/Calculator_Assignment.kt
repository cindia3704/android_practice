package com.example.myapplication.Android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_calculator__assignment.*

class Calculator_Assignment : AppCompatActivity() {
    var total:Int=0
    var num:String=""
    var operator:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator__assignment)

        button1.setOnClickListener {
            num+="1"
            result.setText(num)
        }
        button2.setOnClickListener {
            num+="2"
            result.setText(num)
        }
        button3.setOnClickListener {
            num+="3"
            result.setText(num)
        }
        button4.setOnClickListener {
            num+="4"
            result.setText(num)
        }
        button5.setOnClickListener {
            num+="5"
            result.setText(num)
        }
        button6.setOnClickListener {
            num+="6"
            result.setText(num)
        }
        button7.setOnClickListener {
            num+="7"
            result.setText(num)
        }
        button8.setOnClickListener {
            num+="8"
        }
        button9.setOnClickListener {
            num+="9"
            result.setText(num)
        }
        button0.setOnClickListener {
            num+="0"
            result.setText(num)
        }
        buttonCA.setOnClickListener {
            total=0
            num="0"
            result.setText(num)
        }
        buttonPlus.setOnClickListener {
            when(operator){
                "plus"-> total+=num.toInt()
                "minus"-> total-=num.toInt()
                "mult"-> total*=num.toInt()
                else-> if(num=="") total=total
                    else total+=num.toInt()
            }
            operator="plus"
            result.setText(""+total)
            num=""
        }
        buttonMin.setOnClickListener {
            when(operator){
                "plus"-> total+=num.toInt()
                "minus"-> total-=num.toInt()
                "mult"-> total*=num.toInt()
                else-> if(num=="") total=total
                    else total+=num.toInt()
            }
            operator="minus"
            result.setText(""+total)
            num=""
        }
        buttonMult.setOnClickListener {
            when(operator){
                "plus"-> total+=num.toInt()
                "minus"-> total-=num.toInt()
                "mult"-> total*=num.toInt()
                else-> if(num=="") total=total
                    else total+=num.toInt()
            }
            operator="mult"
            result.setText(""+total)
            num=""
        }
        buttonEq.setOnClickListener {
            when(operator){
                "plus"-> total+=num.toInt()
                "minus"-> total-=num.toInt()
                "mult"-> total*=num.toInt()
                else-> if(num=="") total=total
                    else total+=num.toInt()
            }
            result.setText(""+total)
            num=""
            operator=""
        }

    }
}