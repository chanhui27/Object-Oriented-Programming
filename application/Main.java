package application;
import static java.lang.System.out;
	
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;



import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			StackPane root = new StackPane();
			//define the variables 
			double width = 400, height = 400;
			int radius =10, speed = 5;
			int random_num = ThreadLocalRandom.current().nextInt(5,11);//create random dots 5 to 10
			
			//pane
			Pane gamePane = new Pane();
			root.getChildren().add(gamePane);
			
			//timerBox
			VBox timerBox = new VBox();
			timerBox.setAlignment(Pos.TOP_CENTER);
			root.getChildren().add(timerBox);					
			
			//target box
			VBox target = new VBox();
			target.setAlignment(Pos.BOTTOM_CENTER);
			root.getChildren().add(target);
			
			//timer label:display timer on the top of the game pane
			Label label = new Label("");
			label.setFont(Font.font(20));
			label.setTextFill(Color.BLUE);
			timerBox.getChildren().add(label);
				
			//target label:display the number of target left
			Label label_t = new Label("Target left: "+random_num );
			label_t.setFont(Font.font(20));
			label_t.setTextFill(Color.GREEN);
			target.getChildren().add(label_t);
			
			Circle movingc = new Circle(height/2,width/2,radius);
			movingc.setFill(Color.RED);
			gamePane.getChildren().add(movingc);
			
		
			
			//making random black dot
			for(int i=0;i<random_num;i++)
			{
				double randomx = ThreadLocalRandom.current().nextDouble(5,width-5);
				double randomy = ThreadLocalRandom.current().nextDouble(5,height-5);
				Circle dot = new Circle(randomx, randomy, 5);
				dot.setFill(Color.BLACK);
				gamePane.getChildren().add(dot);//put dots into the game pane
			
			}	
			
		
		
			gamePane.setFocusTraversable(true);
			
			Scene scene = new Scene(root,width, height);
			primaryStage.setScene(scene);
			primaryStage.show();	
			gamePane.requestFocus();//bring the game pane to focus
			
			//set timer
			AnimationTimer timer = new AnimationTimer() {
				private long startTime = System.currentTimeMillis();
				@Override public void handle(long stamp) {
					long present = System.currentTimeMillis();
					double elapseTime = (present - startTime)/1000.0;
					label.setText("Elapsed time: "+(int)elapseTime+" seconds");//set text to the timer label 
		
				}
			};
			
			timer.start();
			
			//movement of a main dot
			gamePane.setOnKeyPressed(e -> {		
				double x = movingc.getCenterX();
				double y = movingc.getCenterY();
					
				switch(e.getCode()) 
				{
					case UP:
						if (y > radius)//if it hasn't reached the top edge
							movingc.setCenterY(y-speed);//set circle new location
						break;
					case LEFT:
						if(x > radius)//if it hasn't reached the far left edge
							movingc.setCenterX(x - speed);
						break;
					case DOWN:
						if(y < height - radius)
							movingc.setCenterY(y+speed);
						break;
					case RIGHT:
						if(x < width - radius)
							movingc.setCenterX(x+speed);
					default: //nothing to do
						break;
				}
				
				//to collect all overlapping black dots
				List<Node> overlaps = new LinkedList<>();
				ObservableList<Node> allCircles = gamePane.getChildren();
				
				for(Node n : allCircles) {
					Circle c = (Circle) n;
					if(isOverlap(movingc, c)) 
					{
						overlaps.add(c); // add to overlap list
					}
				}
				
				for(Node n : overlaps) {
					allCircles.remove(n);
					int discount = allCircles.size()-1;
					label_t.setText("Target left: " +discount); //remove the dots when it overlaps and discount the number of target left
				}
					
				if(allCircles.size()==1) {
					//only the red circle is left on panel
					movingc.setFill(Color.BLUE); //change the main dot color
					timer.stop();//stop the timer
				}
					
			});			
				
		} catch(Exception e) {//if any errors appear find it			
			e.printStackTrace();
		}
	}
	
	//method for overlapping dots
	public boolean isOverlap(Circle c1, Circle c2) {
		double x1 = c1.getCenterX();
		double y1 = c1.getCenterY();
		double x2 = c2.getCenterX();
		double y2 = c2.getCenterY();
		
		double comp1 = Math.pow(Math.abs(x2-x1), 2);
		double comp2 = Math.pow(Math.abs(y2-y1), 2);
		double distance =Math.sqrt(comp1+comp2);
		double r1 = c1.getRadius();
		double r2 = c2.getRadius();
		boolean cond1 = distance <= r1 + r2;
		boolean cond2 = distance > 0;
		boolean overlap = cond1 && cond2;
		return overlap;
		
	}

	public static void main(String[] args) {
		launch(args);//starts the game
	}
}
