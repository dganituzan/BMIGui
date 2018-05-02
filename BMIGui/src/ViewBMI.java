import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	JLabel lGen;
	JSlider slider;
	JRadioButton small;
	JRadioButton  medium;
	JRadioButton  large;
	JTextField weight;
	JTextField age;
	JRadioButton Inactive;
	JRadioButton Moderately;
	JRadioButton Extremely;
	//BufferedImage background;
	JLabel background;
	JButton clearB;
	ImageIcon icon;
	
	public ViewBMI() {
		super("BMI Calculation");
		background=new JLabel(new ImageIcon("green2.png"));
		background.setLayout(new FlowLayout());

		/*
		 * Titles
		 */

		JLabel title = new JLabel("<HTML><U>BMI CALCULATOR  </U></HTML>");
		title.setForeground(Color.DARK_GRAY);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font("ariel", Font.BOLD, 26));
		icon = new ImageIcon("bmi.png");

		JLabel iconLab = new JLabel(icon);
		pTitle.setBounds(20,10,950,50);
		pTitle.setOpaque(false);
		pTitle.add(title);
	//	pTitle.add(iconLab);

		/*
		 * Clear Button
		 */

		clearB = new JButton("Clear All");
		clearB.setBounds(515, 415, 120, 20);
		clearB.addActionListener(new ClearFrame());



		/*
		 * Gender Panel, with raio buttons
		 */

		pGender.setBounds(220,70,150,70);
		buttonGroup1 = new ButtonGroup();
		male = new JRadioButton("male");
		female = new JRadioButton("female");
		male.setOpaque(false);
		female.setOpaque(false);
		male.setFont(male.getFont().deriveFont(16.0f)); 
		female.setFont(male.getFont().deriveFont(16.0f));
		buttonGroup1.add(male);
		buttonGroup1.add(female);
		lGen = new JLabel("<HTML><B>Gender:</B></HTML>");
		lGen.setHorizontalAlignment(JLabel.CENTER);
		lGen.setFont(new Font("ariel", 24,22));
		pGender.add(lGen);
		pGender.add(male);
		pGender.add(female);
		pGender.setOpaque(false);
		/*
		 * Height Panel, with a slider
		 */	
		pHeight.setBounds(570,70,270,130);
		slider = new JSlider();
		slider.setOpaque(false);
		heightL = new JLabel("");
		slider.setMajorTickSpacing(50);
		slider.setMinorTickSpacing(15);
		slider.setValue(110);
		slider.setPaintLabels(true);
		slider.setMaximum(220);
		slider.setPaintTicks(true);
		slider.addChangeListener(new SliderListener());
		pHeight.setOpaque(false);
		JLabel hl = new JLabel("<HTML><B>Height:</B>    </HTML> ");
		hl.setFont(new Font("ariel", 24,22));
		pHeight.add(hl);
		pHeight.add(slider);
		pHeight.add(heightL);
		/*
		 * Body Frame Panel. 
		 */	
		pBody.setBounds(545,200,320,120);
		//pBody.setBackground(Color.blue);
		JLabel bodyFrame = new JLabel("<HTML><B>Body Frame:</B>     </HTML> ");
		bodyFrame.setFont(new Font("ariel", 24,22));
		JPanel buttonP2 = new JPanel();
		buttonGroup2 = new ButtonGroup();
		small = new JRadioButton("small");
		medium = new JRadioButton("medium");
		large = new JRadioButton("large");
		small.setFont(small.getFont().deriveFont(16.0f));
		medium.setFont(medium.getFont().deriveFont(16.0f));
		large.setFont(large.getFont().deriveFont(16.0f));
		small.setOpaque(false);
		medium.setOpaque(false);
		large.setOpaque(false);
		buttonGroup2.add(small);
		buttonGroup2.add(medium);
		buttonGroup2.add(large);
		pBody.setOpaque(false);
		buttonP2.setOpaque(false);

		//pBody.add(Box.createHorizontalStrut( 80));
		buttonP2.add(small);
		buttonP2.add(medium);
		buttonP2.add(large);
		pBody.add(bodyFrame);
		pBody.add(buttonP2);
		/*
		 * Weight Panel
		 */
		pWeight.setBounds(215,200,160,70);
		JLabel lWeight1 = new JLabel("<HTML><B>Actual Weight:</B></HTML> ");
		lWeight1.setFont(new Font("ariel", 24,22));
		weight = new JTextField(4);
		weight.selectAll();
		JLabel lWeight2 = new JLabel(" Kilogrames.");
		lWeight2.setFont(new Font("ariel", 14,14));
		pWeight.setOpaque(false);

		pWeight.add(lWeight1);
		pWeight.add(weight);
		pWeight.add(lWeight2);
		/*
		 * Age Panel, text field
		 */
		pAge.setBounds(630,310,160,80);
		pAge.setBackground(Color.BLACK);
		JLabel LAge = new JLabel("<HTML><B>Age:</B></HTML> ");
		//LAge.setHorizontalAlignment(JLabel.CENTER);
		LAge.setFont(new Font("ariel", 24,22));
		JPanel textP = new JPanel();
		age = new JTextField(4);
		age.selectAll();
		JLabel lAge2 = new JLabel(" Years Old.");
		lAge2.setFont(new Font("ariel", 14,14));
		pAge.setOpaque(false);

		textP.add(age);
		textP.add(lAge2);
		pAge.add(LAge);
		//pAge.add(Box.createHorizontalStrut( 80));
		pAge.add(textP);
		textP.setOpaque(false);
		/*
		 * Exercise Panel. 
		 */
		pExe.setBounds(90,310,420,100);
		//pExe.setBackground(Color.GRAY);
		JLabel JExe = new JLabel("<HTML><B>Physical Activity:</B></HTML> ");
		JExe.setHorizontalAlignment(JLabel.CENTER);
		JExe.setFont(new Font("ariel", 24,22));
		JPanel buttonP = new JPanel();

		buttonGroup3 = new ButtonGroup();
		Inactive = new JRadioButton("Inactive");
		Moderately =  new JRadioButton("Moderately Active");
		Extremely =  new JRadioButton("Extremely Active");
		buttonGroup3.add(Inactive);
		buttonGroup3.add(Moderately);
		buttonGroup3.add(Extremely);
		Inactive.setOpaque(false);
		Moderately.setOpaque(false);
		Extremely.setOpaque(false);
		Inactive.setFont(Inactive.getFont().deriveFont(16.0f)); 
		Moderately.setFont(Moderately.getFont().deriveFont(16.0f)); 
		Extremely.setFont(Extremely.getFont().deriveFont(16.0f)); 

		pExe.setOpaque(false);


		//pBody.add(Box.createHorizontalStrut( 80));
		buttonP.add(Inactive);
		buttonP.add(Moderately);
		buttonP.add(Extremely);
		buttonP.setOpaque(false);
		pExe.add(JExe);
		pExe.add(buttonP);


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
		this.getContentPane().add(clearB);
		this.getContentPane().add(background);




		//setLayout(null);
		setSize(1000,600);
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
	private class ClearFrame implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			result.clearLabels();
			buttonGroup1.clearSelection();
			buttonGroup2.clearSelection();
			buttonGroup3.clearSelection();
			weight.setText("");
			age.setText("");
			slider.setValue(110);
		}
	}

	public String getGender() {

		String gender="";
		if(male.isSelected())
			gender= male.getText();
		else if(female.isSelected())
			gender= female.getText();
		return gender;
	}

	public double getHeightBMI() {
		double height = (double)this.slider.getValue();

		return height;
	}
	public double getWeight() {
		String temp = this.weight.getText().replaceAll("\\s+",""); 
		try {
			if(temp.isEmpty()) {
				return 0.0;
			}
			else {
				double weightB = Double.valueOf(temp);
				return weightB;
			}
		}
		catch(IllegalArgumentException e) {
			//		JOptionPane.showMessageDialog(this, "Weight must be a number!");
		}
		return 0.0;
	}
	public double getAge() {
		String temp = this.age.getText().replaceAll("\\s+",""); 
		try {
			if(temp.isEmpty()) {
				return 0.0;
			}
			else {
				double dAge = Double.valueOf(temp);
				return dAge;
			}		}
		catch(IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "Age must be a number!");
		}
		return 0.0;
	}
	public ResultPanel getResult()
	{
		return result;
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