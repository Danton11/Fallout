package com.fallout.undercooked.model;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class ChefPicker extends VBox {

    private ImageView circleImage;
    private ImageView chefImage;

    private String circleNotChoosen = "com/fallout/undercooked/model/resources/grey_circle.png";
    private String circleChoosen = "com/fallout/undercooked/model/resources/red_choosen.png";

    private CHEF chef;

    private boolean isCircleChoosen;

    public ChefPicker(CHEF chef) {
        circleImage = new ImageView(circleNotChoosen);
        chefImage = new ImageView(chef.getUrl());
        this.chef= chef;
        isCircleChoosen = false;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.getChildren().add(circleImage);
        this.getChildren().add(chefImage);

    }

    public CHEF getChef() {
        return chef;
    }

    public boolean getCircleChoosen() {
        return isCircleChoosen;
    }

    public void setIsCircleChoosen(boolean isCircleChoosen) {
        this.isCircleChoosen = isCircleChoosen;
        String imageToSet = this.isCircleChoosen ? circleChoosen : circleNotChoosen;
        circleImage.setImage(new Image(imageToSet));
    }
}