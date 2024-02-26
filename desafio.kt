// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

class Formacao(val nome: String, var nivel: Nivel, var conteudos: MutableList<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação $nome")
    }

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
        println("Conteúdo ${conteudo.nome} adicionado à formação $nome")
    }

    fun listarConteudos() {
        println("Conteúdos da formação $nome:")
        for (conteudo in conteudos) {
            println("${conteudo.nome} - Duração: ${conteudo.duracao} minutos")
        }
    }

    fun listarInscritos() {
        println("Inscritos na formação $nome:")
        for (usuario in inscritos) {
            println(usuario.nome)
        }
    }
}

fun main() {
    val usuario1 = Usuario("João")
    val usuario2 = Usuario("Maria")

    val conteudo1 = ConteudoEducacional("Introdução à Programação", 90)
    val conteudo2 = ConteudoEducacional("Estrutura de Dados", 120)
    val conteudo3 = ConteudoEducacional("Algoritmos Avançados", 150)

    val formacao1 = Formacao("Formação Java", Nivel.INTERMEDIARIO, mutableListOf())
    formacao1.adicionarConteudo(conteudo1)
    formacao1.adicionarConteudo(conteudo2)

    val formacao2 = Formacao("Formação Kotlin", Nivel.BASICO, mutableListOf())
    formacao2.adicionarConteudo(conteudo1)
    formacao2.adicionarConteudo(conteudo3)

    formacao1.matricular(usuario1)
    formacao1.matricular(usuario2)
    formacao2.matricular(usuario1)

    formacao1.listarConteudos()
    formacao2.listarConteudos()

    formacao1.listarInscritos()
    formacao2.listarInscritos()
}
