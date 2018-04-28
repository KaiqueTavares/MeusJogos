package com.kaique.kaique.meusjogos

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.meu_jogo_item.view.*

//Esta classe recebe uma lista de jogos
//Um contexto - que será aonde ele será colocado
//Meu listener executa uma ação (Botao) que executa uma função sem retorno.
class JogosAdapter(private val jogos: List<Jogo>,
                   private val context: Context,
                   //RecyclerView.Adapter<JogosAdapter.ViewHolder>() estou herdando o RecyclerView, e estou pegando minha ViewHolder
                   //class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
                   val listener: (Jogo) -> Unit) : RecyclerView.Adapter<JogosAdapter.ViewHolder>() {

    //Ele executa sempre o que ele vai preencher, logo
    //Ele pega minha position: Int do XML
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        //Verifica qual a posição minha linha se encontra
        val jogo = jogos[position]
        //.Let verifica se ele esta recebendo nulo em holder: ViewHolder?
        holder?.let {
            // listener: (Jogo)-> Unit) = with(itemView)
            it.bindView(jogo,listener)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        //Estou falando aqui que minha view vai ser meu item/linha
        val view = LayoutInflater.from(context).inflate(
                R.layout.meu_jogo_item, parent , false
        )
        //Retorno para o view hold minha linha de XML
        //with(itemView)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        //private val jogos: List<Jogo>, ESTOU RETORNANDO O TAMANHO DA MINHA LISTA
        return jogos.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(jogo: Jogo,
                     listener: (Jogo)-> Unit) = with(itemView) {
            ivJogo.setImageDrawable(ContextCompat.getDrawable(context, jogo.resourceID))
            tvNome.text = jogo.nome
            tvAnoLancamento.text = jogo.anoLancamento.toString()
            tvDescricao.text = jogo.descricao

            setOnClickListener { listener(jogo) }
        }
    }
}

