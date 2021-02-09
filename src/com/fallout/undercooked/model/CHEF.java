package com.fallout.undercooked.model;

import com.fallout.undercooked.states.SpriteAnimation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import java.awt.*;

public enum CHEF {
    PURPLE("/com/fallout/undercooked/model/Spritesheets/largePurpleChef.png","/com/fallout/undercooked/model/Spritesheets/purpleChef.png","purple"),
    RED("/com/fallout/undercooked/model/Spritesheets/largeRedChef.png","/com/fallout/undercooked/model/Spritesheets/redChef.png","red"),
    GREEN("/com/fallout/undercooked/model/Spritesheets/largeGreenChef.png","/com/fallout/undercooked/model/Spritesheets/greenChef.png","green"),
    BLUE("/com/fallout/undercooked/model/Spritesheets/largeBlueChef.png","/com/fallout/undercooked/model/Spritesheets/blueChef.png","blue"),;

    String urlChef;
    String urlLife;
    String colour;

    CHEF(String urlChef, String urlLife, String colour) {
        this.urlChef = urlChef;
        this.urlLife = urlLife;
        this.colour = colour;
    }
    public String getUrl() {
        System.out.println(this.urlChef);
        return this.urlChef;
    }
    public String getUrlLife() {
        return urlLife;
    }

    public ImageView getImageView() {
        System.out.println(String.format("/com/fallout/undercooked/model/Spritesheets/%sChef.png", colour));


        ImageView imv = new ImageView(String.format("/com/fallout/undercooked/model/Spritesheets/%sChef.png", colour));
        return imv;
    }

}
