package com.example.counted

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.firebase.auth.FirebaseAuth

class SecondActivity2 : AppCompatActivity() {
    private lateinit var user: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second2)
        clickListener()
    }


    public fun clickListener(){
        var imageCounter = findViewById<ImageView>(R.id.ivCounter)
        var imageBMICalculator = findViewById<ImageView>(R.id.ivBMICalculator)
        var imageTwitter = findViewById<ImageView>(R.id.ivTwitter)
        var imageLogout = findViewById<ImageView>(R.id.ivLogout)

        imageCounter.setOnClickListener {
            openCounter()
        }

        imageBMICalculator.setOnClickListener {
            openBMICalculator()
        }

        imageTwitter.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.google.com/")
            startActivity(openURL)
        }

        imageLogout.setOnClickListener {
            finish()
            System.out.close()

        }

    }

    public fun openCounter(){
       startActivity(Intent(this@SecondActivity2, Counter::class.java))

    }

    public fun openBMICalculator(){
        startActivity(Intent(this@SecondActivity2, BMICalculator::class.java))
    }

}