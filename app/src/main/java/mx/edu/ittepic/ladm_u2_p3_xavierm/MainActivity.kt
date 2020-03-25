package mx.edu.ittepic.ladm_u2_p3_xavierm

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAcerca.setOnClickListener {
            Mensaje("App desarrollada por Xavier Monroy")
        }

        btnSalir.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this)

            dialogBuilder.setMessage("¿DESEA SALIR?")

                .setPositiveButton("SALIR", DialogInterface.OnClickListener {
                        dialog, id -> finish()
                })

                .setNegativeButton("NO", DialogInterface.OnClickListener {
                        dialog, id ->
                })

            val alert = dialogBuilder.create()
            alert.setTitle("MENU")
            alert.show()
        }

        btnJugar.setOnClickListener {
            var ventanaJuego = Intent(this,Juego::class.java)
            startActivity(ventanaJuego)
        }
    }

    private fun Mensaje(s: String) {
        AlertDialog.Builder(this)
            .setMessage(s)
            .setTitle("ATENCION")
            .setPositiveButton("OK"){d,i->}
            .show()
    }
}
