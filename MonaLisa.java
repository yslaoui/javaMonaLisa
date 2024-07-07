package monaLisa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MonaLisa  extends Application {
    @Override
    public void start(Stage window) throws Exception {
        // Loading initial image and its reader
        Image initialImage = new Image("file:src/main/java/monaLisa/lisa.jpg");
        ImageView initialImageView = new ImageView(initialImage);
        PixelReader initialImageReader = initialImage.getPixelReader();
        int width = (int) initialImage.getWidth();
        int height = (int) initialImage.getHeight();




        Pane pane = new Pane();
        pane.getChildren().addAll(initialImageView);

        Scene scene = new Scene(pane);
        window.setScene(scene);

        window.show();


    }

    public static void main(String[] args) {
        launch(MonaLisa.class);
    }
}
