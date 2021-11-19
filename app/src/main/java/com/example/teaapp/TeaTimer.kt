package com.example.teaapp

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.concurrent.TimeUnit

class TeaTimer : AppCompatActivity() {

    companion object {
        const val TAG = "TeaTimer"
    }

    private var timer: TextView? = null
    private var start_stop_btn: Button? = null
    private var isStarted = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tea_timer)
        initViews()
    }
        private fun initViews() {
            timer = findViewById(R.id.timer)
            start_stop_btn = findViewById(R.id.start_stop_btn)
            start_stop_btn?.setOnClickListener {
                if (!isStarted) {
                    startTimer()
                } else {
                    stopTimer()
                }
            }
        }

        private var countDownTimer = object : CountDownTimer(1000 * 60, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timer?.text = getString(
                    R.string.formatted_time,
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) % 60,
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60
                )
            }

            override fun onFinish() {
                isStarted = false
                start_stop_btn?.text = "Start"
            }
        }

//Timer button view when started
        private fun startTimer() {
            countDownTimer.start()
            isStarted = true
            start_stop_btn?.text = "Stop"
        }
//Timer button view when stopped

        private fun stopTimer() {
            countDownTimer.cancel()
            isStarted = false
            start_stop_btn?.text = "Start"
            timer?.text = "00:00"
        }
//Timer reset
        override fun onDestroy() {
            super.onDestroy()
            countDownTimer.cancel()
        }
    }
