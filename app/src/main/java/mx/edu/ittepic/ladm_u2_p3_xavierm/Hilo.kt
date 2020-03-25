package mx.edu.ittepic.ladm_u2_p3_xavierm

import android.graphics.Color
import android.view.View
import kotlinx.android.synthetic.main.activity_juego.*

class Hilo(p: Juego): Thread(){
    private var iniciado = false
    private var pausa = false

    // VARIABLES
    var puntero = p // VARIABLE PUNTERO QUE HACE REFERENCIA AL MAINACTIVITY
    var ciclo = true // VARIABLE PARA EL CICLO DE LAS RONDAS
    var contador1 = 0 // CONTADOR DE PUNTOS DEL JUGADOR 1
    var contador2 = 0 // CONTADOR DE PUNTOS DEL JUGADOR 2
    var contador3 = 0 // CONTADOR DE PUNTOS DEL JUGADOR 3
    var contador4 = 0 // CONTADOR DE PUNTOS DEL JUGADOR 4

    var total = ArrayList<Int>() // ARREGLO PARA GUARDAR EL TOTAL DE PUNTOS
    var gana = "" // VARIABLE PARA GUARDAR AL GANADOR


    override fun run() {
        super.run()
        iniciado = true

        while (ciclo) {
            sleep(3000)
            if(!pausa){
                puntero.runOnUiThread {
                    // IF PARA MOSTRAR EL NÚMERO DE RONDA
                    if(puntero.jugador == 4 ) {
                        puntero.jugador = 0
                        puntero.ronda++
                        puntero.lblRonda.setText("Ronda ${puntero.ronda}")

                        // IF PARA CUANDO HAYAN FINALIZADO LAS 4 RONDAS
                        if(puntero.ronda == 5){
                            ciclo = false
                            puntero.lblEdoJ2.setText("esperando...")
                            puntero.lblRonda.setText("Finalizó")
                        }
                    }

                    // MIENTRAS LA RONDA SEA MENOR O IGUAL A 4
                    if(puntero.ronda <= 4) {
                        if (puntero.jugador == 0) {
                            puntero.lblEdoJ1.setText("en lanzamiento...")
                            puntero.lblEdoJ2.setText("esperando...")
                            puntero.lblEdoJ3.setText("esperando...")
                            puntero.lblEdoJ4.setText("esperando...")

                            puntero.lblEdoJ1.setTextColor(Color.parseColor("#152E17"))
                            puntero.lblEdoJ2.setTextColor(Color.parseColor("#4C4C4C"))
                            puntero.lblEdoJ3.setTextColor(Color.parseColor("#4C4C4C"))
                            puntero.lblEdoJ4.setTextColor(Color.parseColor("#4C4C4C"))
                        }
                        if (puntero.jugador == 1) {
                            puntero.lblEdoJ1.setText("esperando...")
                            puntero.lblEdoJ2.setText("en lanzamiento...")
                            puntero.lblEdoJ3.setText("esperando...")
                            puntero.lblEdoJ4.setText("esperando...")

                            puntero.lblEdoJ2.setTextColor(Color.parseColor("#152E17"))
                            puntero.lblEdoJ1.setTextColor(Color.parseColor("#4C4C4C"))
                            puntero.lblEdoJ3.setTextColor(Color.parseColor("#4C4C4C"))
                            puntero.lblEdoJ4.setTextColor(Color.parseColor("#4C4C4C"))
                        }
                        if (puntero.jugador == 2) {
                            puntero.lblEdoJ1.setText("esperando...")
                            puntero.lblEdoJ2.setText("esperando-..")
                            puntero.lblEdoJ3.setText("en lanzamiento...")
                            puntero.lblEdoJ4.setText("esperando...")

                            puntero.lblEdoJ3.setTextColor(Color.parseColor("#152E17"))
                            puntero.lblEdoJ1.setTextColor(Color.parseColor("#4C4C4C"))
                            puntero.lblEdoJ2.setTextColor(Color.parseColor("#4C4C4C"))
                            puntero.lblEdoJ4.setTextColor(Color.parseColor("#4C4C4C"))
                        }
                        if (puntero.jugador == 3) {
                            puntero.lblEdoJ1.setText("esperando...")
                            puntero.lblEdoJ2.setText("esperando...")
                            puntero.lblEdoJ3.setText("esperando...")
                            puntero.lblEdoJ4.setText("en lanzamiento...")

                            puntero.lblEdoJ4.setTextColor(Color.parseColor("#152E17"))
                            puntero.lblEdoJ1.setTextColor(Color.parseColor("#4C4C4C"))
                            puntero.lblEdoJ2.setTextColor(Color.parseColor("#4C4C4C"))
                            puntero.lblEdoJ3.setTextColor(Color.parseColor("#4C4C4C"))
                        }

                        var d1= (1..6).random().toInt()
                        var d2 = (1..6).random().toInt()

                        // MOSTRAR EL DADO 1 CORRESPONDIENTE AL RANDOM
                        when(d1){
                            1->{
                                puntero.dado1.setImageResource(R.drawable.dado1)
                            }
                            2->{
                                puntero.dado1.setImageResource(R.drawable.dado2)
                            }
                            3->{
                                puntero.dado1.setImageResource(R.drawable.dado3)
                            }
                            4->{
                                puntero.dado1.setImageResource(R.drawable.dado4)
                            }
                            5->{
                                puntero.dado1.setImageResource(R.drawable.dado5)
                            }
                            6->{
                                puntero.dado1.setImageResource(R.drawable.dado6)
                            }
                        } // WHEN

                        // MOSTRAR EL DADO 2 CORRESPONDIENTE AL RANDOM
                        when(d2){
                            1->{
                                puntero.dado2.setImageResource(R.drawable.dado1)
                            }
                            2->{
                                puntero.dado2.setImageResource(R.drawable.dado2)
                            }
                            3->{
                                puntero.dado2.setImageResource(R.drawable.dado3)
                            }
                            4->{
                                puntero.dado2.setImageResource(R.drawable.dado4)
                            }
                            5->{
                                puntero.dado2.setImageResource(R.drawable.dado5)
                            }
                            6->{
                                puntero.dado2.setImageResource(R.drawable.dado6)
                            }
                        }

                        var puntos = d1+d2
                        if(puntero.jugador == 0){
                            contador1 += puntos
                            puntero.lblPuntos.setText("$puntos")
                            puntero.lblJ1Total.setText("$contador1")

                            when(puntero.ronda){
                                1->{puntero.lblJ1T1.setText("$puntos")}
                                2->{puntero.lblJ1T2.setText("$puntos")}
                                3->{puntero.lblJ1T3.setText("$puntos")}
                                4->{puntero.lblJ1T4.setText("$puntos")}
                            }
                        }
                        if(puntero.jugador == 1) {
                            contador2 += puntos
                            puntero.lblPuntos.setText("$puntos")
                            puntero.lblJ2Total.setText("$contador2")

                            when(puntero.ronda){
                                1->{puntero.lblJ2T1.setText("$puntos")}
                                2->{puntero.lblJ2T2.setText("$puntos")}
                                3->{puntero.lblJ2T3.setText("$puntos")}
                                4->{puntero.lblJ2T4.setText("$puntos")}
                            }
                        }
                        if(puntero.jugador == 2){
                            contador3+=puntos
                            puntero.lblPuntos.setText("$puntos")
                            puntero.lblJ3Total.setText("$contador3")

                            when(puntero.ronda){
                                1->{puntero.lblJ3T1.setText("$puntos")}
                                2->{puntero.lblJ3T2.setText("$puntos")}
                                3->{puntero.lblJ3T3.setText("$puntos")}
                                4->{puntero.lblJ3T4.setText("$puntos")}
                            }
                        }
                        if(puntero.jugador == 3){
                            contador4+=puntos
                            puntero.lblPuntos.setText("$puntos")
                            puntero.lblJ4Total.setText("$contador4")

                            when(puntero.ronda){
                                1->{puntero.lblJ4T1.setText("$puntos")}
                                2->{puntero.lblJ4T2.setText("$puntos")}
                                3->{puntero.lblJ4T3.setText("$puntos")}
                                4->{puntero.lblJ4T4.setText("$puntos")}
                            }
                        }
                        sleep(1000)
                        puntero.jugador++
                    }
                }
            }
        }

        puntero.runOnUiThread {
            total.add(contador1)
            total.add(contador2)
            total.add(contador3)
            total.add(contador4)
            if (total[0] == total.max()) {
                puntero.Mensaje("GANADOR: JUGADOR 1")
            }
            if (total[1] == total.max()) {
                puntero.Mensaje("GANADOR: JUGADOR 2")
            }
            if (total[2] == total.max()) {
                puntero.Mensaje("GANADOR: JUGADOR 3")
            }
            if (total[3] == total.max()) {
                puntero.Mensaje("GANADOR: JUGADOR 4")
            }
        }
    }

    fun estaIniciado(): Boolean {
        return iniciado
    }

    fun pausar() {
        pausa = true
    }

    fun despausar() {
        pausa = false
    }

    fun detener() {
        iniciado = false
    }
}