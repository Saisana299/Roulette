package com.github.saisana299.roulette

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.input.KeyCombination
import javafx.stage.Stage


class Roulette: Application() {
    override fun start(stage: Stage) {
        try {
            val loader = FXMLLoader(javaClass.classLoader.getResource("com/github/saisana299/roulette/MainWindow.fxml"))
            val root = loader.load<Parent>()
            val controller: MainWindow = loader.getController()
            controller.setStage(stage)
            val scene = Scene(root)
            stage.minWidth = 854.0
            stage.minHeight = 480.0
            stage.title = "Roulette v1.0.2"
            stage.fullScreenExitHint = null
            stage.fullScreenExitKeyCombination = KeyCombination.NO_MATCH
            stage.scene = scene
            controller.setEvent(stage)
            stage.show()
        }catch (e: Exception){
            e.printStackTrace()
        }
    }
}
