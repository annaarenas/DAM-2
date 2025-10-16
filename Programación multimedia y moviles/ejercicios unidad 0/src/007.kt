fun main(){
    val diasSemana = arrayOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")
    print("Introduce un día de la semana (1-7): ")
    val dia = readln().toInt() - 1

    if(dia < 1 || dia > 7){
        for((posicion, valor) in diasSemana.withIndex()){
            println("${posicion + 1}=${valor}")
        }
    } else {
        println("${dia + 1}=${diasSemana[dia]}")
    }
}