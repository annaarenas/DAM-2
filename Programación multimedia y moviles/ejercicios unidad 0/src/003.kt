fun main(){
    print("Introduce un número del 1 al 7: ")
    val n : Int = readln().toInt()
    when(n){
        1 -> println("Lunes")
        2 -> println("Martes")
        3 -> println("Miércoles")
        4 -> println("Jueves")
        5 -> println("Viernes")
        6, 7 -> println("Fin de semana")
        else -> println("Número erróneo")
    }
}