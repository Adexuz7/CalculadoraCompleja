package dad.javafx.calcom.fxbeans;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Complejo {
	
	private DoubleProperty real = new SimpleDoubleProperty();
	private DoubleProperty imaginario = new SimpleDoubleProperty();
	
	public Complejo() {
		
	}
	
	public Complejo(DoubleProperty real, DoubleProperty imaginario) {
		this.real = real;
		this.imaginario = imaginario;
	}
	
	public final DoubleProperty realProperty() {
		return this.real;
	}
	
	public final double getReal() {
		return this.realProperty().get();
	}
	
	public final void setReal(final double real) {
		this.realProperty().set(real);
	}
	
	public final DoubleProperty imaginarioProperty() {
		return this.imaginario;
	}
	
	public final double getImaginario() {
		return this.imaginarioProperty().get();
	}
	
	public final void setImaginario(final double imaginario) {
		this.imaginarioProperty().set(imaginario);
	}

}
