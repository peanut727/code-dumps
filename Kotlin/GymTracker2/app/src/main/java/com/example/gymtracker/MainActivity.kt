package com.example.gymtracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private var number: Int = 0;
    private var timerNum: Long = 0;
    private var countdownTimer: CountDownTimer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val breakSel: Spinner = findViewById(R.id.breakSelection)
        val incSet = findViewById<Button>(R.id.setIncrementBtn)
        val decSet = findViewById<Button>(R.id.setDecrementBtn)
        val setsVal = findViewById<TextView>(R.id.setValue)
        val setStart = findViewById<Button>(R.id.startButton)

        ArrayAdapter.createFromResource(
            this,
            R.array.break_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            breakSel.adapter = adapter
        }
        breakSel.onItemSelectedListener = this

        incSet.setOnClickListener {
            number++
            setsVal.text = number.toString()
        }

        decSet.setOnClickListener {
            if (number > 0) {
                number--
                setsVal.text = number.toString()
            } else {
                setsVal.text = number.toString()
                number = 0
            }
        }

        setStart.setOnClickListener {
            startTimer(timerNum * 1000)
        }
    }
    private fun startTimer(timeInMillis: Long) {
        var timerValue = findViewById<TextView>(R.id.timerVal)
        val setsVal = findViewById<TextView>(R.id.setValue)

        countdownTimer?.cancel()

        countdownTimer = object : CountDownTimer(timeInMillis, 1000) { // Update the UI every 1 second.
            override fun onTick(millisUntilFinished: Long) {

                timerValue.text = (millisUntilFinished / 1000).toString()
            }

            override fun onFinish() {
                number--
                setsVal.text = number.toString()
                timerValue.text = "0"
            }
        }

        countdownTimer?.start()
    }


    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {

        val selectedItem = parent.getItemAtPosition(pos)
        val setsVal = findViewById<TextView>(R.id.setValue)
        val setTime1 = findViewById<RadioButton>(R.id.rChoice1)
        val setTime2 = findViewById<RadioButton>(R.id.rChoice2)
        val timerValue = findViewById<TextView>(R.id.timerVal)


        when (selectedItem) {
            "Muscle hypertrophy" -> {
                setTime1.text = "30 sec"
                setTime2.text = "60 sec"
                setTime1.setOnCheckedChangeListener { buttonView, isChecked ->
                    if (isChecked) {
                        timerNum = 30
                        timerValue.text = "30"
                    }
                }
                setTime2.setOnCheckedChangeListener { buttonView, isChecked ->
                    if (isChecked) {
                        timerNum = 60
                        timerValue.text = "60"
                    }
                }
            }
            "Muscle endurance" -> {
                setTime1.text = "30 sec"
                setTime2.text = "60 sec"
                setTime1.setOnCheckedChangeListener { buttonView, isChecked ->
                    if (isChecked) {
                        timerNum = 30
                        timerValue.text = "30"
                    }
                }
                setTime2.setOnCheckedChangeListener { buttonView, isChecked ->
                    if (isChecked) {
                        timerNum = 60
                        timerValue.text = "60"
                    }
                }
            }
            "Muscle power" -> {
                setTime1.text = "60 sec"
                setTime2.text = "120 sec"
                setTime1.setOnCheckedChangeListener { buttonView, isChecked ->
                    if (isChecked) {
                        timerNum = 60
                        timerValue.text = "60"
                    }
                }
                setTime2.setOnCheckedChangeListener { buttonView, isChecked ->
                    if (isChecked) {
                        timerNum = 120
                        timerValue.text = "120"
                    }
                }
            }
            "Muscle strength" -> {
                setTime1.text = "120 sec"
                setTime2.text = "300 sec"
                setTime1.setOnCheckedChangeListener { buttonView, isChecked ->
                    if (isChecked) {
                        timerNum = 120
                        timerValue.text = "120"
                    }
                }
                setTime2.setOnCheckedChangeListener { buttonView, isChecked ->
                    if (isChecked) {
                        timerNum = 300
                        timerValue.text = "300"
                    }
                }
            }
        }


    }

    override fun onNothingSelected(parent: AdapterView<*>) {

    }
}



