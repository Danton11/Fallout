package com.fallout.undercooked.model;

public enum CHEF {
    PURPLE("/com/fallout/undercooked/model/Spritesheets/purpleChef.png","/com/fallout/undercooked/model/Spritesheets/purpleChef.png"),
    RED("/com/fallout/undercooked/model/Spritesheets/redChef.png","/com/fallout/undercooked/model/Spritesheets/redChef.png"),
    GREEN("/com/fallout/undercooked/model/Spritesheets/greenChef.png","/com/fallout/undercooked/model/Spritesheets/greenChef.png"),
    BLUE("/com/fallout/undercooked/model/Spritesheets/largeBlueChef.png","/com/fallout/undercooked/model/Spritesheets/blueChef.png"),;

    String urlChef;
    String urlLife;

    CHEF(String urlChef, String urlLife) {
        this.urlChef = urlChef;
        this.urlLife = urlLife;
    }
    public String getUrl() {
        System.out.println(this.urlChef);
        return this.urlChef;
    }
    public String getUrlLife() {
        return urlLife;
    }
}
