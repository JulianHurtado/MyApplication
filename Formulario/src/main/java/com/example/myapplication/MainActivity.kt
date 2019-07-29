package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_main.*
import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.widget.DatePicker
import android.widget.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() , AdapterView.OnItemSelectedListener {

    lateinit var moption: Spinner
    lateinit var result: TextView

    private var sexo = "Masculino"
    private var hobbies = ""
    private var hobbie1 = ""
    private var hobbie2 = ""
    private var hobbie3 = ""
    private var hobbie4 = ""
    private val c = Calendar.getInstance()
    private var date =""
    //lateinit var respuesta : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            val dateSetListener = object: DatePickerDialog.OnDateSetListener{
                override fun onDateSet(view: DatePicker, year: Int, month:Int, day: Int) {
                    c.set(Calendar.YEAR, year)
                    c.set(Calendar.MONTH, month)
                    c.set(Calendar.DAY_OF_MONTH, day)
                    showDatePickerDialog()
                }
            }
        moption = findViewById(R.id.spCiudad) as Spinner
        //result = findViewById(R.id.) as TextView
        result = findViewById(R.id.txResultado) as TextView



        spCiudad!!.setOnItemSelectedListener(this)


        val cityoptions = ArrayAdapter.createFromResource(this, R.array.cityOptions, android.R.layout.simple_spinner_item)
        cityoptions.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spCiudad!!.setAdapter(cityoptions)

        bnFecha.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view: View) {
                DatePickerDialog(this@MainActivity,dateSetListener, c.get(Calendar.YEAR),c.get(Calendar.MONTH),
                    c.get(Calendar.DAY_OF_MONTH)).show()
            }
        })


        bnguardar.setOnClickListener{
            var nombre = etNombre.text.toString()
            var pass1 = etPassword.text.toString()
            var pass2 = etPassword2.text.toString()
            var correo = etCorreo.text.toString()

            hobbies = hobbie1 +  hobbie2 +  hobbie3 + hobbie4


            if (pass1.equals(pass2)){
                if (nombre.equals("") || correo.equals("") || pass1.equals("") || pass2.equals("")
                    || sexo.equals("") || hobbies.equals("") || date.equals("") || result.equals("")){
                    Toast.makeText(this, "Existen Campos vacios", Toast.LENGTH_SHORT).show()
                }
                else{
                    var respuesta = nombre + "-" + pass1 + "-" +  pass2 + "-" + correo + "-" + sexo + "-" + hobbies +
                            "-" + date + "-" + result.text.toString()
                    txResultado.text= respuesta
                }
            }
            else{
                Toast.makeText(this, "Contraseñas Diferentes", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onItemSelected(arg0: AdapterView<*>, arg1: View, position: Int, id: Long) {
        result!!.text = getResources().getStringArray(R.array.cityOptions)[position]

    }

    override fun onNothingSelected(arg0: AdapterView<*>) {
        result!!.text = ""
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

    fun showDatePickerDialog(){
        val Formato = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(Formato, Locale.US)
        date = sdf.format(c.time)

        txNacimiento.text= date
    }

    fun onCheckBoxClicked(view:View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked
            when (view.id) {
                R.id.cbNadar ->
                    if(checked){
                        hobbie1 = "Futbol "
                    }
                    else{
                        hobbie1 = ""
                    }
                R.id.cbCine ->
                    if(checked){
                        hobbie2 = "Cine "
                    }
                    else{
                        hobbie2 = ""
                    }
                R.id.cbLeer ->
                    if(checked){
                        hobbie3 = "Leer"
                    }
                    else{
                        hobbie3 = ""
                    }
                R.id.cbSeries ->
                    if(checked){
                        hobbie4 = "Series"
                    }
                    else{
                        hobbie4 = ""
                    }
            }
        }
    }
}




