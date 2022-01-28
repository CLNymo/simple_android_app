package com.example.cassandn_oblig1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.cassandn_oblig1.databinding.ActivityQuizBinding
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding
    var questionIndex = 0
    var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_quiz)


        textQuestion.text = resources.getStringArray(R.array.questions)[0]

        buttonTrue.setOnClickListener{
            // hvis svaret er sant og bruker trykket sant, øker scoren oppdateres
            if (resources.getStringArray(R.array.answers)[questionIndex] == "T"){
                score++
                scoreQuiz.text = resources.getString(R.string.scoreText, score.toString())
            }

            if (questionIndex == 4){
                quizDone()
            }
            else{
                // gå videre til neste spm
                questionIndex ++
                textQuestion.text = resources.getStringArray(R.array.questions)[questionIndex]
            }


        }

        buttonFalse.setOnClickListener{
            // hvis svaret er usant og bruker trykket usant, øker scoren oppdateres
            if (resources.getStringArray(R.array.answers)[questionIndex] == "F"){
                score++
                scoreQuiz.text = resources.getString(R.string.scoreText, score.toString())
            }

            if (questionIndex == 4){
                quizDone()
            }
            else {
                // gå videre til neste spm
                questionIndex ++
                textQuestion.text = resources.getStringArray(R.array.questions)[questionIndex]
            }

        }

        buttonResetQuiz.setOnClickListener{
            finish()
            startActivity(intent)
        }
    }

    fun quizDone(){
        toastMessage()

        buttonTrue.isEnabled = false

        buttonFalse.isEnabled = false
    }


    fun toastMessage(){
        val message = R.string.toastQuizDone
        val toast = Toast.makeText(this, message, Toast.LENGTH_LONG)
        toast.show()
    }

}