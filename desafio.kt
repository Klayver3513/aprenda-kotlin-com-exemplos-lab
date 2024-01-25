enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val name:String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario:Usuario){
		this.inscritos.add(usuario)
    }
}

fun main() {
    var id: Int = 1;
	 val formacoes: MutableList<Formacao> = mutableListOf(
        Formacao("basica", Nivel.BASICO, mutableListOf(
            ConteudoEducacional("Kotlin aula inicial"),

            )),
        Formacao("media", Nivel.INTERMEDIARIO, mutableListOf(
            ConteudoEducacional("Kotlin aula intermediário"),

            )),
        Formacao("Avançada", Nivel.DIFICIL, mutableListOf(
            ConteudoEducacional("Kotlin aula avançado"),
 
     		)),
         )
 			println(formacoes)
                for (formacao in formacoes) {
        when(id) {
            0 -> formacao.matricular(Usuario("amanda"))
            1 -> formacao.matricular(Usuario("klayver"))
            2 -> formacao.matricular(Usuario("davi"))
        }
        print("\tNome: ${formacao.nome}\tNivel: ${formacao.nivel}\tInscritos: ")
        for (usuario in formacao.inscritos) {
            print("${usuario.name} ")
        }
        print("\n\t\tConteúdos:\n")
        for (conteudo in formacao.conteudos) {
            println("\t\t\tNome: ${conteudo.nome}  Duração: ${conteudo.duracao} minutos")
        }
}
}