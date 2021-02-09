package com.fallout.undercooked.states;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SpriteAnimation extends  Transition{
    private final ImageView imageView;
    private final int count;
    private final int column;
    private int offsetX;
    private int offsetY;
    private final int width;
    private final int height;

    public SpriteAnimation(ImageView imageView,Duration duration, int count, int column, int offsetX, int offsetY, int width, int height) {
        this.imageView = imageView;
        this.count = count;
        this.column = column;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.width = width;
        this.height = height;
        setCycleDuration(duration); //set frame time per image
        setCycleCount(Animation.INDEFINITE);
        setInterpolator(Interpolator.LINEAR);
        this.imageView.setViewport(new Rectangle2D(offsetX,offsetY,width,height));

    }
    public void setOffsetX(int x){
        this.offsetX = x;
    }
    public void setOffsetY(int y){
        this.offsetX = y;
    }
    @Override
    protected void interpolate(double v) {
        final int index = Math.min((int)Math.floor(count*v),count-1);
        final int x = (index%column)*width+offsetX;
        final int y = (index/column)*height+offsetY;
        imageView.setViewport(new Rectangle2D(x,y,width,height));

    }
}
