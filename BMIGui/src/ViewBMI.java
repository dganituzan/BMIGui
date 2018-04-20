import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.*;	

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.html.HTML;

public class ViewBMI extends JFrame {

	// All panels and buttons.
	JPanel pTitle = new JPanel();
	JPanel pGender = new JPanel();
	JPanel pHeight = new JPanel();
	JPanel pBody = new JPanel();
	JPanel pWeight = new JPanel();
	JPanel pAge = new JPanel(); 
	JPanel pExe = new JPanel();
	//JPanel pCal = new JPanel();
	ResultPanel result = new ResultPanel();
	ButtonGroup buttonGroup1;
	ButtonGroup buttonGroup2;
	ButtonGroup buttonGroup3;
	JRadioButton female;
	JRadioButton male;
	JLabel heightL;
	JSlider slider;
	JRadioButton small;
	JRadioButton  medium;
	JRadioButton  large;
	JTextField weight;
	JTextField age;
	JRadioButton Inactive;
	JRadioButton Moderately;
	JRadioButton Extremely;
	BufferedImage background;


	public ViewBMI() {

		/*
		 * Titles
		 */
		super("BMI Calculation");


		JLabel title = new JLabel("<HTML><U>BMI CALCULATOR  </U></HTML>");
		title.setForeground(Color.DARK_GRAY);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font("ariel", Font.BOLD, 18));
		pTitle.setBounds(20,10,450,50);
		pTitle.add(title);

		/*
		 * Gender Panel, with raio buttons
		 */
		pGender.setBounds(5,50,195,30);
		buttonGroup1 = new ButtonGroup();
		male = new JRadioButton("male");
		female = new JRadioButton("Female");
		buttonGroup1.add(male);
		buttonGroup1.add(female);

		pGender.add(new JLabel("<HTML><U>Gender:</U></HTML>  "));
		pGender.add(male);
		pGender.add(female);
		/*
		 * Height Panel, with a slider
		 */	
		pHeight.setBounds(5,90,270,80);
		slider = new JSlider();
		heightL = new JLabel("");
		slider.setMajorTickSpacing(50);
		slider.setMinorTickSpacing(15);
		slider.setValue(110);
		slider.setPaintLabels(true);
		slider.setMaximum(220);
		slider.setPaintTicks(true);
		slider.addChangeListener(new SliderListener());

		pHeight.add(new JLabel("<HTML><U>Height:</U></HTML> "));
		pHeight.add(slider);
		pHeight.add(heightL);
		/*
		 * Body Frame Panel. 
		 */	
		pBody.setBounds(5,160,280,30);
		// pBody.setBackground(Color.blue);
		JLabel bodyFrame = new JLabel("<HTML><U>Body Frame:</U></HTML> ");
		buttonGroup2 = new ButtonGroup();
		small = new JRadioButton("small");
		medium = new JRadioButton("medium");
		large = new JRadioButton("large");
		buttonGroup2.add(small);
		buttonGroup2.add(medium);
		buttonGroup2.add(large);

		pBody.add(bodyFrame);
		pBody.add(small);
		pBody.add(medium);
		pBody.add(large);
		/*
		 * Weight Panel
		 */
		pWeight.setBounds(5,210,200,30);
		JLabel lWeight1 = new JLabel("<HTML><U>Actual Weight:</U></HTML> ");
		weight = new JTextField("       ");
		weight.selectAll();
		JLabel lWeight2 = new JLabel(" Kilogrames.");

		pWeight.add(lWeight1);
		pWeight.add(weight);
		pWeight.add(lWeight2);
		/*
		 * Age Panel, text field
		 */
		pAge.setBounds(5,255,70,30);
		JLabel LAge = new JLabel("<HTML><U>Age:</U></HTML> ");
		age = new JTextField("        ");
		weight.selectAll();
		pAge.add(LAge);
		pAge.add(age);
		/*
		 * Exercise Panel. 
		 */
		pExe.setBounds(0,285,450,30);
		JLabel JExe = new JLabel("<HTML><U>Physical Activity:</U></HTML> ");
		buttonGroup3 = new ButtonGroup();
		Inactive = new JRadioButton("Inactive");
		Moderately =  new JRadioButton("Moderately Active");
		Extremely =  new JRadioButton("Extremely Active");
		buttonGroup3.add(Inactive);
		buttonGroup3.add(Moderately);
		buttonGroup3.add(Extremely);
		pExe.add(JExe);
		pExe.add(Inactive);
		pExe.add(Moderately);
		pExe.add(Extremely);

		/*
		 * Adding all Panels into the frame.		
		 */

		this.getContentPane().add(pTitle);
		this.getContentPane().add(pGender);
		this.getContentPane().add(pHeight);
		this.getContentPane().add(pBody);
		this.getContentPane().add(pWeight);
		this.getContentPane().add(pAge);
		this.getContentPane().add(pExe);
		//this.getContentPane().add(pCal);
		this.getContentPane().add(result);
		setLayout(null);
		setSize(500,600);
		setResizable(true);
		setVisible(true); 
	}


	/*
	 * changeListener for the slider
	 */
	private class SliderListener implements ChangeListener {

		public void stateChanged (ChangeEvent event) {
			//MVC.setHeight(slider.getValue());//send height selected to MVC.
			heightL.setText("Your Height: "+slider.getValue()+" cm"); //set text appear next to the slider.

		}

	}

	public String getGender() {

		String gender="";
		if(male.isSelected())
			gender = male.getText();
		else if(female.isSelected())
			gender = female.getText();
		return gender;
	}

	public double getHeightBMI() {
		double height = (double)this.slider.getValue();
		System.out.println(height);
		return height;
	}
	public double getWeight() {
		String temp = this.weight.getText().replaceAll("\\s+",""); 
		if(temp.isEmpty()) 
			return 0.0;
		else {
			double weightB = Double.valueOf(temp);
			return weightB;
		}
	}
	public double getAge() {
		String temp = this.age.getText().replaceAll("\\s+",""); 
		if(temp.isEmpty()) 
			return 0.0;
		else {
			double dAge = Double.valueOf(temp);
			return dAge;
		}
	}
	public String getActivity() {
		String act="";
		if(Inactive.isSelected())
			act = "Inactive";
		else if(Moderately.isSelected())
			act ="Moderately Active";
		else if(Extremely.isSelected())
			act ="Extremely Active";
		return act;
	}

}