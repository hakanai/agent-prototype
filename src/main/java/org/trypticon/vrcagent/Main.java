package org.trypticon.vrcagent;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Main entry class.
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) {
        String applicationName = System.getProperty("branding.name");
        String applicationVersion = System.getProperty("branding.version");
        Label label = new Label(applicationName + " " + applicationVersion);

        Scene scene = new Scene(new StackPane(label), 640, 480);
        // Not possible by CSS? :thonk:
        scene.setFill(Color.TRANSPARENT);
        scene.getStylesheets().add(Main.class.getResource("vrcagent.css").toExternalForm());

        // We want transparency. Temporarily disabled while investigating Oculus dash's inability to drag the window out
//        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main entry point. I assume JavaFX is doing some magic where it looks at the stack trace to see which
     * class called it.
     *
     * @param args the command-line arguments.
     */
    public static void main(String[] args) {
        launch();
    }
}
