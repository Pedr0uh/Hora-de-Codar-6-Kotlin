import kotlin.system.exitProcess

data class pessoa(

    var nome: String,
    var endereco: String,
    var numero: Int,
    var telefone: String

)

var pessoas = mutableListOf<pessoa>()


fun main() {

    pessoas.add(pessoa("João", "Rua 1", 1, "1234-5678"))
    pessoas.add(pessoa("Maria", "Rua 2", 2, "8765-4321"))
    pessoas.add(pessoa("José", "Rua 3", 3, "4321-5678"))
    pessoas.add(pessoa("Ana", "Rua 4", 4, "5678-4321"))

    opcoes()

}
fun opcoes(){
    println("\n--- Agenda ---\n")

    println("Seleciona uma opção: " +
            "\n1 - Adicionar contato" +
            "\n2 - Pesquisar contato" +
            "\n3 - Ver todos os contatos" +
            "\n4 - Sair")

    val opcao = readln().toInt()

    when(opcao){
        1 -> adicionarContato(pessoas)
        2 -> pesquisarContato(pessoas)
        3 -> verContatos(pessoas)
        4 -> sair()

        else -> println("Opção inválida!")
    }

}

fun pesquisarContato(pessoas: MutableList<pessoa>){

    println("Digite o nome do contato: ")
    val nomes = readln()
    var contatoEncontrado = false

    for(pessoa in pessoas) {

        if (pessoa.nome.equals(nomes, ignoreCase = true)) {
            println("\nContato encontrado!")
            println("Nome: ${pessoa.nome}")
            println("Endereço: ${pessoa.endereco}")
            println("Número: ${pessoa.numero}")
            println("Telefone: ${pessoa.telefone}\n")
            contatoEncontrado = true
        }

        if (!contatoEncontrado) {
            println("Contato não encontrado!\n")
        }

    }

    opcoes()

}

fun adicionarContato(pessoas: MutableList<pessoa>){

    println("Digite o nome: ")
    var nome = readln()
    while (nome.isEmpty()) {
        println("Nome não pode ser vazio!")
        nome = readln()
    }

    println("Digite o endereço: ")
    var endereco = readln()
    while(endereco.isEmpty()){
        println("Endereço não pode ser vazio!")
        endereco = readln()
    }

    println("Digite o número: ")
    var numeroInput = readln()
    while(numeroInput.isEmpty()|| numeroInput.toIntOrNull() == null){
        println("Número não pode ser vazio, deve ser um número valido!")
        numeroInput = readln()
    }
    val numero = numeroInput.toInt()


    println("Digite o telefone: ")
    var telefone = readln()
    while(telefone.isEmpty()){
        println("Telefone não pode ser vazio!")
        telefone = readln()
    }

    val pessoa = pessoa(nome, endereco, numero, telefone)

    pessoas.add(pessoa)

    println("Contato adicionado com sucesso!")

    opcoes()

}

fun verContatos(pessoas: MutableList<pessoa>){

    for((i, pessoa) in pessoas.withIndex()){
        println("\nContato ${i+1}")
        println("Nome: ${pessoa.nome}")
        println("Endereço: ${pessoa.endereco}")
        println("Número: ${pessoa.numero}")
        println("Telefone: ${pessoa.telefone}")
    }

    opcoes()

}

fun sair(){

    println("Confirmar saida? (s/n)")
    val confirmacao = readln()

    val confirmar = confirmacao.equals("s", ignoreCase = true)
    val naoConfirmar = confirmacao.equals("n", ignoreCase = true)


    if(confirmar) {
        println("Saindo...")
        exitProcess(0)
    }
    else if(naoConfirmar){
        main()
    }
    else{
        println("Insira uma opção válida!")
    }


}