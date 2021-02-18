package com.fallout.undercooked.states;

import com.fallout.undercooked.model.CHEF;
import com.fallout.undercooked.model.ChefPlayer;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Random;

public class GameViewManager {

    private static final int GAME_WIDTH = 900;
    private static final int GAME_HEIGHT = 600;
    Random randomPositionGenerator;
    private AnchorPane gamePane;
    private Scene gameScene;
    private Stage gameStage;
    private Stage menuStage;
    private ImageView chef;
    private ChefPlayer chefPlayer;
    private boolean isLeftKeyPressed;
    private boolean isRightKeyPressed;
    private boolean isUpKeyPressed;
    private boolean isDownKeyPressed;
    private AnimationTimer gameTimer;
    private int angle;
    private GridPane gridPane1;
    private GridPane gridPane2;
    private ImageView star;
    private SmallInfoLabel pointsLabel;
    private ImageView[] playerLifes;
    private int playerLife;
    private int points;
    private final static String GOLD_STAR_IMAGE = "com/fallout/undercooked/model/Spritesheets/Fruit.png";
    private final static int CHEF_RADIUS = 50;
    private final static int ITEM_RADIUS = 27;
    private final static int direction = 0;


    public GameViewManager() {
        initializeStage();
        createKeyListeners();
        randomPositionGenerator = new Random();
    }

