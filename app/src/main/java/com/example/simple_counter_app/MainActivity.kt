package com.example.simple_counter_app

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.view.View

class MainActivity : AppCompatActivity() {

    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.constraint)


        val textView = findViewById<TextView>(R.id.countNumber)
        val button = findViewById<Button>(R.id.btnIncrement)
        val upgradeButton = findViewById<Button>(R.id.upgradeButton)

        // Restore count after configuration changes
        counter = savedInstanceState?.getInt("counter") ?: 0
        textView.text = counter.toString()

        button.setOnClickListener {
            // Handle User Interaction
            counter++
            textView.text = counter.toString()
            Toast.makeText(it.context,"Clicked Button!", Toast.LENGTH_SHORT).show()

            if (counter >= 100){
                //Show upgrade button
                upgradeButton.visibility = View.VISIBLE
                upgradeButton.setOnClickListener {
                    button.text = "Add 2"

                    button.setOnClickListener {
                        counter += 2
                        textView.text = counter.toString()
                    }

                    upgradeButton.visibility = View.INVISIBLE
                }
            }
        }


    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("counter", counter)
        super.onSaveInstanceState(outState)
    }
}
