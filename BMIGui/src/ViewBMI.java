import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.html.HTML;

public class ViewBMI extends JFrame{
	
	JPanel pTitle = new JPanel();
	JPanel pGender = new JPanel();
	JPanel pHeight = new JPanel();
	

	public ViewBMI() {
		
		super("BMI Calculation");
		

		JLabel title = new JLabel("BMI CALCULATOR");
		title.setForeground(Color.DARK_GRAY);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font("ariel", Font.BOLD, 18));
		pTitle.setBounds(20,10,400,50);
		pTitle.add(title);
		
		
		pGender.setBounds(5,50,200,30);
		ButtonGroup buttonGroup = new ButtonGroup();
		JRadioButton male = new JRadioButton("male");
	    JRadioButton female = new JRadioButton("Female");
	    buttonGroup.add(male);
		buttonGroup.add(female);
		
	    pGender.add(new JLabel("Gender: "));
	    pGender.add(male);
	    pGender.add(female);
	    
	    pHeight.setBounds(5,80,280,150);
	    JSlider slider = new JSlider();
	    slider.setMajorTickSpacing(48);
	    slider.setMinorTickSpacing(16);
	    slider.setPaintTicks(true);
	    pHeight.add(new JLabel("Height: "));
	    pHeight.add(slider);
	    

	    this.getContentPane().add(pTitle);
	    this.getContentPane().add(pGender);
	    this.getContentPane().add(pHeight);
	    setLayout(null);
	    setSize(500,600);
		setResizable(true);
		setVisible(true); 
	}
}
