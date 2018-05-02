

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

public class ResultPanel extends JPanel {

	JLabel calculate = new JLabel();
	JLabel EERLab = new JLabel();
	String bmi;
	JButton calculateB;


	public ResultPanel() {
		setBounds(0,380,700,220);
		/*
		 * Calculate Button.		
		 */
		calculateB = new JButton("Calculate BMI");
		calculateB.setBounds(170, 0, 120, 20);
		/*
		 * result labels
		 */
		calculate.setFont(new Font("Ariel", Font.BOLD, 20));
		EERLab.setFont(new Font("Ariel", Font.BOLD, 20));
		calculate.setBounds(110,25,400,100);
		EERLab.setBounds(110,50,400,100);

		setOpaque(false);

		add(calculateB);
		add(calculate);
		add(EERLab);

		setLayout(null);
	}
	/*
	 * gives the controller the control on the calculate button,
	 * and let him to add an action listener.
	 */
	void addCalculationListener(ActionListener listenerforCalc) {
		calculateB.addActionListener(listenerforCalc);
	}
	/**
	 * changes the BMI results labels according to the user input 
	 * @param newBMI
	 * @param EER
	 * @param status
	 */
	public void setLabels(String newBMI, String EER, String status) {

		if(newBMI.equals("0.00") || EER.equals("0.00") || status.equals("")) {
			JOptionPane.showMessageDialog(null, "some input is missing! Please try again.");
			calculate.setText("");
			EERLab.setText("");
		}
		else {
			calculate.setText("Your BMI: " + newBMI + " You are "+status+"!");
			EERLab.setText("Estimated energy requirements " +EER+".");
		}
	}
	/**
	 * clear labels
	 */
	public void clearLabels() {
		calculate.setText("");
		EERLab.setText("");
	}


}