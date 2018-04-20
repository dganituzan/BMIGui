import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ViewBMI view = new ViewBMI();
		ModelBMI model = new ModelBMI();
		ResultPanel result = new ResultPanel();
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ControlBMI co = new ControlBMI(view,model,result);
		
	}

}
