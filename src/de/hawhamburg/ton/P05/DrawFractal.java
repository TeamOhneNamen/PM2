/**
 * DrawFractal.java
 * @author Ferdinand Trendelenburg.
 * @author Thorben Schomacker.
 */
package de.hawhamburg.ton.P05;

import de.hawhamburg.ton.P01.Complex;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class DrawFractal extends Application {
	private static final int WIDTH = 500;
	private static final int HEIGHT = 500;
	private static final double SCALE = WIDTH * 1.0 / HEIGHT;

	private static final double HALT = 2.0;

	private BorderPane rootPane;
	private FadeTransition ft;
	private Canvas canvas;

	private Julia set = new Julia();

	private TextField z0Re = new TextField();
	private TextField z0Im = new TextField();

	private TextField cRe = new TextField();
	private TextField cIm = new TextField();

	private double zoom = 1.0;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		rootPane = new BorderPane();
		ft = new FadeTransition();

		canvas = new Canvas(WIDTH, HEIGHT);

		ft.setNode(canvas);
		ft.setDuration(new Duration(2000));
		ft.setFromValue(1.0);
		ft.setToValue(0.0);
		draw(canvas.getGraphicsContext2D(), set);

		GridPane controlGridpane = new GridPane();
		controlGridpane.setPadding(new Insets(150, 0, 0, 10));

		Label z0ReLabel = new Label("z0 real part");
		Label z0ImLabel = new Label("z0 ima. part");
		Label cReLabel = new Label("c real part");
		Label cImLabel = new Label("c ima. part");

		Button draw = new Button("Draw!");
		draw.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				double zRe = Double.valueOf(z0Re.getText());
				double zIm = Double.valueOf(z0Im.getText());
				double cReal = Double.valueOf(cRe.getText());
				double cImag = Double.valueOf(cIm.getText());

				Complex z0 = Complex.ofCart(zRe, zIm);
				Complex c = Complex.ofCart(cReal, cImag);
				Julia newSet = new Julia(z0, c);

				if (!set.equals(newSet) || zoom != 1) {
					zoom = 1;
					set = newSet;
					draw(canvas.getGraphicsContext2D(), set);
				}

			}
		});

		Button processDefault = new Button("Reset");
		processDefault.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				Julia defaultJulia = new Julia();

				if (!set.equals(defaultJulia) || zoom != 1) {
					zoom = 1;
					set = defaultJulia;
					setText();
					draw(canvas.getGraphicsContext2D(), set);
				}

			}
		});

		Button zoomIn = new Button("+");
		zoomIn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				zoom += 0.5;
				draw(canvas.getGraphicsContext2D(), set);
			}
		});

		Button zoomOut = new Button("-");
		zoomOut.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				zoom -= (zoom > 1) ? 0.5 : 1;
				draw(canvas.getGraphicsContext2D(), set);
			}
		});

		z0Re.setPrefWidth(80);
		z0Im.setPrefWidth(80);
		cRe.setPrefWidth(80);
		cIm.setPrefWidth(80);

		setText();

		controlGridpane.add(z0ReLabel, 0, 0);
		controlGridpane.add(z0Re, 1, 0);
		controlGridpane.add(z0ImLabel, 0, 1);
		controlGridpane.add(z0Im, 1, 1);

		controlGridpane.add(cReLabel, 0, 3);
		controlGridpane.add(cRe, 1, 3);
		controlGridpane.add(cImLabel, 0, 4);
		controlGridpane.add(cIm, 1, 4);

		controlGridpane.add(zoomIn, 1, 6);
		controlGridpane.add(zoomOut, 0, 6);

		controlGridpane.add(draw, 0, 7);
		controlGridpane.add(processDefault, 1, 7);

		rootPane.setLeft(controlGridpane);

		rootPane.setRight(canvas);
		rootPane.setPadding(new Insets(0, 10, 0, 0));

		Scene scene = new Scene(rootPane, WIDTH + 200, HEIGHT);
		primaryStage.setTitle("Fraktal - Julia Set");
		primaryStage.setScene(scene);

		primaryStage.resizableProperty().set(false);
		primaryStage.show();

	}

	private void draw(GraphicsContext gc, Julia julia) {
		Complex z0 = julia.getZ0();
		Complex c = julia.getC();

		for (int x = 0; x < WIDTH; x++) {
			for (int y = 0; y < HEIGHT; y++) {

				double divZ0Real = (Double.doubleToLongBits(z0.getRealNumber()) != 0) ? z0.getRealNumber() : 1;
				double divZ0Im = (Double.doubleToLongBits(z0.getImaginaryNumber()) != 0) ? z0.getImaginaryNumber() : 1;

				double re = HALT * SCALE * ((x - WIDTH / 2.0) / zoom + 0) / (divZ0Real * WIDTH);
				double imag = HALT * ((HEIGHT / 2.0 - y) / zoom + 0) / (divZ0Im * HEIGHT);

				Complex z = Complex.ofCart(re, imag);

				int nIteration = 0;
				while (z.abs() < 2 && nIteration < Julia.MAX_ITERATION) {
					z = z.mul(z).add(c);
					++nIteration;
				}

				double scale = 255.0 * nIteration / Julia.MAX_ITERATION;
				if (nIteration != Julia.MAX_ITERATION) {
					gc.setFill(Color.color(scale / 500, scale / 255, 0));
				} else {
					gc.setFill(Color.GREEN);
				}

				gc.fillRect(x, y, 1, 1);
			}
		}

	}

	private void setText() {
		z0Re.setText(String.valueOf(set.getZ0().getRealNumber()));
		z0Im.setText(String.valueOf(set.getZ0().getImaginaryNumber()));
		cRe.setText(String.valueOf(set.getC().getRealNumber()));
		cIm.setText(String.valueOf(set.getC().getImaginaryNumber()));
	}
}