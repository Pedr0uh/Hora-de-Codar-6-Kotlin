import kotlin.system.exitProcess

import kotlin.random.Random

data class Funcionario(
    var matricula: Int,
    var nome: String,
    var salario: Int
    )

var funcionarios = mutableListOf<Funcionario>()

fun main(){

    funcionarios = gerarFuncionario(20)

    println("-----------------------------------------------")
    println("    Bem vindo(a) ao sistema de funcionários    ")
    println("-----------------------------------------------")

    opcoes()

}

fun gerarFuncionario(quantidade: Int): MutableList<Funcionario> {

    val nomes = mutableListOf("Joana", "Rafael", "Mariana", "Pedro", "Lucas", "Ana", "Carlos", "Paula", "José", "Fernanda", "Bruno", "Maria", "Felipe", "Laura", "André", "Camila", "Gustavo", "Bianca", "Eduardo", "Silvia")
    val funcionarios = mutableListOf<Funcionario>()

    for(i in 1..quantidade){
        val matriculaAleatorio = Random.nextInt(1, 9999)
        val nomeAleatorio = nomes[Random.nextInt(0, nomes.size)]
        val salarioAleatorio = Random.nextInt(800, 5000)

        funcionarios.add(Funcionario(matriculaAleatorio, nomeAleatorio, salarioAleatorio))
    }
    return funcionarios
}

fun opcoes(){

    println("O que deseja fazer hoje?\n" +
            "\n1 - Cadastrar funcionário" +
            "\n2 - Lista de todos funcionários" +
            "\n3 - Buscar funcionário" +
            "\n4 - Funcionário que recebem acima de R$1000" +
            "\n5 - Funcionários que recebem R$1000" +
            "\n6 - Funcionários menos que R$1000" +
            "\n7 - Sair")
    val opcao = readln().toInt()

    when(opcao){
        1 -> cadastrarFuncionario(funcionarios)
        2 -> listaFuncionarios(funcionarios)
        3 -> buscarFuncionario(funcionarios)
        4 -> funcionariosAcimaDeMil(funcionarios)
        5 -> funcionariosMil(funcionarios)
        6 -> funcionariosMenosMil(funcionarios)
        7 -> sair()
        else -> println("Opção inválida")
    }

}

fun cadastrarFuncionario(funcionarios: MutableList<Funcionario>){
    println("Digite a matrícula do novo funcionário:")
    val matricula = readln().toInt()
    println("Digite o nome do funcionário:")
    val nome = readln()
    println("Digite o salário do funcionário em R$:")
    val salario = readln().toInt()

    funcionarios.add(Funcionario(matricula, nome, salario))
    println("\nFuncionário cadastrado com sucesso!\n")
    opcoes()
}

fun listaFuncionarios(funcionarios: MutableList<Funcionario>) {

        if(funcionarios.isEmpty()){
            println("Não há funcionários cadastrados!")
        }
        else {
            println(" --- Lista de Funcionários --- \n")
            for ((i, funcionario) in funcionarios.withIndex()) {
                println("-------------------------------------\n")
                println("Funcionário ${i + 1}\n")
                println("Matrícula: ${funcionario.matricula}")
                println("Nome: ${funcionario.nome}")
                println("Salário: R$${funcionario.salario}\n")
                println("-------------------------------------")
            }
        }

        opcoes()
}

fun buscarFuncionario(funcionarios: MutableList<Funcionario>){

    if(funcionarios.isNotEmpty()) {
        println("Digite a matrícula do funcionário que deseja buscar:")
        val matricula = readln().toInt()

        val funcionarioEncontrado = funcionarios.find { it.matricula == matricula }


        if (funcionarioEncontrado != null) {
            println("Funcionário encontrado!\n")
            println(" __________________________")
            println("| Matrícula: ${funcionarioEncontrado.matricula}")
            println("| Nome: ${funcionarioEncontrado.nome}")
            println("| Salário: R$${funcionarioEncontrado.salario}")
            println("|__________________________\n")

        }
        else{
            println("Funcionário não encontrado!\n")
        }

    }
    else{
        println("Não há funcionários cadastrados!\n")
    }
    opcoes()
}

fun funcionariosAcimaDeMil(funcionarios: MutableList<Funcionario>){

    if(funcionarios.isNotEmpty()){
        println("\n --- Funcionários que recebem acima de R$1000 --- \n")
        for(funcionario in funcionarios){
            if(funcionario.salario > 1000){
                println("-------------------------------------")
                println("Matrícula: ${funcionario.matricula}")
                println("Nome: ${funcionario.nome}")
                println("Salário: R$${funcionario.salario}\n")
                println("-------------------------------------")
            }
        }
    }
    else{
        println("Não há funcionários cadastrados!")
    }
    opcoes()
}

fun funcionariosMil(funcionarios: MutableList<Funcionario>){

    if(funcionarios.isNotEmpty()){
        println("\n --- Funcionários que recebem R$1000 --- \n")
        for(funcionario in funcionarios){
            if(funcionario.salario == 1000){
                println("-------------------------------------")
                println("Matrícula: ${funcionario.matricula}")
                println("Nome: ${funcionario.nome}")
                println("Salário: R$${funcionario.salario}\n")
                println("-------------------------------------")
            }
        }
    }
    else{
        println("Não há funcionários cadastrados!")
    }
    opcoes()
}

fun funcionariosMenosMil(funcionarios: MutableList<Funcionario>){

    if(funcionarios.isNotEmpty()){
        println("\n --- Funcionários que recebem menos que R$1000 --- \n")
        for(funcionario in funcionarios){
            if(funcionario.salario < 1000){
                println("-------------------------------------")
                println("Matrícula: ${funcionario.matricula}")
                println("Nome: ${funcionario.nome}")
                println("Salário: R$${funcionario.salario}\n")
                println("-------------------------------------")
            }
        }
    }
    else{
        println("Não há funcionários cadastrados!")
    }
    opcoes()
}

fun sair(){
    println("Deseja realmente sair do sistema? (S/N)")
    val opcao = readln()

    val opS = (opcao.equals("S", ignoreCase = true))
    val opN = (opcao.equals("N", ignoreCase = true))

    if(opS){
        println("Até mais!")
        exitProcess(0)
    }
    else if(opN){
        opcoes()
    }
    else{
        println("Opção inválida")
    }
}