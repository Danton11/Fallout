package com.fallout.undercooked.model;

public enum CHEF {

    BLUE("/com/fallout/undercooked/model/Spritesheets/blueChef.png","/com/fallout/undercooked/model/Spritesheets/blueChef.png"),
    GREEN("/com/fallout/undercooked/model/Spritesheets/redChef.png","/com/fallout/undercooked/model/Spritesheets/redChef.png"),
    ORANGE("/com/fallout/undercooked/model/Spritesheets/greenChef.png","/com/fallout/undercooked/model/Spritesheets/greenChef.png"),
    RED("/com/fallout/undercooked/model/Spritesheets/purpleChef.png","/com/fallout/undercooked/model/Spritesheets/purpleChef.png");

    String urlChef;
    //String urlLife;

    CHEF(String urlChef, String urlLife) {
        this.urlChef = urlChef;
        //this.urlLife = urlLife;
    }
    public String getUrl() {
        return this.urlChef;
    }
/*    public String getUrlLife() {
        return urlLife;
    }*/
}
