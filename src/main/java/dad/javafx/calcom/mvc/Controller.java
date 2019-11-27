package dad.javafx.calcom.mvc;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import dad.javafx.calcom.fxbeans.Complejo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.fxml.Initializable;

public class Controller implements Initializable {

	@FXML
	private HBox root;

	@FXML
	private VBox opVBox;

	@FXML
	private ComboBox<String> opComboBox;

	@FXML
	private VBox numVBox;

	@FXML
	private HBox topHBox;

	@FXML
	private TextField firstTopTextField;

	@FXML
	private Label opTopLabel;

	@FXML
	private TextField secondTopTextField;

	@FXML
	private Label iTopLabel;

	@FXML
	private HBox centerHBox;

	@FXML
	private TextField firstCenterTextField;

	@FXML
	private Label opCenterLabel;

	@FXML
	private TextField secondCenterTextField;

	@FXML
	private Label iCenterLabel;

	@FXML
	private Separator separator;

	@FXML
	private HBox bottomHBox;

	@FXML
	private TextField firstBottomTextField;

	@FXML
	private Label opBottomLabel;

	@FXML
	private TextField secondBottomTextField;

	@FXML
	private Label iBottomLabel;

	@FXML
	private VBox resultVBox;

	@FXML
	private Button resultButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		List<String> operadoresList = new ArrayList<String>();
		operadoresList.add("+");
		operadoresList.add("-");
		operadoresList.add("*");
		operadoresList.add("/");

		ObservableList<String> operadoresObservableList = FXCollections.observableArrayList(operadoresList);
		opComboBox.setItems(operadoresObservableList);
		opComboBox.setValue("+");
		
		firstTopTextField.setText(Double.toString(0));
		secondTopTextField.setText(Double.toString(0));
		firstCenterTextField.setText(Double.toString(0));
		secondCenterTextField.setText(Double.toString(0));
		firstBottomTextField.setText(Double.toString(0));
		secondBottomTextField.setText(Double.toString(0));
		
		resultButton.setOnAction(e -> onResultAction(e));

	}

	private void onResultAction(ActionEvent e) {

		try {

			Complejo c1 = new Complejo();
			c1.setReal(Double.parseDouble(firstTopTextField.getText()));
			c1.setImaginario(Double.parseDouble(secondTopTextField.getText()));

			Complejo c2 = new Complejo();
			c2.setReal(Double.parseDouble(firstCenterTextField.getText()));
			c2.setImaginario(Double.parseDouble(secondCenterTextField.getText()));

			Complejo result = new Complejo();

			switch (opComboBox.getValue()) {
			case "+":

				result.setReal(c1.getReal() + c2.getReal());
				result.setImaginario(c1.getImaginario() + c2.getImaginario());

				break;

			case "-":

				result.setReal(c1.getReal() - c2.getReal());
				result.setImaginario(c1.getImaginario() - c2.getImaginario());

				break;

			case "*":

				result.setReal((c1.getReal() * c2.getReal()) - (c1.getImaginario() * c2.getImaginario()));
				result.setImaginario((c1.getReal() * c2.getImaginario()) + (c1.getImaginario() * c2.getReal()));

				break;

			case "/":

				result.setReal(((c1.getReal() * c2.getReal()) + (c1.getImaginario() * c2.getImaginario()))
						/ ((Math.pow(c2.getReal(), 2) + (Math.pow(c2.getImaginario(), 2)))));
				
				result.setImaginario((c1.getImaginario() * c2.getReal()) - (c1.getReal() * c2.getImaginario())
						/ ((Math.pow(c2.getReal(), 2) + (Math.pow(c2.getImaginario(), 2)))));

				break;
			}

			firstBottomTextField.setText(Double.toString(result.getReal()));
			secondBottomTextField.setText(Double.toString(result.getImaginario()));

		} catch (NumberFormatException numberFormatException) {
			System.out.println("NumberFormatException");
		}

	}

	public Controller() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();
	}

	public HBox getView() {
		return root;
	}

}
