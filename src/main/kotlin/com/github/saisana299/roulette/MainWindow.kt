package com.github.saisana299.roulette

import com.jfoenix.controls.JFXButton
import javafx.application.Platform
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Label
import javafx.scene.input.KeyCode
import javafx.stage.Stage
import javafx.stage.WindowEvent
import java.net.URL
import java.util.*
import kotlin.system.exitProcess

class MainWindow: Initializable {
    private lateinit var stage: Stage
    private var t1done: Boolean = false
    private var t2done: Boolean = false
    private var t3done: Boolean = false

    @FXML private lateinit var lbl1: Label
    @FXML private lateinit var lbl2: Label
    @FXML private lateinit var lbl3: Label

    @FXML private lateinit var lbltop: Label

    @FXML private lateinit var btn1: JFXButton
    @FXML private lateinit var btn2: JFXButton
    @FXML private lateinit var btn3: JFXButton

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        btn1.isFocusTraversable = false;
        btn2.isFocusTraversable = false;
        btn3.isFocusTraversable = false;
        lbl1.heightProperty().addListener { _, _, _ ->
            lbl1.style = "-fx-font-size: ${((stage.height / 480) * 250).toInt()}"
            lbl2.style = "-fx-font-size: ${((stage.height / 480) * 250).toInt()}"
            lbl3.style = "-fx-font-size: ${((stage.height / 480) * 250).toInt()}"
            lbltop.style = "-fx-font-size: ${((stage.height / 480) * 12).toInt()}"
        }
        lbl1.widthProperty().addListener { _, _, _ ->
            lbl1.style = "-fx-font-size: ${((stage.height / 480) * 250).toInt()}"
            lbl2.style = "-fx-font-size: ${((stage.height / 480) * 250).toInt()}"
            lbl3.style = "-fx-font-size: ${((stage.height / 480) * 250).toInt()}"
            lbltop.style = "-fx-font-size: ${((stage.height / 480) * 12).toInt()}"
        }

        run()
    }

    fun setStage(stage: Stage): Boolean{
        if(this::stage.isInitialized) return false
        this.stage = stage
        stage.addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST){ event->
            event.consume()
            exitProcess(0)
        }
        return true
    }

    fun setEvent(stage: Stage): Boolean{
        stage.scene.setOnKeyPressed {e ->
            val code = e.code
            if(code === KeyCode.SPACE){
                stop()
            }else if(code === KeyCode.ESCAPE){
                t1done = false
                t2done = false
                t3done = false
                run()
            }
        }
        return true
    }

    private fun run(){
        Thread {
            while (true) {
                if(t1done) break
                Thread.sleep(90)
                if(t1done) break
                val randomValue = random()
                Platform.runLater {
                    lbl1.text = randomValue.toString()
                }
            }
        }.start()
        Thread {
            while (true) {
                if(t2done) break
                Thread.sleep(90)
                if(t2done) break
                val randomValue = random()
                Platform.runLater {
                    lbl2.text = randomValue.toString()
                }
            }
        }.start()
        Thread {
            while (true) {
                if(t3done) break
                Thread.sleep(90)
                if(t3done) break
                val randomValue = random()
                Platform.runLater {
                    lbl3.text = randomValue.toString()
                }
            }
        }.start()
    }

    private fun stop(value: Int = 0){
        if(value == 0){
            if(!t1done) t1done = true
            else if(!t2done) t2done = true
            else if(!t3done) t3done = true
        }else if(value == 1){
            t1done = true
        }else if(value == 2){
            t2done = true
        }else if(value == 3){
            t3done = true
        }
    }

    private fun random(): Char {
        val alphabet = "abcdefghijklmnopqrstuvwxyz0123456789"
        val r = Random()
        return alphabet[r.nextInt(alphabet.length)]
    }

    @FXML fun stop1(){ stop(1) }
    @FXML fun stop2(){ stop(2) }
    @FXML fun stop3(){ stop(3) }
}
