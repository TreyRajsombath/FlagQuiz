package com.example.app1homework

import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.app1homework.databinding.ActivityMainBinding
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var quiz: Quizflag

    val mainHandler = Handler(Looper.getMainLooper())

    inner class QuizHandler(
        private val fn: String,
        private val text: String
    ) : Runnable {

        override fun run() {
            binding.answerTextView.text = text
            loadFlagImage(fn)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quiz = Quizflag(5, 10)
        quiz.attach(this)
        quiz.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        quiz.interrupt()
    }

    private fun loadFlagImage(fileName: String) {
        try {
            assets.open("flags/$fileName").use { input ->
                val bitmap = BitmapFactory.decodeStream(input)
                binding.flagImageView.setImageBitmap(bitmap)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}