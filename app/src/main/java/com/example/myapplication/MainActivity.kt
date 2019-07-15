package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //private lateinit var sexo: String
    private var sexo = "Masculino"
    private var hobbies = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bnguardar.setOnClickListener{
            var nombre = etNombre.text.toString()
            var correo = etCorreo.text.toString()
            var cedula = etCedula.text.toString()
            var respuesta = nombre + "\n" + correo + "\n" + cedula + "\n" + sexo + "\n" + hobbies
            txResultado.text= respuesta
        }
    }

    fun onRadioButtonClicked(view:View){

        if (view is RadioButton){
            when(view.id){
                R.id.rbMasculino ->
                    if(view.isChecked){
                        sexo= "Masculino"
                    }
                R.id.rbFemenino ->
                    if(view.isChecked){
                        sexo= "Femenino"
                    }
            }
        }
    }

    fun onCheckBoxClicked(view:View) {
        if (view is CheckBox) {
            when (view.id) {
                R.id.cbNadar ->
                    if (view.isChecked) {
                        hobbies = hobbies + "Nadar "
                    }
                R.id.cbCine ->
                    if (view.isChecked) {
                        hobbies = hobbies + "Cine "
                    }
                R.id.cbLeer ->
                    if (view.isChecked) {
                        hobbies = hobbies + "Leer "
                    }
                R.id.cbSeries ->
                    if (view.isChecked) {
                        hobbies = hobbies + "Series "
                    }
            }
        }
    }
}
