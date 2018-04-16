
public class ModelBMI {

	private double bmi=0;
	private String weightStatus;
	private double EERMale, EERFemale;

	public double calculateBMI(double weight, double height) {
		this.bmi = 1.3*weight/(Math.pow(height, 2.5));
		return this.bmi;	
	}

	public String calculateStatus() {
		if(bmi<=15.0)
			this.weightStatus = "Anorexic";
		else if(bmi>15.0 && bmi <=18.5) 
			this.weightStatus ="Underweight";
		else if(bmi>18.5 && bmi <=24.9)
			this.weightStatus ="Normal";
		else if(bmi>=25.0 && bmi <=29.9)
			this.weightStatus = "Overweight";
		else if(bmi>=30.0 && bmi <=35)
			this.weightStatus = "Obese";
		else if(bmi>35)
			this.weightStatus = "Extreme Obese";
		return this.weightStatus;
	}

	public double EER(String gender,double age, double weight, double height, String PA) {

		double intPA=0;
		if(PA.equals("Inactive"))
			intPA = 1.0;
		else if(PA.equals("Moderately Active" ))
			intPA =1.27;
		else if(PA.equals("Extremely Active" ))	
			intPA =1.45;

		if(gender.equals("male")) {
			this.EERMale = (662 - (9.53 * age)) + (intPA * ((15.91 * weight) + (539.6 * height)));
			return EERMale;
		}
		else {
			this.EERFemale = (354 - (6.91 * age)) + (intPA * ((9.36 * weight) + (726 * height)));
			return EERFemale;
		}
	}
}