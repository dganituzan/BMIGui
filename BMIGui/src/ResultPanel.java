import java.awt.event.ActionEvent;
import java.io.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

public class ResultPanel extends JPanel {

	JLabel calculate = new JLabel();
	JLabel EERLab = new JLabel();
	String bmi;
	JButton calculateB;


	public ResultPanel() {

		/*
		 * Calculate Button.		
		 */

		setBounds(0,400,800,220);
	//	this.setBackground(Color.BLACK);
		calculateB = new JButton("Calculate BMI");
		calculateB.setBounds(370, 15, 120, 20);

		
		calculateB.setHorizontalAlignment(JLabel.CENTER);
		calculate.setFont(new Font("Ariel", Font.BOLD, 20));
		EERLab.setFont(new Font("Ariel", Font.BOLD, 20));
		calculate.setBounds(300,25,400,100);
		EERLab.setBounds(300,50,400,100);

		setOpaque(false);
	
		add(calculateB);
		add(calculate);
		add(EERLab);

		setLayout(null);

	}

	void addCalculationListener(ActionListener listenerforCalc) {


		calculateB.addActionListener(listenerforCalc);

	}

	public void setLabels(String newBMI, String EER, String status) {

		if(newBMI.equals("0.00") || EER.equals("0.00") || status.equals("")) {
			JOptionPane.showMessageDialog(null, "some input is missing");
			calculate.setText("");
			EERLab.setText("");
		}
		else {
			calculate.setText("Your BMI is " + newBMI + " You are "+status);
			EERLab.setText("Estimated Energy Requirements is: " +EER);
		}
	}
	
	public void clearLabels() {
		calculate.setText("");
		EERLab.setText("");
	}


}