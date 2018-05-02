import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ControlBMI {

	private double finalBMI, EER, age, weight;
	private String weightStatus;
	private ModelBMI model;
	private ViewBMI view ;
	private ResultPanel result;

	public ControlBMI (ViewBMI theView,ModelBMI theModel , ResultPanel result) {

		this.view = theView;
		this.model = theModel;
		this.result = result;
		
		this.result.addCalculationListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {

				// TODO Auto-generated method stub
				result.setLabels(String.format("%.2f",getBMI()), String.format("%.2f",getEER()), getWeightStatus());
				
			}
		});
	}

	/*	class CalculationListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {

			System.out.println("listener2");

			// TODO Auto-generated method stub
			result.setLabels(Double.toString(getBMI()), Double.toString(getEER()), getWeightStatus());

		}

	}*/
	
	public double getBMI() {
		this.weight = view.getWeight();
		double height= view.getHeightBMI();
		this.finalBMI = model.calculateBMI(this.weight, height);
		return this.finalBMI;
	}

	public String getWeightStatus() {
		this.weightStatus = model.calculateStatus();
		return this.weightStatus;
	}

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
