import kotlin.system.exitProcess

data class aluno (
    var nome: String,
    var bim1: Double,
    var bim2: Double,
    var bim3: Double,
    var bim4: Double,
    var media: Double,
    var situacao: String
)

var listaAlunos = mutableListOf<aluno>()

fun main(){

    listaAlunos.add (aluno("João", 7.0, 8.0, 6.0, 7.0, 7.0, "Aprovado"))
    listaAlunos.add (aluno("Maria", 5.0, 6.0, 4.0, 5.0, 5.0, "Aprovado"))
    listaAlunos.add (aluno("José", 3.0, 4.0, 2.0, 3.0, 3.0, "Reprovado"))
    listaAlunos.add (aluno("Ana", 9.0, 10.0, 8.0, 9.0, 9.0, "Aprovado"))

    println("----------------------------")
    println("        Bem-vindo(a)!       ")
    println("----------------------------\n")

    opcoes()

}

fun opcoes(){

    println("O que deseja fazer? " +
            "\n1 - Cadastrar aluno" +
            "\n2 - Pesquisar aluno" +
            "\n3 - Ver todos os alunos" +
            "\n4 - Sair")
    val opcao = readln().toInt()

    when(opcao){
        1 -> cadastrarAluno(listaAlunos)
        2 -> pesquisarAluno(listaAlunos)
        3 -> todosAlunos()
        4 -> sair()
        else -> println("Opção inválida!")
    }

}

fun cadastrarAluno(listaAlunos: MutableList<aluno>){

    println("Insira o nome do aluno: ")
    var nome = readln()
    while(nome.isEmpty()){
        println("Nome não pode ser vazio!")
        nome = readln()
    }

    println("Insira a nota do 1º bimestre: ")
    var bim1Input = readln()
    while(bim1Input.toDouble() < 0 || bim1Input.toDouble() > 10){
        println("Nota inválida! Insira uma nota entre 0 e 10.")
        bim1Input = readln()
    }
    val bim1 = bim1Input.toDouble()

    println("Insira a nota do 2º bimestre: ")
    var bim2Input = readln()
    while(bim2Input.toDouble() < 0 || bim2Input.toDouble() > 10){
        println("Nota inválida! Insira uma nota entre 0 e 10.")
        bim2Input = readln()
    }
    val bim2 = bim2Input.toDouble()

    println("Insira a nota do 3º bimestre: ")
    var bim3Input = readln()
    while(bim3Input.toDouble() < 0 || bim3Input.toDouble() > 10){
        println("Nota inválida! Insira uma nota entre 0 e 10.")
        bim3Input = readln()
    }
    val bim3 = bim2Input.toDouble()

    println("Insira a nota do 4º bimestre: ")
    var bim4Input = readln()
    while(bim4Input.toDouble() < 0 || bim4Input.toDouble() > 10){
        println("Nota inválida! Insira uma nota entre 0 e 10.")
        bim4Input = readln()
    }
    val bim4 = bim2Input.toDouble()

    val media = (bim1 + bim2 + bim3 + bim4) / 4
    print("A média do aluno é: $media")

    val situacao: String

        if(media >= 5){
            println("\nO aluno está aprovado!\n")
            situacao = "Aprovado"
        } else {
            println("\nO aluno está reprovado!\n")
            situacao = "Reprovado"
        }

    val pessoa = aluno(nome, bim1, bim2, bim3, bim4, media, situacao)
    listaAlunos.add(pessoa)

    println("Aluno cadastrado com sucesso!\n")

    opcoes()

}

fun pesquisarAluno(listaAlunos: MutableList<aluno>){

    var alunoEncontrado = false

    if(listaAlunos.isEmpty()){
        println("Não há alunos cadastrados!")
        opcoes()
    }
    else{
        println("Digite o nome do aluno: ")
        val nome = readln()

        for(aluno in listaAlunos){
            if(aluno.nome.equals(nome, ignoreCase = true)){
                println("----------------------------")
                println("\nAluno encontrado!\n")
                println("Nome: ${aluno.nome}")
                println("Nota do 1º bimestre: ${aluno.bim1}")
                println("Nota do 2º bimestre: ${aluno.bim2}")
                println("Nota do 3º bimestre: ${aluno.bim3}")
                println("Nota do 4º bimestre: ${aluno.bim4}\n")
                println("Média: ${aluno.media}")
                println("Situação: ${aluno.situacao}\n")
                println("----------------------------")
                alunoEncontrado = true
            }
        }
    }

    if(!alunoEncontrado){
        println("Aluno não encontrado!")
    }

    opcoes()
}

fun todosAlunos() {

    if(listaAlunos.isNotEmpty()) {
        println("Em Ordem de Alfabetica\n")

        val alunosOrdem = listaAlunos.sortedBy { it.nome }

        for ((i, aluno) in alunosOrdem.withIndex()) {
            println("----------------------------")
            println("Aluno ${i + 1}")
            println("Nome: ${aluno.nome}")
            println("Nota do 1º bimestre: ${aluno.bim1}")
            println("Nota do 2º bimestre: ${aluno.bim2}")
            println("Nota do 3º bimestre: ${aluno.bim3}")
            println("Nota do 4º bimestre: ${aluno.bim4}")
            println("Média: ${aluno.media}")
            println("Situação: ${aluno.situacao}")
            println("----------------------------")
        }
    }
    else {
        println("Não há alunos cadastrados!")
    }
    opcoes()
}

fun sair(){

    println("Deseja realmente sair? (s/n)")
    val confirmacao = readln()

    val confirmar = confirmacao.equals("s", ignoreCase = true)
    val naoConfirma = confirmacao.equals("n", ignoreCase = true)

    if(confirmar){
        println("Até mais!")
        exitProcess(0)
    }
    else if(naoConfirma){
        opcoes()
    }
    else {
        println("Opção inválida! Tente novamente.")
        sair()
    }

}