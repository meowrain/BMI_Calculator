package com.example.bmiapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val weightText = findViewById<EditText>(R.id.etWeight)
        val heightText = findViewById<EditText>(R.id.etHeight)
        val calculateBtn = findViewById<Button>(R.id.calculate_btn)
        val result_val = findViewById<TextView>(R.id.result)
        calculateBtn.setOnClickListener{
            val weight = weightText.text.toString().toDouble();
            val height = heightText.text.toString().toDouble();
            val bmi_val = weight / ((height/100).pow(2))
            val judge = when {
                bmi_val < 18.5 -> "体重过轻"
                bmi_val >= 18.5 && bmi_val < 24.9 -> "正常体重"
                bmi_val >= 24.9 && bmi_val < 29.9 -> "超重"
                bmi_val >= 30 -> "肥胖"
                else -> "无效的BMI值"
            }
            result_val.setText("你的BMI值为$bmi_val,你$judge")
        }

    }
}