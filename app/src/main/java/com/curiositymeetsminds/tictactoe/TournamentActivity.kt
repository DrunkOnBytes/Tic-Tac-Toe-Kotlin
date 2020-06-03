package com.curiositymeetsminds.tictactoe

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_tournament.*

class TournamentActivity: AppCompatActivity() {

    private val tag = "TournamentActivity"
    private var grid = mutableListOf("r", "", "", "", "", "", "", "", "", "")

//    private val extras: Bundle = intent.extras!!
//    private val numberOfGames = extras.getInt("key")
    private var numberOfGames = 0
    private var scoreOne = 0
    private var scoreTwo = 0
    private var tournamentWin = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tournament)
//        Log.d(tag, "No. of games are $numberOfGames")

        var turn = true

        fun restart() {
            turn = true
            for (i in 1..9) {
                grid[i] = ""
            }
            btn1.text = ""
            btn2.text = ""
            btn3.text = ""
            btn4.text = ""
            btn5.text = ""
            btn6.text = ""
            btn7.text = ""
            btn8.text = ""
            btn9.text = ""
        }


        val listener = View.OnClickListener {
            val v = it as Button
            try {
                if (!tournamentWin) {
                    if (checkWin(grid) && grid.contains("")) {
                        if (v.text.isEmpty()) {
                            if (turn) {
                                v.text = "X"
                                when (v.id) {
                                    R.id.btn1 -> grid[1] = "X"
                                    R.id.btn2 -> grid[2] = "X"
                                    R.id.btn3 -> grid[3] = "X"
                                    R.id.btn4 -> grid[4] = "X"
                                    R.id.btn5 -> grid[5] = "X"
                                    R.id.btn6 -> grid[6] = "X"
                                    R.id.btn7 -> grid[7] = "X"
                                    R.id.btn8 -> grid[8] = "X"
                                    R.id.btn9 -> grid[9] = "X"
                                }
                                turn = false
                            } else {
                                v.text = "O"
                                when (v.id) {
                                    R.id.btn1 -> grid[1] = "O"
                                    R.id.btn2 -> grid[2] = "O"
                                    R.id.btn3 -> grid[3] = "O"
                                    R.id.btn4 -> grid[4] = "O"
                                    R.id.btn5 -> grid[5] = "O"
                                    R.id.btn6 -> grid[6] = "O"
                                    R.id.btn7 -> grid[7] = "O"
                                    R.id.btn8 -> grid[8] = "O"
                                    R.id.btn9 -> grid[9] = "O"
                                }
                                turn = true
                            }
                        }
                    } else {
                        if (!grid.contains("")) {
                            if (numberOfGames < 5) {
                                Toast.makeText(this, "Match Draw", Toast.LENGTH_LONG).show()
                                numberOfGames += 1
                                restart()
                            } else {
                                tournamentWin = true
                            }
                        } else if (turn) {
                            if (numberOfGames < 5) {
                                Toast.makeText(this, "Player 2 WON", Toast.LENGTH_LONG).show()
                                scoreTwo += 1
                                playerTwo.text = scoreTwo.toString()
                                numberOfGames += 1
                                restart()
                            } else {
                                tournamentWin = true
                            }
                        } else {
                            if (numberOfGames < 5) {
                                Toast.makeText(this, "Player 1 WON", Toast.LENGTH_LONG).show()
                                scoreOne += 1
                                playerOne.text = scoreOne.toString()
                                numberOfGames += 1
                                restart()
                            } else {
                                tournamentWin = true
                            }
                        }
                    }
                } else {
                    when {
                        scoreOne < scoreTwo -> Toast.makeText(this, "Player 2 won the tournament.", Toast.LENGTH_SHORT).show()
                        scoreOne > scoreTwo -> Toast.makeText(this, "Player 1 won the tournament.", Toast.LENGTH_SHORT).show()
                        else -> Toast.makeText(this, "Tournament draw.", Toast.LENGTH_SHORT).show()
                    }

                }
            } catch (e: Exception) {
                Log.e(tag, " Error!!")
            }
        }

        btn1.setOnClickListener(listener)
        btn2.setOnClickListener(listener)
        btn3.setOnClickListener(listener)
        btn4.setOnClickListener(listener)
        btn5.setOnClickListener(listener)
        btn6.setOnClickListener(listener)
        btn7.setOnClickListener(listener)
        btn8.setOnClickListener(listener)
        btn9.setOnClickListener(listener)
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