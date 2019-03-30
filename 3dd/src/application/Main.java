package application;
	
import javafx.animation.RotateTransition;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.transform.Rotate;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Cylinder cylinder  = new Cylinder();
		
		cylinder.setHeight(200);
		cylinder.setRadius(100);
		
		cylinder.setTranslateX(350);
		cylinder.setTranslateY(150);
		cylinder.setTranslateZ(50);
		
		PhongMaterial mt = new PhongMaterial();
		mt.setDiffuseColor(Color.GREEN);
		
		cylinder.setMaterial(mt);
		RotateTransition rt = new RotateTransition();
		rt.setDuration(Duration.millis(1000));
		rt.setNode(cylinder);
		rt.setAxis(Rotate.X_AXIS);
		rt.setByAngle(360);
		rt.setCycleCount(1000);
		
		Button btn = new Button();
		btn.setText("Start");
		btn.setLayoutX(50);
		btn.setLayoutY(100);
		
		EventHandler<javafx.scene.input.MouseEvent> ehb = new EventHandler<javafx.scene.input.MouseEvent> () {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				rt.play();
			}
		};
		
		Button btn2 = new Button();
		btn2.setText("Stop");
		btn2.setLayoutX(50);
		btn2.setLayoutY(140);
		
			
		EventHandler<javafx.scene.input.MouseEvent> ehb2 = new EventHandler<javafx.scene.input.MouseEvent> () {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				rt.stop();
			}
			
		};
		
		btn.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, ehb);
		btn2.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, ehb2);
		Group root = new Group(cylinder,btn,btn2);
		Scene scene= new Scene(root, 600, 600);
		PerspectiveCamera camera = new PerspectiveCamera();
		camera.setTranslateX(0);
		camera.setTranslateY(0);
		camera.setTranslateZ(0);
		scene.setCamera(camera);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		}

	public static void main(String[] args) {
		launch(args);
	}
}
