var alunoList = ArrayList<Aluno>()

fun main(){ 
	do {
		val menu = menu()
		when(menu) {
			"1" -> {
				addAluno()
			}
			"2" -> {
				listAluno()
			}
			"3" -> {
				removeAluno()
			}
		}
	} while(menu != "q")

}
private fun clearscreen(){
        print("\u001b[H\u001b[2J")
}
private fun menu(): String? {
	clearscreen()
	println("1 --> Adiciona Aluno.")
	println("2 --> Lista alunos e médias.")
	println("3 --> Deleta aluno")
	println("q --> Sair")
	val menu = readLine()
	return menu
}
private fun addAluno(){
	val aluno = readAluno()
	if(aluno != null){
		alunoList.add(aluno)
	}
}
private fun listAluno(){
	var mediaTotal: Double = 0.0
	if(alunoList.size == 0){
		println("Não existem alunos.")
	}
	else {
		println("Lista de alunos e médias.")
		for(x in 0..alunoList.size-1){
			showMedia(alunoList.get(x))
			mediaTotal += getMedia(alunoList.get(x))
		}
		mediaTotal = mediaTotal/alunoList.size
	        println("\n\nMédia da sala: $mediaTotal")
	}
	readLine()
}
private fun getIndex(nome: String): Int? {
	return alunoList.indexOfFirst { it.nome == nome }	
}
private fun existeNome(nome: String): Boolean {
	val exist = alunoList.find { it.nome == nome }
	if(exist == null){
		return false
	}
	else{
		return true
	}
}
private fun removeAluno(){
	println("Digite o nome do aluno a ser removido:")
	var nomeAluno = readNome()
	if(!existeNome(nomeAluno)){
		println("Não tem nenhum aluno com esse nome.")
		readLine()
	}
	else {
		val ind = getIndex(nomeAluno)
		alunoList.removeAt(ind!!)
	}
}
private fun readNome(): String{
	var nome: String?
	do{
		nome = readLine()
		if(nome == "") println("Nome não pode ser nulo. Digite novamente")
	} while(nome == "")
	return nome!!
}
private fun readAluno(): Aluno? {
        println("Digite o nome do aluno:")
        val nome = readNome()
	if(existeNome(nome)){
		println("Aluno ja existe")
		readLine()
		return null
	}
        println("Digite a nota 1:") 
        val n1 = readNota()
        println("Digite a nota 2:") 
        val n2 = readNota()
        println("Digite a nota 4:")
        val n3 = readNota()
        println("Digite a nota 4:")
        val n4 = readNota()
        return Aluno(nome,n1,n2,n3,n4)
}
private fun showMedia(aluno: Aluno) {
        val media = getMedia(aluno)
        println("\nNome: "+aluno.nome)
        println("Média: $media")
}
private fun getMedia(aluno: Aluno): Double {
	return (aluno.n1+aluno.n2+aluno.n3+aluno.n4)/4
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
data class Aluno(
        var nome: String?,
        var n1: Double = 0.0,
        var n2: Double = 0.0,
        var n3: Double = 0.0,
        var n4: Double = 0.0
)
