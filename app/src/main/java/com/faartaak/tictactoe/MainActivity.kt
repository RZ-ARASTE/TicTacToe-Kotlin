package com.faartaak.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.faartaak.tictactoe.databinding.ActivityMainBinding
import kotlin.math.log
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun BTselect(view: View) {
        var BTchoice = view as Button
        var CellID = 0
        when (BTchoice.id) {
            R.id.BT2 -> CellID = 2
            R.id.BT3 -> CellID = 3
            R.id.BT1 -> CellID = 1
            R.id.BT4 -> CellID = 4
            R.id.BT5 -> CellID = 5
            R.id.BT6 -> CellID = 6
            R.id.BT7 -> CellID = 7
            R.id.BT8 -> CellID = 8
            R.id.BT9 -> CellID = 9
        }
        Log.d("CellID", CellID.toString())
        PlayGame(CellID, BTchoice)


    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var Activeplayer = 1
    fun PlayGame(CellID: Int, BTchoice: Button) {
        if (Activeplayer == 1) {
            BTchoice.text = "X"
            BTchoice.setBackgroundResource(R.color.orange)
            player1.add(CellID)
            Activeplayer = 2
            Autoplay()
        } else {
            BTchoice.text = "O"
            BTchoice.setBackgroundResource(R.color.green)
            player2.add(CellID)
            Activeplayer = 1
        }

        BTchoice.isEnabled = false
        CheckWinner()

    }

    fun CheckWinner() {
        var winner = -1
        //Row1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 2
        }

        //Row2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 2
        }

        //Row3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1

        }
        if (player2.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 2

        }


        //col1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 2
        }

        //col2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 2
        }

        //col3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1

        }
        if (player2.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 2

        }

        //cross1
        if (player1.contains(1) && player1.contains(5) && player1.contains(9))
        {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9))
        {
            winner = 2
        }

        //cross2
        if (player1.contains(3) && player1.contains(5) && player1.contains(7))
        {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7))
        {
            winner = 2
        }




        if (winner != -1) {
            if (winner == 1) {
                Toast.makeText(this, "Player 1 is the winner", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "Player 2 is the winner", Toast.LENGTH_SHORT).show()
            }

        }

    }

    fun Autoplay() {
        //Scan for empty Bottoms
        val EmptyCells = ArrayList<Int>()
        for (CellID in 1..9) {
            if (!(player1.contains(CellID) || player2.contains(CellID))) {
                EmptyCells.add(CellID)
            }
        }
        //for selecting
    val R = Random
    val RanIndex = R.nextInt(EmptyCells.size - 0)+0
    val CellID=EmptyCells[RanIndex]
        var BTselect:Button?
        when(CellID){
            1 ->BTselect=binding.BT1
            2 ->BTselect=binding.BT2
            3 ->BTselect=binding.BT3
            4 ->BTselect=binding.BT4
            5 ->BTselect=binding.BT5
            6 ->BTselect=binding.BT6
            7 ->BTselect=binding.BT7
            8 ->BTselect=binding.BT8
            9 ->BTselect=binding.BT9
            else ->{
                BTselect=binding.BT1
            }

        }

        PlayGame(CellID,BTselect)

}



}

