package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAltura: EditText = findViewById(R.id.edtAltura)
        val btnPeso: EditText = findViewById(R.id.edtPeso)
        val btnCalcular: Button = findViewById(R.id.bntCalcular)

        btnCalcular.setOnClickListener {

            val alturaStr = btnAltura.text.toString()
            val pesoStr = btnPeso.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {
            val alturaFinal: Float = alturaStr.toFloat()
            val pesoFinal: Float = pesoStr.toFloat()

            val altura: Float = alturaFinal * alturaFinal
            val imc = pesoFinal / altura

            val Intent = Intent(this, ResultActivity::class.java)
                .apply {
                    putExtra("EXTRA_RESULT", imc)
                }

            startActivity(Intent)
            } else {
                Toast.makeText(this, "Please complete all field", Toast.LENGTH_SHORT).show()
            }
        }
    }
}