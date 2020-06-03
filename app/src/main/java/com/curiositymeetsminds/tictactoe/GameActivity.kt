package com.curiositymeetsminds.tictactoe

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    private val tag = "MainActivity"
    private var grid = mutableListOf("r", "", "", "", "", "", "", "", "", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        var turn = true

        restart.setOnClickListener {
            turn = true
            restart.visibility = View.INVISIBLE
            for (i in 1..9) {
                grid[i] = ""
            }
            button1.text = ""
            button2.text = ""
            button3.text = ""
            button4.text = ""
            button5.text = ""
            button6.text = ""
            button7.text = ""
            button8.text = ""
            button9.text = ""
        }
        restart.visibility = View.INVISIBLE

        val listener = View.OnClickListener {
            val v = it as Button
            try {
                if (checkWin(grid) && grid.contains("")) {
                    if (v.text.isEmpty()) {
                        if (turn) {
                            v.text = "X"
                            when (v.id) {
                                R.id.button1 -> grid[1] = "X"
                                R.id.button2 -> grid[2] = "X"
                                R.id.button3 -> grid[3] = "X"
                                R.id.button4 -> grid[4] = "X"
                                R.id.button5 -> grid[5] = "X"
                                R.id.button6 -> grid[6] = "X"
                                R.id.button7 -> grid[7] = "X"
                                R.id.button8 -> grid[8] = "X"
                                R.id.button9 -> grid[9] = "X"
                            }
                            turn = false
                        } else {
                            v.text = "O"
                            when (v.id) {
                                R.id.button1 -> grid[1] = "O"
                                R.id.button2 -> grid[2] = "O"
                                R.id.button3 -> grid[3] = "O"
                                R.id.button4 -> grid[4] = "O"
                                R.id.button5 -> grid[5] = "O"
                                R.id.button6 -> grid[6] = "O"
                                R.id.button7 -> grid[7] = "O"
                                R.id.button8 -> grid[8] = "O"
                                R.id.button9 -> grid[9] = "O"
                            }
                            turn = true
                        }
                    }
                } else {
                    if (!grid.contains("")) {
                        Toast.makeText(this, "Match Draw", Toast.LENGTH_SHORT).show()
                    } else if (turn) {
                        Toast.makeText(this, "Player 2 WON", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Player 1 WON", Toast.LENGTH_SHORT).show()
                    }
                    restart.visibility = View.VISIBLE
                }
            } catch (e: Exception) {
                Log.e(tag, " Error!!")
            }
        }

        button1.setOnClickListener(listener)
        button2.setOnClickListener(listener)
        button3.setOnClickListener(listener)
        button4.setOnClickListener(listener)
        button5.setOnClickListener(listener)
        button6.setOnClickListener(listener)
        button7.setOnClickListener(listener)
        button8.setOnClickListener(listener)
        button9.setOnClickListener(listener)

    }

    private fun checkWin(grid: MutableList<String>): Boolean {
        var keepPlaying = true

        if ((grid[1] == "X" && grid[2] == "X" && grid[3] == "X") || (grid[1] == "O" && grid[2] == "O" && grid[3] == "O")) {
            keepPlaying = false
        } else if ((grid[4] == "X" && grid[5] == "X" && grid[6] == "X") || (grid[4] == "O" && grid[5] == "O" && grid[6] == "O")) {
            keepPlaying = false
        } else if ((grid[7] == "X" && grid[8] == "X" && grid[9] == "X") || (grid[7] == "O" && grid[8] == "O" && grid[9] == "O")) {
            keepPlaying = false
        } else if ((grid[1] == "X" && grid[4] == "X" && grid[7] == "X") || (grid[1] == "O" && grid[4] == "O" && grid[7] == "O")) {
            keepPlaying = false
        } else if ((grid[2] == "X" && grid[5] == "X" && grid[8] == "X") || (grid[2] == "O" && grid[5] == "O" && grid[8] == "O")) {
            keepPlaying = false
        } else if ((grid[3] == "X" && grid[6] == "X" && grid[9] == "X") || (grid[3] == "O" && grid[6] == "O" && grid[9] == "O")) {
            keepPlaying = false
        } else if ((grid[1] == "X" && grid[5] == "X" && grid[9] == "X") || (grid[1] == "O" && grid[5] == "O" && grid[9] == "O")) {
            keepPlaying = false
        } else if ((grid[3] == "X" && grid[5] == "X" && grid[7] == "X") || (grid[3] == "O" && grid[5] == "O" && grid[7] == "O")) {
            keepPlaying = false
        } else {
            Log.d(tag, "checkWin: Keep Playing")
        }

        return keepPlaying
    }

}
