package com.fallout.undercooked.model;

import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class UndercookedSubScene extends SubScene{

    private final static String FONT_PATH = "com/fallout/undercooked/model/recources/black.png";
    private final static String BACKGROUND_IMAGE = "com/fallout/undercooked/model/recources/red_panel.png";

    private  boolean isHidden;

    public UndercookedSubScene(Parent parent, double v, double v1) {
        super(parent, v, v1);
        prefWidth(v);
        prefHeight(v1);
        parent.setLayoutX(100);
        //parent.setLayoutY(300);

        BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE, 600, 400, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);

        AnchorPane root2 = (AnchorPane) this.getRoot();
        root2.setBackground(new Background(image));

        isHidden = true ;

        setLayoutX(900);
        setLayoutY(180);
    }



    public void moveSubScene() {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.3));
        transition.setNode(this);

        if (isHidden) {

            transition.setToX(-676);
            isHidden = false;

        } else {

            transition.setToX(0);
            isHidden = true ;
        }


        transition.play();
    }

    public AnchorPane getPane() {
        return (AnchorPane) this.getRoot();
    }

}
