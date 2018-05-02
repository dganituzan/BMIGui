import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ViewBMI view = new ViewBMI();
		ModelBMI model = new ModelBMI();
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ControlBMI control = new ControlBMI(view,model,view.getResult());
		
	}

}
