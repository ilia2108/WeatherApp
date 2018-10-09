package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sun.jvm.hotspot.debugger.Page;
import sun.jvm.hotspot.memory.ParNewGeneration;

import java.io.IOException;


public class Main extends Application {
    APIConnection Connection;
    Response APIResponse;
    Controller PageController;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Connection = new APIConnection("a7e24089fc416def2151848e96979359");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        PageController = loader.getController();
        primaryStage.setTitle("WeatherApp");
        Scene scene = new Scene(root, 400, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
        PageController.btn_Search.setOnMouseClicked(mouseEvent -> {
            Connection.FormRequestQuery(PageController.txt_CityName.getText()
                    .toLowerCase()
                    .replaceAll("\\s+",""));
            try {
                APIResponse = Connection.SendRequest();
            } catch (IOException e) {
                PageController.txt_Coords.setText("Sorry, something went wrong:( Please try again");
                //e.printStackTrace();
            }
            PageController.txt_Coords.setText("City Coordinates: "+APIResponse.getCoord().lat + ","
                    + APIResponse.getCoord().lon);
            PageController.txt_Weather.setText("Weather: "+APIResponse.getWeather());
            PageController.txt_Temp.setText("Avg temperature: "+APIResponse.getMain().temp+
                    "("+APIResponse.getMain().temp_min+"..."+APIResponse.getMain().temp_max+")");
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
