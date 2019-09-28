import java.util.Scanner

fun main(){ 

	var nome: String?
	var n1: Double
	var n2: Double
	var n3: Double
	var n4: Double
	var media: Double

	var reader = Scanner(System.`in`) 

	println("Digite o nome do aluno:")
	nome = readLine()
	println("Digite a nota 1:") 
	n1 = reader.nextDouble() 
	println("Digite a nota 2:") 
	n2 = reader.nextDouble() 
	println("Digite a nota 4:") 
	n3 = reader.nextDouble() 
	println("Digite a nota 4:") 
	n4 = reader.nextDouble() 

	media = (n1+n2+n3+n4)/4
	println("\nNome: "+nome)
	println("Média: $media") 
}
