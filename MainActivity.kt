package com.example.bankApp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referenciar inputs e botões
        val homensInput: EditText = findViewById(R.id.homensInput)
        val mulheresInput: EditText = findViewById(R.id.mulheresInput)
        val criancasInput: EditText = findViewById(R.id.criancasInput)
        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val btnLimpar: Button = findViewById(R.id.btnLimpar)

        // Referenciar TextViews para os resultados
        val resultadoCarne: TextView = findViewById(R.id.resultadoCarne)
        val resultadoAperitivos: TextView = findViewById(R.id.resultadoAperitivos)
        val resultadoTotalComida: TextView = findViewById(R.id.resultadoTotalComida)
        val resultadoCerveja: TextView = findViewById(R.id.resultadoCerveja)
        val resultadoAgua: TextView = findViewById(R.id.resultadoAgua)
        val resultadoRefrigerante: TextView = findViewById(R.id.resultadoRefrigerante)
        val resultadoTotalBebida: TextView = findViewById(R.id.resultadoTotalBebida)

        // Ação do botão Calcular
        btnCalcular.setOnClickListener {
            // Capturar entradas do usuário
            val homens = homensInput.text.toString().toIntOrNull() ?: 0
            val mulheres = mulheresInput.text.toString().toIntOrNull() ?: 0
            val criancas = criancasInput.text.toString().toIntOrNull() ?: 0

            // Cálculo de carne e aperitivos
            val totalCarne = homens * 400 + mulheres * 300 + criancas * 200
            val totalAperitivos = (homens + mulheres + criancas) * 100
            val totalComida = totalCarne + totalAperitivos

            // Cálculo de bebidas
            val totalCerveja = homens * 2000 // ml
            val totalAgua = (mulheres + criancas) * 1500 // ml
            val totalRefrigerante = (mulheres + criancas) * 500 // ml
            val totalBebidas = totalCerveja + totalAgua + totalRefrigerante

            // Exibir os resultados
            resultadoCarne.text = "$totalCarne g Carne"
            resultadoAperitivos.text = "$totalAperitivos g Aperitivos"
            resultadoTotalComida.text = "$totalComida g TOTAL"
            resultadoCerveja.text = "${totalCerveja / 1000}L Cerveja"
            resultadoAgua.text = "${totalAgua / 1000}L Água"
            resultadoRefrigerante.text = "${totalRefrigerante / 1000}L Refrigerante"
            resultadoTotalBebida.text = "${totalBebidas / 1000}L TOTAL"
        }

        // Ação do botão Limpar
        btnLimpar.setOnClickListener {
            homensInput.text.clear()
            mulheresInput.text.clear()
            criancasInput.text.clear()
            resultadoCarne.text = "Carne"
            resultadoAperitivos.text = "Aperitivos"
            resultadoTotalComida.text = "TOTAL"
            resultadoCerveja.text = "Cerveja"
            resultadoAgua.text = "Água"
            resultadoRefrigerante.text = "Refrigerante"
            resultadoTotalBebida.text = "TOTAL Bebidas"
        }
    }
}
