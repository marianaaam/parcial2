package com.example.parcial.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.parcial.R

class DatosFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var nombreEditText: EditText
    private lateinit var edadEditText: EditText
    private lateinit var correoEditText: EditText
    private lateinit var programaEditText: EditText
    private lateinit var semestreEditText: EditText
    private lateinit var guardarDatosButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_datos, container, false)

        nombreEditText = rootView.findViewById(R.id.editTextNombre)
        edadEditText = rootView.findViewById(R.id.editTextEdad)
        correoEditText = rootView.findViewById(R.id.editTextCorreo)
        programaEditText = rootView.findViewById(R.id.editTextPrograma)
        semestreEditText = rootView.findViewById(R.id.editTextSemestre)
        guardarDatosButton = rootView.findViewById(R.id.guardarDatosButton)

        sharedPreferences = requireContext().getSharedPreferences("MisDatos", Context.MODE_PRIVATE)
        cargarDatos()

        guardarDatosButton.setOnClickListener {
            guardarDatos()
        }

        return rootView
    }

    private fun cargarDatos() {
        val nombre = sharedPreferences.getString("nombre", "")
        val edad = sharedPreferences.getString("edad", "")
        val correo = sharedPreferences.getString("correo", "")
        val programa = sharedPreferences.getString("programa", "")
        val semestre = sharedPreferences.getString("semestre", "")

        nombreEditText.setText(nombre)
        edadEditText.setText(edad)
        correoEditText.setText(correo)
        programaEditText.setText(programa)
        semestreEditText.setText(semestre)
    }

    private fun guardarDatos() {
        val editor = sharedPreferences.edit()

        editor.putString("nombre", nombreEditText.text.toString())
        editor.putString("edad", edadEditText.text.toString())
        editor.putString("correo", correoEditText.text.toString())
        editor.putString("programa", programaEditText.text.toString())
        editor.putString("semestre", semestreEditText.text.toString())

        editor.apply()
    }
}
