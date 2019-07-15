package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bnguardar.setOnClickListener{
            var nombre = etNombre.text.toString()
            var correo = etCorreo.text.toString()
            var cedula = etCedula.text.toString()
            var respuesta = nombre + "\n" + correo + "\n" + cedula
            txResultado.text= respuesta
        }

    }
}
