package com.fallout.undercooked.model;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.text.Font;

public class HelpLabel extends Label{

    public final static String FONT_PATH = "/resources/kenvector_future.ttf";

    public final static String BACKGROUND_IMAGE = "com/fallout/undercooked/model/recources/red_info_label.png";


    public HelpLabel(String text) {

        setPrefWidth(380);
        setPrefHeight(49);
        setText(text);
        setWrapText(true);
        setAlignment(Pos.CENTER);

        BackgroundImage backgroundImage = new BackgroundImage(new Image(BACKGROUND_IMAGE, 380, 49, false, true), BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
        setBackground(new Background(backgroundImage));
    }



}