    private void createKeyListeners() {
        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.LEFT) {
                    isLeftKeyPressed = true;
                } else if (event.getCode() == KeyCode.RIGHT) {
                    isRightKeyPressed = true;
                } else if (event.getCode() == KeyCode.UP) {
                    isUpKeyPressed = true;
                } else if (event.getCode() == KeyCode.DOWN) {
                    isDownKeyPressed = true;
                }
            }
        });

        gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.LEFT) {
                    isLeftKeyPressed = false;

                } else if (event.getCode() == KeyCode.RIGHT) {
                    isRightKeyPressed = false;
                }
                if (event.getCode() == KeyCode.UP) {
                    isUpKeyPressed = false;

                } else if (event.getCode() == KeyCode.DOWN) {
                    isDownKeyPressed = false;
                }
            }
        });
    }


    private void initializeStage() {
        gamePane = new AnchorPane();
        gameScene = new Scene(gamePane, GAME_WIDTH, GAME_HEIGHT);
        gameStage = new Stage();
        gameStage.setScene(gameScene);
    }

    public void createNewGame(Stage menuStage, ChefPlayer chosenChef) {
        this.menuStage = menuStage;
        this.menuStage.hide();
        createBackground();
        createChef(chosenChef);
        createGameElements(chosenChef);
        gameLoop();
        gameStage.show();
    }

    private void createGameElements(ChefPlayer chosenChef) {
        playerLife = 2;
        pointsLabel = new SmallInfoLabel("POINTS : 00");
        pointsLabel.setLayoutX(700);
        pointsLabel.setLayoutY(20);
        gamePane.getChildren().add(pointsLabel);
        playerLifes = new ImageView[3];

        for(int i = 0; i < playerLifes.length; i++) {
            playerLifes[i] = new ImageView(chosenChef.getUrlLife());
            playerLifes[i].setLayoutX(700 + (i * 50));
            playerLifes[i].setLayoutY(80);
            gamePane.getChildren().add(playerLifes[i]);
        }
        
    }
    private void moveGameElements() {
        //star.setLayoutY(star.getLayoutY() + 5);
    }
    private void checkIfElementAreBehindTheChefAndRelocated() {

//        if(star.getLayoutY() > 1200) {
//            setNewElementPosition(star);
//        }

/*        for(int i = 0; i< brownMeteors.length; i++) {
            if(brownMeteors[i].getLayoutY() > 900) {
                setNewElementPosition(brownMeteors[i]);
            }
        }

        for(int i = 0; i< greyMeteors.length; i++) {
            if(greyMeteors[i].getLayoutY() > 900) {
                setNewElementPosition(greyMeteors[i]);
            }
        }*/
    }
    private void setNewElementPosition(ImageView image) {
        image.setLayoutX(randomPositionGenerator.nextInt(370));
        image.setLayoutY(-randomPositionGenerator.nextInt(500));
    }


    private void createChef(ChefPlayer chosenChef) {
        //chef = new ImageView(chosenChef.getUrlLife());
        chefPlayer = chosenChef;
        chefPlayer.setLayoutX(GAME_WIDTH/2);
        chefPlayer.setLayoutY(GAME_HEIGHT - 90);
        gamePane.getChildren().add(chefPlayer);
    }


    private void gameLoop() {
        gameTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                moveGameElements();
                checkIfElementAreBehindTheChefAndRelocated();
                checkIfElementsCollide();
                moveChef();
            }
        };
        gameTimer.start();
    }

    private void moveChef() {
        if (isLeftKeyPressed && !isRightKeyPressed) {
            if(angle > -30) {
                angle -= 5;
            }
            //chef.setRotate(angle);
            if(chefPlayer.getLayoutX() > -10) {
                //chef.setLayoutX(chef.getLayoutX() - 0.5);
                chefPlayer.moveX(-1);
            }
        }
        if (isRightKeyPressed && !isLeftKeyPressed) {
            if(angle < 30) {
                angle += 5;
            }
            //chef.setRotate(angle);
            if(chefPlayer.getLayoutX() < 880) {
                //chef.setLayoutX(chef.getLayoutX() + 0.5);
                chefPlayer.moveX(1);
            }
        }
        if (!isLeftKeyPressed && !isRightKeyPressed) {
            if(angle < 0) {
                angle += 5;
            } else if (angle > 0) {
                angle -= 5;
            }
        }
        if (isLeftKeyPressed &&  isRightKeyPressed) {
            if(angle < 0) {
                angle += 5;
            } else if (angle > 0) {
                angle -= 5;
            }
        }
        if (isUpKeyPressed &&  !isDownKeyPressed) {
            if(chefPlayer.getLayoutY() < 1000) {
                chefPlayer.moveY(-1);
            }
        }
        if (!isUpKeyPressed && isDownKeyPressed) {
            if(chefPlayer.getLayoutY() < 1000) {
                chefPlayer.moveY(1);
            }
        }
    }

    private void createBackground() {
        gridPane1 = new GridPane();
        gridPane2 = new GridPane();

        for (int i = 0 ; i < 1; i++) {
            ImageView backgroundImage1 = new ImageView("com/fallout/undercooked/model/resources/bkgTest.png");
            //ImageView backgroundImage2 = new ImageView("com/fallout/undercooked/model/resources/bkgTest.png");
            GridPane.setConstraints(backgroundImage1, i% 3, i / 3 );
            //GridPane.setConstraints(backgroundImage2, i% 3, i / 3 );
            gridPane1.getChildren().add(backgroundImage1);
            //gridPane2.getChildren().add(backgroundImage2);
        }

        gridPane2.setLayoutY(- 1024);
        gamePane.getChildren().addAll(gridPane1);
    }

    private void moveBackground() {
        gridPane1.setLayoutY(gridPane1.getLayoutY() + 0.5);
        gridPane2.setLayoutY(gridPane2.getLayoutY() + 0.5);

        if (gridPane1.getLayoutY() >= 1024) {
            gridPane1.setLayoutY(-1024);
        }

        if (gridPane2.getLayoutY() >= 1024) {
            gridPane2.setLayoutY(-1024);
        }
    }
    private void checkIfElementsCollide() {
//        if(SHIP_RADIUS + STAR_RADIUS > calculateDistance(chef.getLayoutX() + 49, star.getLayoutX() + 15,
//                chef.getLayoutY() + 37, star.getLayoutY() + 15)) {
//            setNewElementPosition(star);
//
//            points++;
//            String textToSet = "POINTS : ";
//            if (points < 10) {
//                textToSet = textToSet + "0";
//            }
//            pointsLabel.setText(textToSet + points);
//        }
/*
        for (int i = 0; i < brownMeteors.length; i++) {

            if (METEOR_RADIUS + SHIP_RADIUS > calculateDistance(chef.getLayoutX() + 49, brownMeteors[i].getLayoutX() + 20,
                    chef.getLayoutY() + 37, brownMeteors[i].getLayoutY() + 20)) {

                removeLife();
                setNewElementPosition(brownMeteors[i]);
            }

        }

        for (int i = 0; i < greyMeteors.length; i++) {

            if (METEOR_RADIUS + SHIP_RADIUS > calculateDistance(chef.getLayoutX() + 49, greyMeteors[i].getLayoutX() + 20,
                    chef.getLayoutY() + 37, greyMeteors[i].getLayoutY() + 20)) {

                removeLife();
                setNewElementPosition(greyMeteors[i]);
            }

        }*/
    }
    private void removeLife() {
        gamePane.getChildren().remove(playerLifes[playerLife]);
        playerLife--;
        if(playerLife < 0) {
            gameStage.close();
            gameTimer.stop();
            menuStage.show();
        }
    }
    private double calculateDistance(double x1, double x2, double y1, double y2) {
        return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
    }

}
