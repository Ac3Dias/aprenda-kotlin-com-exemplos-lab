// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, val idade: Int, val email: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(
    val nome: String,
    val descricao: String,
    val nivel: Nivel,
    var conteudos: List<ConteudoEducacional>
) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
            println("Matrícula realizada com sucesso para ${usuario.nome} na formação $nome.")
        } else {
            println("${usuario.nome} já está matriculado nesta formação.")
        }
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 90)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos em Kotlin", 120)

    val formacaoKotlinBasico = Formacao(
        "Kotlin Básico",
        "Fundamentos do Kotlin",
        Nivel.BASICO,
        listOf(conteudo1, conteudo2)
    )

    val usuario1 = Usuario("João", 25, "joao@email.com")
    val usuario2 = Usuario("Maria", 30, "maria@email.com")

    formacaoKotlinBasico.matricular(usuario1)
    formacaoKotlinBasico.matricular(usuario2)

    // Imprimir informações para verificar se a matrícula foi realizada corretamente
    println("Inscritos na formação ${formacaoKotlinBasico.nome}: ${formacaoKotlinBasico.inscritos}")
}

