package com.akshay_apps.areyoulucky

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var rollD: Button
    lateinit var diceIMG: ImageView
    lateinit var result: TextView
    lateinit var input: EditText
    var num = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rollD = findViewById(R.id.button)
        diceIMG = findViewById(R.id.dice_img)
        result = findViewById(R.id.result)
        input = findViewById(R.id.input)

    }

    fun diceRoll(view: View) {

        val userChoice = input.text.toString()
        if(userChoice.isEmpty())
        {
            Toast.makeText(this, "You haven't entered your choice!!", Toast.LENGTH_SHORT).show()
        }

        else
        {
            val d = Dice()
            num = d.roll()

            val drawableResource = when(num){
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            gotLucky()
            diceIMG.setImageResource(drawableResource)
        }
    }

    private fun gotLucky() {

        result.text = when(num){

            input.text.toString().toInt() -> "You won!!!"
            1 -> "1Better luck next time"
            2 -> "2Better luck next time"
            3 -> "3Better luck next time"
            4 -> "4Better luck next time"
            5 -> "5Better luck next time"
            6 -> "6Better luck next time"
            else -> "Kuch gadbad hai"

        }

    }


}