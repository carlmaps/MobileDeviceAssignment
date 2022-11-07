package com.example.quizapp


import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnReset.setOnClickListener{
            rgQuestion.clearCheck();
            chkboxChoiceA.setChecked(false)
            chkboxChoiceB.setChecked(false)
            chkboxChoiceC.setChecked(false)
        }

        btnSubmit.setOnClickListener{
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
            val formattedDate = current.format(formatter)
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Quiz Submission Info")
                .setMessage("“Congratulations! You submitted on $formattedDate" +
                    ", You achieved ${validateAnswer()}%")
                .setPositiveButton("Ok"){dialogInterface, which ->
                    dialogInterface.dismiss()
                    finish()
                }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }

    fun validateAnswer(): Int{
        var score = 0
        if(rgC.isChecked){
            score += 50
        }

        if(chkboxChoiceA.isChecked && chkboxChoiceB.isChecked && chkboxChoiceC.isChecked){
            score += 50
        }

        return score
    }
}