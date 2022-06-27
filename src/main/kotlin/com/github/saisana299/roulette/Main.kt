package com.github.saisana299.roulette

import javafx.application.Application

class Main{
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Application.launch(Roulette::class.java, *args)
        }
    }
}
