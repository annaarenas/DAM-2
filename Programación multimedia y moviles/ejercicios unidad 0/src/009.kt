data class Coche (
    var marca: String = "",
    var modelo: String = "",
    var anyoLanzamiento: Int = 0 ){
    override fun toString(): String {
        return "$marca $modelo ($anyoLanzamiento)"
    }
}

fun main(){
    val coche1 = Coche("Toyota", "Corolla", 2020)
    val coche2 = Coche("Ford", "Mustang", 2018)

    println(coche1)
    println(coche2)
}