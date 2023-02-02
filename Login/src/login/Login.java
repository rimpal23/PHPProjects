package login;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.text.*;

public class Login extends Application {
    
    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("JavaFX Welcome");
        
       GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        Text sceneTitle=new Text("Welcome");
        sceneTitle.setId("Welcome-text");
        //sceneTitle.setFont(Font.font("tahoma",FontWeight.NORMAL,20));
        grid.add(sceneTitle,0,0,2,1);
        TextField tf=new TextField();
        grid.add(tf,1,1);
        Label l=new Label("UserName:");
        grid.add(l,0,1);
        Label pw=new Label("Password:");
        grid.add(pw,0,2);
        PasswordField pwBox=new PasswordField();
        grid.add(pwBox,1,2);
        
        Button btn=new Button("Sign In");
        HBox h=new HBox(10);
        h.setAlignment(Pos.BOTTOM_RIGHT);
        h.getChildren().add(btn);
        grid.add(h,1,4);
        
        final Text actionTarget=new Text();
        actionTarget.setId("actionTarget");
        grid.add(actionTarget,1,6);
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
    @Override
    public void handle(ActionEvent e) {
        //actionTarget.setFill(Color.FIREBRICK);
        actionTarget.setText("Sign in button pressed");
    }
});
        Scene scene = new Scene(grid, 300, 250);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(Login.class.getResource("Login.css").toExternalForm());
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
