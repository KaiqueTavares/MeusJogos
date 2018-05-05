package com.kaique.kaique.meusjogos

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detalhe_jogo.*
import kotlinx.android.synthetic.main.content_detalhe_jogo.*

class DetalheJogoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_jogo)
        setSupportActionBar(toolbar)

        //Recuperando meu objeto que passei da outra tela
        //Por meio de uma variavel que deve ser chamada como getParcelableExtra<Devo passar meu arquivo Kotlin>
        //Name é o nome do meu putExtra
        val jogo = intent.getParcelableExtra<Jogo>("jogo")
        //Trocando o nome do titulo pegando o objeto
        toolbar_layout.title = jogo.nome
        tvDescricao.text= jogo.descricao
        ivBanner.setImageDrawable(ContextCompat.getDrawable(this,jogo.bannerId))

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }
}
