package calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener{
 
	JFrame frame;
	JTextField textfield;
	JButton[] numberbuttons = new JButton[10];
	JButton[] functionbuttons = new JButton[9];
	JButton addbutton,subbutton, mulbutton, divbutton;
	JButton decbutton, equbutton,delbutton,clrbutton,negbutton;
	JPanel panel,panel2;
	
	Font myfont = new Font("Arial", Font.PLAIN, 30);
	
	double num1=0,num2=0,result=0;
	char operator;
		
		Calculator(){
		
		 	//frame
		 	frame = new JFrame("calculator");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(500,600);
			frame.setLayout(null);
		
			textfield = new JTextField();
			textfield.setBounds( 5, 5, 475, 80); 
			textfield.setFont(myfont);
			textfield.setBackground(Color.gray);
			textfield.setEditable(false);
			
			addbutton = new JButton("+");
			subbutton = new JButton("-");
			mulbutton = new JButton("*");
			divbutton = new JButton("/");
			equbutton = new JButton("=");
			decbutton = new JButton(".");
			delbutton = new JButton("Delete");
			clrbutton = new JButton("Clear");
			negbutton = new JButton("-/+");

			functionbuttons[0] = addbutton;
			functionbuttons[1] = subbutton;
			functionbuttons[2] = mulbutton;
			functionbuttons[3] = divbutton;
			functionbuttons[4] = equbutton;
			functionbuttons[5] = decbutton;
			functionbuttons[6] = delbutton;
			functionbuttons[7] = clrbutton;
			functionbuttons[8] = negbutton;
			
			for(int i =0;i<9;i++) {
				functionbuttons[i].addActionListener(this);
				functionbuttons[i].setFont(myfont);
				functionbuttons[i].setFocusable(false);
				functionbuttons[i].setBorderPainted(false);				
			}
			
			for(int i =0;i<10;i++) {
				numberbuttons[i] = new JButton(String.valueOf(i));
				numberbuttons[i].setFont(myfont);
				numberbuttons[i].addActionListener(this);
				numberbuttons[i].setFocusable(false);
				numberbuttons[i].setBorderPainted(false);
			}
			//panel2
			panel2 = new JPanel();
			panel2.setBounds(5,490,470,70);
			panel2.setLayout(new GridLayout(1,3,0,0));
			panel2.add(negbutton);
			panel2.add(delbutton);
			panel2.add(clrbutton);
						
			//panel
			panel = new JPanel();
			panel.setBounds(5, 85, 475, 400);
			panel.setLayout(new GridLayout(4,4,0,0));
			
			//adding buttons to the panel
			for(int i=1;i<10;i++) {
				panel.add(numberbuttons[i]);
				if(i==3) {
					panel.add(addbutton);	
				}else if(i==6){
					panel.add(subbutton);
				}else if(i==9) {
					panel.add(mulbutton);
					panel.add(decbutton);
					panel.add(numberbuttons[0]);
					panel.add(equbutton);
					panel.add(divbutton);
				}
			}
			
			frame.add(panel2);
			frame.add(panel);
			frame.add(textfield);
			frame.setVisible(true);
			
	}
		
	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		
	}

	public void actionPerformed(ActionEvent e) {
		//for number buttons
		for(int i =0;i<10;i++) {
			if(e.getSource() == numberbuttons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		//for function buttons
		if(e.getSource() == decbutton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource() == addbutton) {
			num1 = Double.parseDouble(textfield.getText());
			operator='+';
			textfield.setText("");
		}
		if(e.getSource() == subbutton) {
			num1 = Double.parseDouble(textfield.getText());
			operator='-';
			textfield.setText("");
		}
		if(e.getSource() == mulbutton) {
			num1 = Double.parseDouble(textfield.getText());
			operator='*';
			textfield.setText("");
		}
		if(e.getSource() == divbutton) {
			num1 = Double.parseDouble(textfield.getText());
			operator='/';
			textfield.setText("");
		}
		if(e.getSource() == equbutton) {
			num2 = Double.parseDouble(textfield.getText());
				switch(operator) {
				case '+':
					result = num1 + num2;
					break;
				case '-':
					result = num1 - num2;
					break;
				case '*':
					result = num1 * num2;
					break;
				case '/':
					result = num1 / num2;
					break;
				}
			textfield.setText(String.valueOf(result));
			num1 = result;
		}
		if(e.getSource()==clrbutton) {
			textfield.setText("");
		}
		if(e.getSource()==delbutton) {
			String del = textfield.getText();
			textfield.setText("");
			for(int i =0;i<del.length()-1;i++) {
				textfield.setText(textfield.getText() +  del.charAt(i));
			}
		}
		if(e.getSource()==negbutton) {
			Double temp = Double.parseDouble(textfield.getText());
			Double neg = 0-temp;
			textfield.setText(String.valueOf(neg));
		}
		
	}

}
