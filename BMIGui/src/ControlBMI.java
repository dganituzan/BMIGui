import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlBMI {

	private double finalBMI, EER;
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
				result.setLabels(Double.toString(getBMI()), Double.toString(getEER()), getWeightStatus());

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
		double height= view.getHeightBMI();
		double weight = view.getWeight();
		this.finalBMI = model.calculateBMI(weight, height);
		return this.finalBMI;
	}

	public String getWeightStatus() {
		this.weightStatus = model.calculateStatus();
		return this.weightStatus;
	}

	public double getEER() {
		String gender = view.getGender();
		double age = view.getAge();
		double weight = view.getWeight();
		double height = (double)view.getHeight();
		String PA = view.getActivity();
		this.EER = model.getEER(gender, age, weight, height, PA);
		System.out.println(this.EER);
		return this.EER;
	}

}
