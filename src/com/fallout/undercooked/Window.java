package com.fallout.undercooked;

import com.fallout.undercooked.states.ViewManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;
 
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import com.fallout.undercooked.tiles.*;


public class Window extends Application  {
    public static void main(String[] args) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Map.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Map obj = (Map)unmarshaller.unmarshal(new File("kitchenMaze.tmx"));
        List<Layer> layerList =obj.getLayerList();
         
     
         
        System.out.println(layerList.get(0).getData().getDataArray()[0]);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            ViewManager manager = new ViewManager();
            primaryStage = manager.getMainStage();
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//test
}
