import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ControlBMI {

	private double finalBMI, EER, age, weight;
	private String weightStatus;
	private ModelBMI model;
	private ViewBMI view ;
	private ResultPanel result;
	/*
	 * The controller is "merging" the model and the view.
	 */
	public ControlBMI (ViewBMI theView,ModelBMI theModel , ResultPanel result) {

		this.view = theView;
		this.model = theModel;
		this.result = result;
		// adding the listener for the calculate button.
		this.result.addCalculationListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {

				// TODO Auto-generated method stub
				result.setLabels(String.format("%.2f",getBMI()), String.format("%.2f",getEER()), getWeightStatus());
			}
		});
	}
	/**
	 * gets the weight and height from the view, according to the user input
	 * @return updated BMI.
	 */
	public double getBMI() {
		this.weight = view.getWeight();
		double height= view.getHeightBMI();
		this.finalBMI = model.calculateBMI(this.weight, height);
		return this.finalBMI;
	}
	/**
	 * @return weight status according to the user BMI
	 */
	public String getWeightStatus() {
		this.weightStatus = model.calculateStatus();
		return this.weightStatus;
	}
	/**
	 * gets the the details from the user input: age,weight, height. PA
	 * from the model
	 * @return the eer of the user according to the model calculation
	 */
	public double getEER() {

		this.age = view.getAge();
		String gender = view.getGender();
		double height = view.getHeight();
		String PA = view.getActivity();
		this.EER = model.getEER(gender, this.age, this.weight, height, PA);
		if(PA.equals("") || height == 110.0 || gender.equals("") || age == 0.0) {
			return 0.00;
		}
		return this.EER;
	}

}
