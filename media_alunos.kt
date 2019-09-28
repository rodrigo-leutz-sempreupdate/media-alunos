fun main(){ 

	var nome: String?
	var n1: Double
	var n2: Double
	var n3: Double
	var n4: Double
	var media: Double

	println("Digite o nome do aluno:")
	nome = readLine()
	println("Digite a nota 1:") 
	n1 = readNota()
	println("Digite a nota 2:") 
	n2 = readNota()
	println("Digite a nota 4:") 
	n3 = readNota()
	println("Digite a nota 4:") 
	n4 = readNota()

	media = (n1+n2+n3+n4)/4
	println("\nNome: $nome")
	println("Média: $media") 
}
private fun readNota(): Double {
	var nota = readLine()
	try{
		nota = nota!!.replace(",",".")
		val y = nota.toDouble()
		if(y > 10.0) {
				println("Nota maior que 10, valor = 10.")
				return 10.0
		}
		else if(y < 0.0) {
				println("Nota menor que 0, valor = 0.")
				return 0.0
		}
		else {
				return y
		}
	} catch(e: NumberFormatException){
		println("Não foi digitado um número válido, valor = 0.")
		return 0.0
	}
}
