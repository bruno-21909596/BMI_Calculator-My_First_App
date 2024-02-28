package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val tvResult = findViewById<TextView>(R.id.tvResult)
        val btnClassificacao = findViewById<TextView>(R.id.btnClassificacao)
        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        var classificacao = " "

        if (result > 18.5) {
            if (result in 18.5..24.9) {
                classificacao = "Normal weight " } else if (result >= 25 && result < 29.9 ){
                classificacao = "Overweight " } else if (result >= 30 && result < 34.9 ){
                classificacao = "Obesity - Grade 1 " } else if (result >= 35 && result < 39.9 ){
                classificacao = "Obesity - Grade 2 " } else if (result >= 40){
                classificacao = "Obesity - Grade 3 " }
        }
        btnClassificacao.text = getString(R.string.message_classificacao, classificacao)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}