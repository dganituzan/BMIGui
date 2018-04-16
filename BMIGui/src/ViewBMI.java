import java.awt.Color;
import java.awt.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.html.HTML;

public class ViewBMI extends JFrame {

	JPanel pTitle = new JPanel();
	JPanel pGender = new JPanel();
	JPanel pHeight = new JPanel();
	JPanel pBody = new JPanel();
	JPanel pWeight = new JPanel();
	JPanel pAge = new JPanel(); 
	JPanel pExe = new JPanel();
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


	public ViewBMI() {

		super("BMI Calculation");

		JLabel title = new JLabel("<HTML><U>BMI CALCULATOR  </U></HTML>");
		//pTitle.setBackground(Color.red);
		title.setForeground(Color.DARK_GRAY);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font("ariel", Font.BOLD, 18));
		pTitle.setBounds(20,10,450,50);
		pTitle.add(title);


		pGender.setBounds(5,50,195,30);
		ButtonGroup buttonGroup1 = new ButtonGroup();
		male = new JRadioButton("male");
		female = new JRadioButton("Female");
		buttonGroup1.add(male);
		buttonGroup1.add(female);

		pGender.add(new JLabel("<HTML><U>Gender:</U></HTML>  "));
		pGender.add(male);
		pGender.add(female);

		pHeight.setBounds(5,90,270,80);
		// pHeight.setBackground(Color.green);
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

		pBody.setBounds(5,160,280,30);
		// pBody.setBackground(Color.blue);
		JLabel bodyFrame = new JLabel("<HTML><U>Body Frame:</U></HTML> ");
		ButtonGroup buttonGroup2 = new ButtonGroup();
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

		pWeight.setBounds(5,210,200,30);
		JLabel lWeight1 = new JLabel("<HTML><U>Actual Weight:</U></HTML> ");
		weight = new JTextField("       ");
		weight.selectAll();
		JLabel lWeight2 = new JLabel(" Kilogrames.");

		pWeight.add(lWeight1);
		pWeight.add(weight);
		pWeight.add(lWeight2);


		pAge.setBounds(5,255,70,30);
		JLabel LAge = new JLabel("<HTML><U>Age:</U></HTML> ");
		age = new JTextField("        ");
		weight.selectAll();
		pAge.add(LAge);
		pAge.add(age);


		pExe.setBounds(0,285,450,30);
		JLabel JExe = new JLabel("<HTML><U>Physical Activity:</U></HTML> ");
		ButtonGroup buttonGroup3 = new ButtonGroup();
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
		
		
		this.getContentPane().add(pTitle);
		this.getContentPane().add(pGender);
		this.getContentPane().add(pHeight);
		this.getContentPane().add(pBody);
		this.getContentPane().add(pWeight);
		this.getContentPane().add(pAge);
		this.getContentPane().add(pExe);
		setLayout(null);
		setSize(500,600);
		setResizable(true);
		setVisible(true); 
	}

	private class SliderListener implements ChangeListener {//listener for the slider1.

		public void stateChanged (ChangeEvent event) {
			//MVC.setHeight(slider.getValue());//send height selected to MVC.
			heightL.setText("Your Height: "+slider.getValue()+" cm");//set text appear near the slider.

		}//end method

	}//end slideListener
}
