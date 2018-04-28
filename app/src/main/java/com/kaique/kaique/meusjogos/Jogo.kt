package com.kaique.kaique.meusjogos

//Data class ja esta setando o get e o set
//Logo dentro desta classe eu so irei usar o get
//Por que estou utilizando constantes?
//Pois o valor da minha imagem não muda, logo eu so preciso usar o GET
data class Jogo(val resourceID: Int,
                val nome: String,
                val anoLancamento: Int,
                val descricao:String){

}