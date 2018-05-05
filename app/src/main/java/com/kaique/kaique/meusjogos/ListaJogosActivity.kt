package com.kaique.kaique.meusjogos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_lista_jogos.*

class ListaJogosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_jogos)
        rvMeusJogos.adapter = JogosAdapter(criajogos(), this, {
            //Toast é o modal que aparece o texto.
            //Toast.makeText(this, it.nome, Toast.LENGTH_LONG).show()
            //Starto minha activity
            val intent = Intent(this,DetalheJogoActivity::class.java)
            //IT é meu Objeto, é a coisa que recebo
            //Este objeto já foi gerado anteriormente
            //Para este IT Funcionar eu tive que converter o objeto para Parcelable
            //Essa conversão deve ser feita no data class de meu objeto
            intent.putExtra("jogo",it)
            //Starto minha activity passando o objeto e iniciando a nova Activity
            startActivity(intent)
        })

        //Tipo de lista por exemplo essa linha debaixo cria uma lista na vertical
        rvMeusJogos.layoutManager = LinearLayoutManager(this)
    }

    private fun criajogos(): List<Jogo> {
        //Metodo que retorna as listas
        return listOf(
                Jogo(R.drawable.godofwarps4,
                        "God of War",
                        2018,
                        //Preciso dar um getString pois o R.string traz um int.
                        getString(R.string.godofwarDescricao),
                        R.drawable.godofwar),
                Jogo(R.drawable.seaofthieve,
                        "Sea Of Thieves",
                        2018,
                        getString(R.string.seaofthievesDescricao),
                        R.drawable.seaofthievesbanner))
    }
}
