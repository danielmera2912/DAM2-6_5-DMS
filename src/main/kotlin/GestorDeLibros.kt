package un6.eje6_5

import CatalogoLibrosJSON
import CatalogoLibrosXML
import java.util.logging.Level
import java.util.logging.LogManager

internal val l = LogManager.getLogManager().getLogger("").apply { level = Level.ALL }
internal fun i(tag: String, msg: String) {
    l.info("[$tag] - $msg")
}


fun main() {
    var portatil = "Catalog.xml"
    val gestorDeLibros = gestionLibrosIU(portatil)
    gestorDeLibros.preguntarPorUnLibro()
    gestorDeLibros.mostrarInfoDeUnLibro()

}

interface Libro{
    fun preguntarPorUnLibro() {

        println("Introduzca un ID: ")
        var idLibro = readln()
    }

    fun mostrarInfoDeUnLibro()
    {

        println("Introduzca un ID: ")
        var idLibro = readln()

    }
}
open class gestionLibrosIU(cargador:String): Libro
{
    var esXML: Boolean = true
    var terminacion: String= cargador.subSequence(cargador.length-3, cargador.length) as String
    var cargador= cargador
    var cat1: CatalogoLibrosXML? = null
    var cat2: CatalogoLibrosJSON? = null

    override fun preguntarPorUnLibro() {
        if(terminacion.equals("xml")){
            cat1 = CatalogoLibrosXML(cargador)
            esXML= true
        }
        else{
            cat2= CatalogoLibrosJSON(cargador)
            esXML= false
        }
        println("Introduzca un ID: ")
        var idLibro = readln()
        if(esXML==true){
            if (cat1?.existeLibro(idLibro) == true)
                println("El libro $idLibro existe!")
            else
                println("El libro $idLibro NO existe!")
        }else{
            if (cat2?.existeLibro(idLibro) == true)
                println("El libro $idLibro existe!")
            else
                println("El libro $idLibro NO existe!")
        }



    }

    override fun mostrarInfoDeUnLibro()
    {
        if(terminacion.equals("xml")){
            cat1 = CatalogoLibrosXML(cargador)
            esXML= true
        }
        else{
            cat2= CatalogoLibrosJSON(cargador)
            esXML= false
        }
        println("Introduzca un ID: ")
        var idLibro = readln()
        if(esXML==true){
            var infoLibro = cat1?.infoLibro(idLibro)
            if (infoLibro != null) {
                if (!infoLibro.isEmpty())
                    println("La información sobre es la siguiente\n$infoLibro")
                else
                    println("No se encontró información sobre el libro")
            }
        }else{
            var infoLibro = cat2?.infoLibro(idLibro)
            if (infoLibro != null) {
                if (!infoLibro.isEmpty())
                    println("La información sobre es la siguiente\n$infoLibro")
                else
                    println("No se encontró información sobre el libro")
            }
        }

    }

}