package com.kaique.kaique.meusjogos

import android.os.Parcel
import android.os.Parcelable

//Data class ja esta setando o get e o set
//Logo dentro desta classe eu so irei usar o get
//Por que estou utilizando constantes?
//Pois o valor da minha imagem não muda, logo eu so preciso usar o GET
data class Jogo(val resourceID: Int,
                val nome: String,
                val anoLancamento: Int,
                //: Parcelable é uma interface (Um contrato,para eu dizer que quero um parcelable eu preciso
                // implementar uma biblioteca ou seja um modelo)
                //Eu vou colocar o botão direito depois do nome da class e implementar com alt+enter.
                val descricao:String,
                val bannerId: Int): Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(resourceID)
        parcel.writeString(nome)
        parcel.writeInt(anoLancamento)
        parcel.writeString(descricao)
        parcel.writeInt(bannerId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Jogo> {
        override fun createFromParcel(parcel: Parcel): Jogo {
            return Jogo(parcel)
        }

        override fun newArray(size: Int): Array<Jogo?> {
            return arrayOfNulls(size)
        }
    }

}