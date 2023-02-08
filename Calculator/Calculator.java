import javax.swing.*;
import java.awt.*;      //Abstract Window Toolkit
import java.awt.event.*;

public class Calculator implements ActionListener{

    /* VARIABLE DECLARATION */
    JFrame frame;  //we require a frame to put everything
    JTextField textfield;

    JButton[] numberButtons = new JButton[10];  //hold our numbers
    JButton[] functionButtons = new JButton[8];     //+-*/
    //name all the function buttons
    JButton addButton, subButton, multButton, divButton;
    JButton decButton, eqButton, delButton, clrButton;
    JPanel panel;   //to hold all the above buttons

    Font myFont = new Font("Palatino", Font.BOLD, 30);

    double num1=0, num2=0, result=0;  //everything on display screen
    char operator;      //on display eg 2/2=1


    /* CONSTRUCTOR */
    Calculator(){
        frame = new JFrame("calculator");   //constructing the jframe wiht calculator as heading
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(440,550);
        frame.setLayout(null);  //absolute positioning - we will do all the layout work with code and no manager

        //Making the jtext field
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);   //setting sizes of textfield
        textfield.setFont(myFont);
        textfield.setEditable(false);

        //Adding the buttons to frame
        addButton = new JButton("+");
        subButton = new JButton("-");
        multButton = new JButton("x");
        divButton = new JButton("÷");
        decButton = new JButton(".");
        eqButton = new JButton("=");
        delButton = new JButton("DEL");
        clrButton = new JButton("CLR");
        //Adding the buttons to the functionbuttons array
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = multButton;
        functionButtons[3] = divButton;
        functionButtons[4] = eqButton;
        functionButtons[5] = decButton;
        functionButtons[6] = clrButton;
        functionButtons[7] = delButton;
        //Working on other properties of functionbuttons
        for(int i=0;i<8;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        //Number Buttons
        for(int i=0;i<10;i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false); 
        }

        //Defining places for del and clr button
        delButton.setBounds(50,430,145,50);
        clrButton.setBounds(205,430,145,50);

        //Now we will work on Jpanel that will hold all our other buttons
        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,2,2)); //this is read as 4 rows, 4 columns and 10px space on each side
        //panel.setBackground(color.GRAY);  //you can get an idea of how big our layout was by seeing its color
        //Now we will write the buttons which will be added to the panel note they will be shown in rowwise so mention in that order for 4 columns
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);           //first row filled
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(divButton);
        panel.add(eqButton);


        //Adding everything to jframe, that will show up on our final application
        frame.add(textfield);   //add the textfield to jframe
        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.setVisible(true);

    }

    public static void main(String args[]){
        Calculator calc = new Calculator(); 

    }

    @Override
    public void actionPerformed(ActionEvent e) {   //this is need to be performed becuase class implements ActionListener
        // Auto-generated method
        //Add functionalities to our button
        for(int i=0;i<10;i++){
            if(e.getSource() == numberButtons[i]){       //when we click on a number it will update on our textfield
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource() == decButton){
            textfield.setText(textfield.getText().concat("."));
        }

        if(e.getSource() == addButton){
            num1=Double.parseDouble(textfield.getText());
            operator='+';
            textfield.setText("");  //making textfield again nothing or clearing it
        }

        if(e.getSource() == subButton){
            num1=Double.parseDouble(textfield.getText());
            operator='-';
            textfield.setText("");
        }

        if(e.getSource() == multButton){
            num1=Double.parseDouble(textfield.getText());
            operator='x';
            textfield.setText("");
        }

        if(e.getSource() == divButton){
            num1=Double.parseDouble(textfield.getText());
            operator='÷';
            textfield.setText("");
        }

        if(e.getSource() == eqButton){
            num2=Double.parseDouble(textfield.getText());

            switch(operator){
                case '+' :
                result = num1 + num2;
                break;
                case '-' :
                result = num1 - num2;
                break;
                case 'x' :
                result = num1 * num2;
                break;
                case '÷' :
                result = num1 / num2;
                break; 
            }
            textfield.setText(String.valueOf(result));
            num1 = result; //if we want to continue the calculation
        }

        if(e.getSource() == clrButton){
            textfield.setText("");
        }

        if(e.getSource() == delButton){
            String string = textfield.getText();
            textfield.setText("");
            for(int i=0;i<string.length()-1;i++){
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }
        
    }
}