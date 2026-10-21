package com.example.iniciosesion

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class InicioSesion : AppCompatActivity() {

    private lateinit var etName: TextInputEditText
    private lateinit var etEmail: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Enlaza con tu archivo XML
        setContentView(R.layout.activity_inicio_sesion)

        // Inicializar vistas
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnSubmit = findViewById(R.id.btnSubmit)

        // Acción al presionar el botón
        btnSubmit.setOnClickListener {
            val name = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (validateInputs(name, email, password)) {
                Toast.makeText(this, "¡Bienvenido a GymArt, $name!", Toast.LENGTH_SHORT).show()
                // Aquí llamaremos a la Base de Datos
            }
        }
    }

    private fun validateInputs(name: String, email: String, pass: String): Boolean {
        if (name.isEmpty()) {
            etName.error = "Ingresa tu nombre"
            etName.requestFocus()
            return false
        }
        if (email.isEmpty()) {
            etEmail.error = "Ingresa tu correo"
            etEmail.requestFocus()
            return false
        }
        if (pass.isEmpty() || pass.length < 6) {
            etPassword.error = "La contraseña debe tener al menos 6 caracteres"
            etPassword.requestFocus()
            return false
        }
        return true
    }
}