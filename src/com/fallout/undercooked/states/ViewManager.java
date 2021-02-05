package com.fallout.undercooked.states;

import com.fallout.undercooked.model.InfoLabel;
import com.fallout.undercooked.model.UndercookedButton;
import com.fallout.undercooked.model.UndercookedSubScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ViewManager {
    public static final int HEIGHT = 600;
    public static final int WIDTH = 900;
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;

    private final static int MENU_BUTTONS_START_X = 100;
    private final static int MENU_BUTTONS_START_Y = 230;

    private UndercookedSubScene helpSubscene;
    private UndercookedSubScene sceneToHide;

    List<UndercookedButton> menuButtons;

    public ViewManager(){
        menuButtons = new ArrayList<>();
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane,WIDTH,HEIGHT);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        createSubScenes();
        createButtons();
        createBackground();
        createLogo();

        UndercookedSubScene help = new UndercookedSubScene(new AnchorPane(),300,300);
        //help.setLayoutX(400);
        //gameScene.setLayoutY(400);
        mainPane.getChildren().add(help);
    }
    private void showSubScene(UndercookedSubScene subScene) {
        if (sceneToHide != null) {
            sceneToHide.moveSubScene();
        }else{
            sceneToHide = subScene;
            subScene.moveSubScene();

        }

    }
    private void createSubScenes() {
        helpSubscene = new UndercookedSubScene(new AnchorPane(),600,400);
        mainPane.getChildren().add(helpSubscene);

        InfoLabel desc1 = new InfoLabel("USE THE W A S D KEYS TO MOVE!");
        desc1.setLayoutX(80);
        desc1.setLayoutY(85);
        InfoLabel desc2 = new InfoLabel("COLLECT ALL THE INGREDIENTS");
        desc2.setLayoutX(80);
        desc2.setLayoutY(135);

        //helpSubscene.getPane().getChildren().add(helpLabel);
        helpSubscene.getPane().getChildren().add(desc1);
        helpSubscene.getPane().getChildren().add(desc2);
    }

    public Stage getMainStage(){
        return mainStage;
    }

    private void createButtons(){
        createStartButton();
        createHelpButton();
        createExitButton();
    }

    private void createStartButton(){
        UndercookedButton startButton = new UndercookedButton("PLAY");
        addMenuButton(startButton);
    }
    private void createHelpButton(){
        UndercookedButton helpButton = new UndercookedButton("HELP");
        addMenuButton(helpButton);
        helpButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                showSubScene(helpSubscene);

            }
        });
    }

    private void createExitButton(){
        UndercookedButton exitButton = new UndercookedButton("EXIT");
        addMenuButton(exitButton);
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainStage.close();

            }
        });
    }

    private void addMenuButton(UndercookedButton button){
        button.setLayoutX(MENU_BUTTONS_START_X);
        button.setLayoutY(MENU_BUTTONS_START_Y + menuButtons.size() * 100);
        menuButtons.add(button);
        mainPane.getChildren().add(button);
    }

    private void createBackground(){
        Image backgroundImage = new Image("com/fallout/undercooked/model/recources/kitchenBackground.png");
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null  );
        mainPane.setBackground(new Background(background));
    }

    private void createLogo() {
        ImageView logo = new ImageView("com/fallout/undercooked/model/recources/logo.png");
        logo.setLayoutX(150);
        logo.setLayoutY(50);

        logo.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                logo.setEffect(new DropShadow());

            }
        });

        logo.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                logo.setEffect(null);

            }
        });

        mainPane.getChildren().add(logo);

    }

}
