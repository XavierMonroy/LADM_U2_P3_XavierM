package mx.edu.ittepic.ladm_u2_p3_xavierm

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_juego.*

class Juego : AppCompatActivity() {
    var jugador = 0
    var ronda = 1
    var hilo : Hilo?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)

        btnLanzar.setOnClickListener{
            hilo = Hilo(this)
            hilo?.start()
            btnLanzar.visibility = View.INVISIBLE // UNA VEZ CLICKEADO DESAPARECE EL BOTON
        }

        btnPausa.setOnClickListener {
            hilo?.pausar()

            val dialogBuilder = AlertDialog.Builder(this)

            dialogBuilder.setMessage("PARTIDA EN PAUSA").setCancelable(false)

                .setPositiveButton("REANUDAR", DialogInterface.OnClickListener {
                        dialog, id -> hilo?.despausar()
                })

                .setNegativeButton("SALIR", DialogInterface.OnClickListener {
                        dialog, id ->
                            hilo?.detener()
                            finish()
                })

            val alert = dialogBuilder.create()
            alert.setTitle("MENU")
            alert.show()
        }
    }

    fun Mensaje(s: String) {
        AlertDialog.Builder(this)
            .setMessage(s)
            .setTitle("ATENCION")
            .setPositiveButton("OK"){d,i->}
            .show()
    }
}
