data class Pessoa(
    val nome: String,
    val altura: Double
)

var pessoas = mutableListOf<Pessoa>()


fun main(){

    pessoas.add(Pessoa("João", 1.70))
    pessoas.add(Pessoa("Maria", 1.60))
    pessoas.add(Pessoa("José", 1.80))
    pessoas.add(Pessoa("Ana", 1.40))
    pessoas.add(Pessoa("Carlos", 2.00))

    println("----------------------------------")
    println("            Bem vindo!            ")
    println("----------------------------------")

    opcoes()

}

fun opcoes(){

    println("O que deseja fazer: " +
            "\n1 - Cadastrar pessoa" +
            "\n2 - Listar pessoas" +
            "\n3 - Listar menores que 1,50m" +
            "\n4 - Listar maiores que 1,50m" +
            "\n5 - Listar maiores que 1,50m e menores que 2m" +
            "\n6 - Media todas as alturas" +
            "\n7 - Sair")
    val opcao = readln().toInt()

    when(opcao){
        1 -> cadastrarPessoa(pessoas)
        2 -> listaPessoas(pessoas)
        3 -> listaMenores(pessoas)
        4 -> listaMaiores(pessoas)
        5 -> listaMaioresMenores(pessoas)
        6 -> mediaAlturas(pessoas)
        7 -> sair()
        else -> println("Opção inválida!")
    }

}

fun cadastrarPessoa(pessoas: MutableList<Pessoa>){

    println("Digite o nome da pessoa: ")
    val nome = readln()

    println("Digite a altura da pessoa: ")
    val altura = readln().toDouble()

    pessoas.add(Pessoa(nome, altura))

    println("Pessoa cadastrada com sucesso!\n")

    opcoes()
}

fun listaPessoas(pessoas: MutableList<Pessoa>){

    if(pessoas.isNotEmpty()){
        for((i, Pessoa) in pessoas.withIndex()){
            println("----------------------------------")
            println("${1 + i}° Pessoa")
            println("Nome: ${Pessoa.nome} - Altura: ${Pessoa.altura}")
                if(Pessoa.altura < 1.50) {
                    println("Condição: Menor que 1,50m")
                }
                else if(Pessoa.altura > 1.50 && Pessoa.altura < 2.00){
                    println("Condição: Entre 1,50m e 2,00m")
                }
                else{
                    println("Condição: Maior que 2,00m")
                }
            println("----------------------------------")
        }
    }else{
        println("Nenhuma pessoa cadastrada!")
    }
    opcoes()
}

fun listaMenores(pessoas: MutableList<Pessoa>){

    if(pessoas.isNotEmpty()) {
        for ((i, Pessoa) in pessoas.withIndex()) {
            if (Pessoa.altura < 1.50) {
                println("----------------------------------")
                println("${1 + i}° Pessoa")
                println("Nome: ${Pessoa.nome} - Altura: ${Pessoa.altura}")
                println("----------------------------------")
            }
        }
    }
    else{
        println("Nenhuma pessoa cadastrada!")
    }
    opcoes()
}

fun listaMaiores(pessoas: MutableList<Pessoa>){

    if(pessoas.isNotEmpty()) {
        for ((i, Pessoa) in pessoas.withIndex()) {
            if (Pessoa.altura > 1.50) {
                println("----------------------------------")
                println("${1 + i}° Pessoa")
                println("Nome: ${Pessoa.nome} - Altura: ${Pessoa.altura}")
                println("----------------------------------")
            }
        }
    }
    else{
        println("Nenhuma pessoa cadastrada!")
    }
    opcoes()
}

fun listaMaioresMenores(pessoas: MutableList<Pessoa>){

    if(pessoas.isNotEmpty()) {
        for ((i, Pessoa) in pessoas.withIndex()) {
            if (Pessoa.altura > 1.50 && Pessoa.altura < 2.00) {
                println("----------------------------------")
                println("${1 + i}° Pessoa")
                println("Nome: ${Pessoa.nome} - Altura: ${Pessoa.altura}")
                println("----------------------------------")
            }
        }
    }
    else{
        println("Nenhuma pessoa cadastrada!")
    }
    opcoes()
}

fun mediaAlturas(pessoas: MutableList<Pessoa>) {

    if (pessoas.isNotEmpty()) {
        pessoas.map { it.altura }.average().also {
            println("A média de todas as alturas é: $it")
        }
    } else {
        println("Nenhuma pessoa cadastrada!")
    }

}

fun sair() {
    println("Certeza que deseja sair? (S/N)")
    val sair = readln()

    sair.equals(sair, ignoreCase = true)

    if (sair == "s") {
        println("Obrigado por utilizar o programa!")
        println("Até a próxima!")
        opcoes()
    } else if (sair == "n") {
        opcoes()
    } else {
        println("Opção inválida!")
    }

    println("Obrigado por utilizar o programa!")
    println("Até a próxima!")

}