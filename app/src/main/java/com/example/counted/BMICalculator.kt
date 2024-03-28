package com.example.counted

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.counted.databinding.ActivityBmicalculatorBinding
import com.example.counted.databinding.ActivityMainBinding

class BMICalculator : AppCompatActivity() {

    private lateinit var binding: ActivityBmicalculatorBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmicalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.weightPicker.minValue = 40
        binding.weightPicker.maxValue = 175

        binding.heightPicker.minValue = 115
        binding.heightPicker.maxValue = 275

        binding.weightPicker.setOnValueChangedListener{ _,_,_ ->
            calculateBMI()
        }

        binding.heightPicker.setOnValueChangedListener{ _,_,_ ->
            calculateBMI()
        }
    }
    private fun calculateBMI()
    {
        val height = binding.heightPicker.value
        val doubleHeight = height.toDouble() / 100

        val weight = binding.weightPicker.value

        val bmi = weight.toDouble() / (doubleHeight * doubleHeight)

        binding.resultsTV.text = String.format("Your BMI is: %.2f", bmi)
        binding.healthyTV.text = String.format("Considered: %s", healthyMessage(bmi))

    }

    private fun healthyMessage(bmi: Double): String
    {
        if (bmi < 18.5)
            return "Underweight"
        if(bmi < 25.0)
            return "Healthy"
        if (bmi < 30.0)
            return "Overweight"

        return "Obese"
    }

}