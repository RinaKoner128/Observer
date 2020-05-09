package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import sample.Metods.*;

public class Controller {
    public AnchorPane ap2;
    @FXML
    public TextField dindon, timer, image, coll, repeat;
    public Canvas can;

    Subject subject = new Subject();
    ComponentText ct;
    Signal sl;
    ConImage ck;
    GraphicsContext gr;


    @FXML
    public void initialize(){
        gr = can.getGraphicsContext2D();
package sample.Metods;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
/**
 * Класс, запускающий звук.
 * @author Bosaya Irina pPi-171
 * @version 1.2
 */

public class Signal extends Observer {
    int count;
    int start;
    String file;
    Media sound;
    MediaPlayer mediaPlayer;
    Boolean state;


    public Signal(Subject subject){
        this.count = 0;
        this.state = false;
        this.start = subject.getState();
        this.file = "ben.mp3";
        this.sound = new Media(new File(file).toURI().toString());
        this.mediaPlayer = new MediaPlayer(sound);
        this.subject = subject;
        this.subject.attach(this);
    }
    /**
     * Этот метод запускает звук.
     * @param count Значение, которое требуется
     * для обозначения старта воспроизведения.
     */
    public void onComp(int count){
        this.count = count;
        this.start = subject.getState();
        this.state = true;
    }

    /**
     * Этот метод останавливает звук и удаляет его из скиска наблюдателя.
     */
    public void delComo(Subject st){
        mediaPlayer.stop();
        st.detach(this);
    }
    /**
     * Этот метод необходим для воспроизведения звука.
     * @param st Значение, которое требуется
     * для получения доступа к Subject.
     * @return Работающая анимацияПользователь слышит звук.
     */
    @Override
    public void update(Subject st) {
        if (state) {
            if (st.getState() == start + count) {
                mediaPlayer.play();
                start += count;
            }
        }
    }
}


