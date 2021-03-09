package com.example.mobileprogramming_ass2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        zero.setOnClickListener {appendOnExpression("0", true)}
        one.setOnClickListener {appendOnExpression("1", true)}
        two.setOnClickListener {appendOnExpression("2", true)}
        three.setOnClickListener {appendOnExpression("3", true)}
        four.setOnClickListener {appendOnExpression("4", true)}
        five.setOnClickListener {appendOnExpression("5", true)}
        six.setOnClickListener {appendOnExpression("6", true)}
        seven.setOnClickListener {appendOnExpression("7", true)}
        eight.setOnClickListener {appendOnExpression("8", true)}
        nine.setOnClickListener {appendOnExpression("9", true)}
        dot.setOnClickListener {appendOnExpression(".", true)}

        plus.setOnClickListener {appendOnExpression("+", false)}
        minus.setOnClickListener {appendOnExpression("-", false)}
        divide.setOnClickListener {appendOnExpression("/", false)}
        multiply.setOnClickListener {appendOnExpression("*", false)}
        power2.setOnClickListener {appendOnExpression("^2", false)}
        power3.setOnClickListener {appendOnExpression("^3", false)}
        sqrt.setOnClickListener {appendOnExpression("sqrt", true)}

        clear.setOnClickListener {
            screenProgress.text = " "
            screenResult.text = " "
        }

        equal.setOnClickListener {
            try{
                val expression = ExpressionBuilder(screenProgress.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()

                if(result == longResult.toDouble())
                    screenResult.text = longResult.toString()
                else
                    screenResult.text = result.toString()
            }catch (e:Exception) {
                Log.d("Exception", "message: " + e.message)
            }
        }
    }

    fun appendOnExpression(string: String, canClear: Boolean){
        if(canClear){
            screenResult.text=" "
            screenProgress.append(string)
        }else{
            screenProgress.append(screenResult.text)
            screenProgress.append(string)
            screenResult.text = " "
        }
    }
}