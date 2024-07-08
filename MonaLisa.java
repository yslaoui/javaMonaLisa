package javaMonaLisa;

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
        Image initialImage = new Image("file:src/main/java/javaMonaLisa/lisa.jpg", 600, 600, true, true);
        ImageView initialImageView = new ImageView(initialImage);
        PixelReader initialImageReader = initialImage.getPixelReader();
        int width = (int) initialImage.getWidth();
        int height = (int) initialImage.getHeight();

        // Creating the target image and its writer
        WritableImage targetImage = new WritableImage(width/2, height/2);
        PixelWriter targetPixelWriter = targetImage.getPixelWriter();
        for (int y=0; y<height/2; y++) {
            for (int x=0; x<width/2; x++) {
                // Extract the color from initial image reader at position (x,y)
                Color initialImageColor = initialImageReader.getColor(2*x, 2*y);
                double red = initialImageColor.getRed();
                double green = initialImageColor.getGreen();
                double blue = initialImageColor.getBlue();
                double opacity = initialImageColor.getOpacity();
                // Apply that color to the target image (which is half the size)
                Color targetColor = new Color(1-red, 1-green, 1-blue, opacity);
                targetPixelWriter.setColor(x, y, targetColor);
            }
        }
        ImageView targetImageView = new ImageView(targetImage);
        ImageView topRightImageView = new ImageView(targetImage);
        ImageView bottomLeftImageView = new ImageView(targetImage);
        ImageView bottomRightImageView = new ImageView(targetImage);
        topRightImageView.setTranslateX(width/2);
        bottomLeftImageView.setTranslateY(height/2);
        bottomRightImageView.setTranslateX(width/2);
        bottomRightImageView.setTranslateY(height/2);


        Pane pane = new Pane();
        pane.getChildren().addAll(initialImageView,
                        targetImageView,
                        topRightImageView,
                        bottomLeftImageView,
                        bottomRightImageView);

        Scene scene = new Scene(pane);
        window.setScene(scene);

        window.show();
    }

    public static void main(String[] args) {
        launch(MonaLisa.class);
    }
}
