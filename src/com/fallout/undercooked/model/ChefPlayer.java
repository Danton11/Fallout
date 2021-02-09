package com.fallout.undercooked.model;

import com.fallout.undercooked.states.SpriteAnimation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.awt.*;

public class ChefPlayer extends Pane {
    ImageView imageView;
    int count = 4;
    int columns = 1;
    int offsetx = 0;
    int offsety = 0;
    int width = 35;
    int height = 48;
    CHEF chef;
    Rectangle removeRect = null;
    SpriteAnimation animation;
    public int direction = 0;

    public ChefPlayer(CHEF chef, ImageView imageView) {
        this.chef = chef;
        this.imageView = imageView;
        this.imageView.setViewport(new Rectangle2D(offsetx, offsety, width, height));
        animation = new SpriteAnimation(imageView, Duration.millis(1000), count, columns, offsetx, offsety, width, height);
        getChildren().addAll(imageView);
    }

    public void moveX(float x) {
        boolean right = x > 0 ? true : false;
        for (int i = 0; i < Math.abs(x); i++) {
            if (right) {
                this.setTranslateX(this.getTranslateX() + 0.5);
            } else {
                this.setTranslateX(this.getTranslateX() - 0.5);
            }
        }
    }
    public void moveY(float y) {
        boolean up = y > 0 ? true : false;
        for (int i = 0; i < Math.abs(y); i++) {
            if (up) {
                this.setTranslateY(this.getTranslateY() + 0.5);
            } else {
                this.setTranslateY(this.getTranslateY() - 0.5);
            }
        }
    }

    public void setDirection(int dir){
        System.out.println(dir);

        if(dir < 0){
            this.imageView = new ImageView("/com/fallout/undercooked/model/Spritesheets/redChef.png");
        }else{
            this.imageView = new ImageView("/com/fallout/undercooked/model/Spritesheets/purpleChef.png");
        }
    }
    public int getDirection(){
        return this.direction;
    }
    public ImageView getImageView() {
        ImageView imv = new ImageView(String.format("/com/fallout/undercooked/model/Spritesheets/%sChefSheet.png", chef.colour));
        return imv;
    }
    public ImageView setImageView(String url) {
        ImageView imv = new ImageView(url);
        return imv;
    }
    public String getUrlLife() {
        return chef.urlLife;
    }
}
