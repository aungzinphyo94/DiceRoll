package com.dandt.diceroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var imageDice: ImageView
    lateinit var txtTotalPoint: TextView
    lateinit var edtBetAmount: EditText
    var totalPoint = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDiceRoll: Button = findViewById(R.id.btnRoll)
        imageDice = findViewById(R.id.imgDice)
        txtTotalPoint = findViewById(R.id.totalPoint)
        txtTotalPoint.text = totalPoint.toString()
        edtBetAmount = findViewById(R.id.edtPoint)

        var betAmount: Int = 0

        btnDiceRoll.setOnClickListener {
            betAmount = edtBetAmount.text.toString().toInt()
            rollDice(betAmount)
        }
    }
    private fun rollDice(betAmount: Int) {
        val randomInt = Random().nextInt(6) + 1
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        when (randomInt) {
            1 -> totalPoint -= betAmount
            2 -> totalPoint -= betAmount
            3 -> totalPoint
            4 -> totalPoint += betAmount
            5 -> totalPoint += betAmount
            else -> totalPoint += betAmount*2
        }
        imageDice.setImageResource(drawableResource)
    }
}