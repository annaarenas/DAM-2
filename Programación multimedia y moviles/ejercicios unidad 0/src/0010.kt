class Libro(autor: String, titulo: String, anyo: Int) {
    var titulo: String = titulo
        set(valor) {
            field = if (valor.isEmpty()) "Anonimo" else valor
        }
    var autor: String = autor
        set(valor) {
            field = if (valor.isEmpty()) "No indicado" else valor
        }
    var anyo: Int = anyo
        set(valor) {
            field = if (valor < 0) -1 else valor
        }

    override fun toString(): String {
        return "$titulo - $autor - $anyo"
    }
}

fun main(){
    var libro1 = Libro("Stephen King", "It", 1986)
    println(libro1)
}