import java.awt.event.ActionEvent;
import java.io.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

public class ResultPanel extends JPanel {
	
	JLabel calculate = new JLabel();
	ControlBMI control;
	JLabel EERLab = new JLabel();
	String bmi;
	JButton calculateB;
	
	public ResultPanel() {
		
		/*
		 * Calculate Button.		
		 */
		
		setBounds(0,380,450,200);
		
		calculateB = new JButton("Calculate");
		calculateB.setBounds(190, 4, 100, 30);
		calculate.setBounds(100,25,400,100);
		EERLab.setBounds(100,50,400,100);
		
		add(calculateB);
		add(calculate);
		add(EERLab);
		setLayout(null);
		
	}
	
	void addCalculationListener(ActionListener listenerforCalc) {
		
		
		calculateB.addActionListener(listenerforCalc);
		
	}
	
	public void setLabels(String newBMI, String EER, String status) {
		
	
		calculate.setText("Your BMI is " + newBMI + " You are "+status);
		EERLab.setText("Estimated Energy Requirements is: " +EER);
		
	}
	
}