package cn;
import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JButton;


public class mybutton extends JButton{
	int value;
	public mybutton(Icon icon){
		super(icon);
	}
	public mybutton(int value){
		super(""+value);
		this.value=value;
		this.setFont(new Font("",Font.BOLD,34));
		this.setBackground(Color.BLUE);
		this.setForeground(Color.RED);
	}
	public mybutton(){
		super("");
		this.value=0;
		
		this.setFont(new Font("",Font.BOLD,34));
		this.setSize(value, value);
		
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	
}
