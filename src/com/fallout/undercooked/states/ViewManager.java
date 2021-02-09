package com.fallout.undercooked.states;

import com.fallout.undercooked.model.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
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
    private final static int MENU_BUTTONS_START_X = 100;
    private final static int MENU_BUTTONS_START_Y = 230;
    List<UndercookedButton> menuButtons;
    List<ChefPicker> chefsList;
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;
    private UndercookedSubScene helpSubscene;
    private UndercookedSubScene startSubscene;
    private UndercookedSubScene sceneToHide;
    private CHEF chosenCHEF;
    private ChefPlayer chefPlayer;

    public ViewManager() {
        menuButtons = new ArrayList<>();
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, WIDTH, HEIGHT);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        createSubScenes();
        createButtons();
        createBackground();
        createLogo();

    }

    private void showSubScene(UndercookedSubScene subScene) {
        if (sceneToHide != null) {
            sceneToHide.moveSubScene();
        }

        sceneToHide = subScene;
        subScene.moveSubScene();
    }

    private void createSubScenes() {
        createChefChooserSubScene();
        createHelpSubScene();
    }

    private void createHelpSubScene() {
        helpSubscene = new UndercookedSubScene(new AnchorPane(), 600, 500);
        mainPane.getChildren().add(helpSubscene);
        InfoLabel desc1 = new InfoLabel("USE THE W A S D KEYS TO MOVE!");
        desc1.setLayoutX(80);
        desc1.setLayoutY(85);
        InfoLabel desc2 = new InfoLabel("COLLECT ALL THE INGREDIENTS");
        desc2.setLayoutX(80);
        desc2.setLayoutY(135);
        helpSubscene.getPane().getChildren().add(desc1);
        helpSubscene.getPane().getChildren().add(desc2);
    }

    private void createChefChooserSubScene() {
        startSubscene = new UndercookedSubScene(new AnchorPane(), 600, 500);
        mainPane.getChildren().add(startSubscene);

        InfoLabel chooseShipLabel = new InfoLabel("CHOOSE YOUR CHEF");
        chooseShipLabel.setLayoutX(80);
        chooseShipLabel.setLayoutY(25);
        startSubscene.getPane().getChildren().add(chooseShipLabel);
        startSubscene.getPane().getChildren().add(createChefsToChoose());
        startSubscene.getPane().getChildren().add(createButtonToStart());
    }

    private HBox createChefsToChoose() {
        HBox box = new HBox();
        box.setSpacing(60);
        chefsList = new ArrayList<>();
        for (CHEF chef : CHEF.values()) {
            ChefPicker chefToPick = new ChefPicker(chef);
            chefsList.add(chefToPick);
            box.getChildren().add(chefToPick);
            chefToPick.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                    for (ChefPicker ship : chefsList) {
                        ship.setIsCircleChoosen(false);
                    }
                    chefToPick.setIsCircleChoosen(true);
                    chosenCHEF = chefToPick.getChef();
                }
            });
        }
        box.setLayoutX(100);
        box.setLayoutY(100);
        return box;
    }

    private UndercookedButton createButtonToStart() {
        UndercookedButton startButton = new UndercookedButton("START");
        startButton.setLayoutX(175);
        startButton.setLayoutY(250);

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (chosenCHEF != null) {
                    chefPlayer = new ChefPlayer(chosenCHEF,chosenCHEF.getImageView());

                    GameViewManager gameManager = new GameViewManager();
                    gameManager.createNewGame(mainStage, chefPlayer);
                }
            }
        });

        return startButton;
    }

    public Stage getMainStage() {
        return mainStage;
    }

    private void createButtons() {
        createStartButton();
        createHelpButton();
        createExitButton();
    }

    private void createStartButton() {
        UndercookedButton startButton = new UndercookedButton("PLAY");
        addMenuButton(startButton);
        startButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                showSubScene(startSubscene);

            }
        });
    }

    private void createHelpButton() {
        UndercookedButton helpButton = new UndercookedButton("HELP");
        addMenuButton(helpButton);
        helpButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                showSubScene(helpSubscene);

            }
        });
    }

    private void createExitButton() {
        UndercookedButton exitButton = new UndercookedButton("EXIT");
        addMenuButton(exitButton);
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainStage.close();
            }
        });
    }

    private void addMenuButton(UndercookedButton button) {
        button.setLayoutX(MENU_BUTTONS_START_X);
        button.setLayoutY(MENU_BUTTONS_START_Y + menuButtons.size() * 100);
        menuButtons.add(button);
        mainPane.getChildren().add(button);
    }

    private void createBackground() {
        Image backgroundImage = new Image("com/fallout/undercooked/model/resources/kitchenBackground.png");
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
        mainPane.setBackground(new Background(background));
    }

    private void createLogo() {
        ImageView logo = new ImageView("com/fallout/undercooked/model/resources/logo.png");
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
