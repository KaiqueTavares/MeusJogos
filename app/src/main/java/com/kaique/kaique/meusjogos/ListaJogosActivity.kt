package com.kaique.kaique.meusjogos

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
            Toast.makeText(this, it.nome, Toast.LENGTH_LONG).show()
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
                        "God of War é um jogo eletrônico de ação-aventura desenvolvido pela SIE " +
                                "Santa Monica Studio e publicado pela Sony Interactive Entertainment. Foi lançado em 20 " +
                                "de abril de 2018 para o PlayStation 4. É o oitavo jogo da série God of War e a sequência " +
                                "dos eventos ocorridos em God of War III. O título é um recomeço para a franquia e leva a " +
                                "série para o mundo da mitologia nórdica — todos os jogos anteriores tinham como " +
                                "cenário a mitologia grega. Kratos retorna como o protagonista e agora tem ao seu lado " +
                                "um filho chamado Atreus. Kratos atua como um mentor e protetor de Atreus e tem de " +
                                "dominar a raiva que o impulsionou por muitos anos."))
    }
}
