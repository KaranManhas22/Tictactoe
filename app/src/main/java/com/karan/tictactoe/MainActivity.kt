package com.karan.tictactoe

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.karan.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var flag = 0
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.startGame.setOnClickListener {
           check(it)
        }
        binding.resetGame.setOnClickListener {
            resetGame()
        }

    }

    fun check(view: View) {


        val btnCurrent = view as Button
        if (btnCurrent.text == "") {


            count++
            if (flag == 0) {
                btnCurrent.text = "X"
                flag = 1;
            } else {
                btnCurrent.text = "O"
                flag = 0;
            }

            val b1 = binding.btn1.text.toString()
            val b2 = binding.btn2.text.toString()
            val b3 = binding.btn3.text.toString()
            val b4 = binding.btn4.text.toString()
            val b5 = binding.btn5.text.toString()
            val b6 = binding.btn6.text.toString()
            val b7 = binding.btn7.text.toString()
            val b8 = binding.btn8.text.toString()
            val b9 = binding.btn9.text.toString()

            if (b1 == b2 && b2 == b3 && b3 != "") {
                Toast.makeText(this, "Winner is: $b1", Toast.LENGTH_SHORT).show()
                binding.etWinner.setText(b1)

            } else if (b4 == b5 && b5 == b6 && b6 != "") {
                Toast.makeText(this, "Winner is: $b4", Toast.LENGTH_SHORT).show()

                binding.etWinner.setText(b4)

            } else if (b7 == b8 && b8 == b9 && b9 != "") {
                Toast.makeText(this, "Winner is: $b7", Toast.LENGTH_SHORT).show()
                binding.etWinner.setText(b7)

            } else if (b1 == b4 && b4 == b7 && b7 != "") {
                Toast.makeText(this, "Winner is: $b1", Toast.LENGTH_SHORT).show()
                binding.etWinner.setText(b1)

            } else if (b2 == b5 && b5 == b8 && b8 != "") {
                Toast.makeText(this, "Winner is: $b2", Toast.LENGTH_SHORT).show()
                binding.etWinner.setText(b2)

            } else if (b3 == b6 && b6 == b9 && b9 != "") {
                Toast.makeText(this, "Winner is: $b3", Toast.LENGTH_SHORT).show()
                binding.etWinner.setText(b3)

            } else if (b1 == b5 && b5 == b9 && b9 != "") {
                Toast.makeText(this, "Winner is: $b1", Toast.LENGTH_SHORT).show()
                binding.etWinner.setText(b1)

            } else if (b3 == b5 && b5 == b7 && b7 != "") {
                Toast.makeText(this, "Winner is: $b3", Toast.LENGTH_SHORT).show()
                binding.etWinner.setText(b3)

            } else if (count == 9) {
                binding.etWinner.setText("Draw")
                Toast.makeText(this, "DRAW", Toast.LENGTH_SHORT).show()
            }
        }


    }

    fun resetGame() {

        binding.btn1.text = ""
        binding.btn2.text = ""
        binding.btn3.text = ""
        binding.btn4.text = ""
        binding.btn5.text = ""
        binding.btn6.text = ""
        binding.btn7.text = ""
        binding.btn8.text = ""
        binding.btn9.text = ""
        flag = 0
        count = 0
    }

}
