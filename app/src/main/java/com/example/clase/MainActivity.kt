package com.example.clase

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


typealias aliasdato = MutableMap<Int, ArrayList<String>>
typealias aliasfuncion = (a: Int, b: Int) -> Int

class MainActivity : AppCompatActivity() {
    //:)
    companion object {
        lateinit var maincontext: Context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        var usuario = " Soy   yo  "
        println("${usuario} ${usuario.length} - ${usuario.noSpaces()} ${usuario.noSpaces().length}")
        println("$usuario ${usuario.length} - ${SinSpaces(usuario)} ${SinSpaces(usuario).length}")


        var array1: Array<Int> = arrayOf(1, 2, 3)
        var array2 = IntArray(3)

        array2[0] = 10
        array2[1] = 12
        array2[2] = 15

        println("array2: ")
        array2.show()

        var array3: IntArray = intArrayOf(1, 2, 3, 4)
        println("array3: ")
        array3.show()

        println("La suma de 80 y 20 es ${Calculadora(80, 20, ::suma)}")
        println("La resta de 80 y 20 es ${Calculadora(80, 20, ::resta)} ")
        println("La multiplicacion de 80 y 20 es ${Calculadora(80, 20, ::multiplica)}")
        println("La division de 80 y 20 es ${Calculadora(80, 20, ::divide)}")

        var funcion = { x: Int, y: Int -> x + y }
        println("La suma de 80 y 20 es ${Calculadora(80, 20, funcion)}")

        funcion = { x: Int, y: Int -> x - y }
        println("La resta de 50 y 30 es ${Calculadora(50, 30, funcion)}")
        println(
            "La multiplicacion de 40 y 30 es ${
                Calculadora(
                    40,
                    30,
                    { x: Int, y: Int -> x * y })
            }"
        )
        println("La division de 1200 y 20 es ${Calculadora(1200, 20, { x: Int, y: Int -> x / y })}")

        println("La potencia de 2 elevado a 5 con lambda es ${
            Calculadora(2, 5)
            { x, y ->
                var valor = 1
                for (i in 1..y) valor *= x

                valor
            }
        }")

        var array4 = IntArray(10) { 5 }
        println("array4 ")
        array4.show()

        var array5 = IntArray(10) { it }
        println("array5")
        array5.show()

        var array6 = IntArray(10) { it * 2 }
        println("array6")
        array6.show()

        var array7 = IntArray(10) { i -> i * 3 }
        println("array7")
        array7.show()

        var suma = 0

        recorrerArray(array7) {
            suma += it
        }
        println("La suma del array7 es $suma")


        var persona1: Person = Person("Jota", "0241212", 1.4f)

        if (persona1.checkPolicia(::inColombia)) println("puede ser policia en colombia")
        if (persona1.checkPolicia(::inPeru)) println("puede ser policia en peru")


        var saludos: aliasdato = mutableMapOf()
        saludos[0] = arrayListOf("Hola", "Adios")
        saludos[1] = arrayListOf("Hi", "Bye")

        for ((id, palabras) in saludos)
            println("$id,$palabras")


        /*var sol: star = star("Sol", 21424f, "Via Lactea")
        println(sol)

        var (name_star2, radius_star2, galaxy2) = star("Sol2", 21424f, "Via Lactea2")
        println("Datos Star2 Desestructurada: $name_star2,$radius_star2,$galaxy2")

        var (name_star2, _, galaxy2) = star("Sol2", 21424f, "Via Lactea2")

        var componente = star("Sol2", 21424f, "Via Lactea2")
        println("Datos star5 con componentes: $(componente.component1)")*/
    }

    private fun recorrerArray(array: IntArray, fn: (Int) -> Unit) {
        for (i in array)
            fn(i)
    }

    private fun inColombia(h: Float): Boolean {
        return h >= 1.6f
    }

    private fun inPeru(h: Float): Boolean {
        return h >= 1.2f
    }

    private fun Calculadora(n1: Int, n2: Int, fn: (Int, Int) -> Int): Int {
        return fn(n1, n2)
    }

    private fun suma(x: Int, y: Int): Int {
        return x + y
    }

    private fun resta(x: Int, y: Int): Int {
        return x - y
    }

    private fun multiplica(x: Int, y: Int) = x * y
    private fun divide(x: Int, y: Int) = x / y


    private fun IntArray.show() {
        println("[")
        for (i in this) print("$i ")
        println("]")
    }

    private fun String.noSpaces(): String {
        return this.replace(" ", "")
    }

    private fun SinSpaces(texto: String): String {
        return texto.replace(" ", "")
    }


}