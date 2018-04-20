import java.awt.event.ActionEvent;
import java.io.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

public class ResultPanel extends JPanel {
	
	JLabel calculate = new JLabel("hey");
	ControlBMI control;
	JLabel EERLab = new JLabel("hello");
	String bmi;
	JButton calculateB;
	
	public ResultPanel() {
		/*
		 * Calculate Button.		
		 */
		
		setBounds(0,380,450,200);
		
		calculateB = new JButton("Calculate");
		calculateB.setBounds(190, 4, 100, 30);
		calculate.setBounds(180,25,250,70);
		EERLab.setBounds(180,50,250,70);
		
		add(calculateB);
		add(calculate);
		add(EERLab);
		setLayout(null);
		
	}
	
	void addCalculationListener(ActionListener listenerforCalc) {
		
		System.out.println("listener1");
		calculateB.addActionListener(listenerforCalc);
		
	}
	
	public void setLabels(String newBMI, String EER, String status) {
		
		System.out.println("listener");
		calculate.setText("Your BMI is" + newBMI + "/n You are "+status);
		EERLab.setText("Estimated Energy Requirements is: " +EER);
		
	}
	
	
}