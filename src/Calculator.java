import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
public class Calculator extends JFrame implements MyClickable {
    private JTextField textfield;
    private final JButton[] numberButtons = new JButton[10];
    private final JButton[] functionButtons = new JButton[9];
    private JButton addButton, subButton, mulButton, divButton;
    private JButton decButton, equButton, delButton, clrButton, negButton;
    private final JPanel buttonsPanel=new JPanel();
    private final JPanel panel = new JPanel();
    private final Color myPrimaryColor= Color.decode("#9affe2");
    private final Color mySecondaryColor= Color.decode("#006e5f");
    private final Font myFont = new Font("Arial", Font.BOLD, 30);
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    public Calculator() {
        display();
    }

    private void display(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 550);
        setLayout(null);
        setResizable(false);
        panel.setBounds(0, 0, 420, 550);
        panel.setBackground(mySecondaryColor);
        panel.setLayout(null);
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBackground(myPrimaryColor);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(myPrimaryColor);
        }
        negButton.setBounds(50, 430, 100, 50);
        negButton.setBackground(myPrimaryColor);
        delButton.setBounds(150, 430, 100, 50);
        delButton.setBackground(myPrimaryColor);
        clrButton.setBounds(250, 430, 100, 50);
        clrButton.setBackground(myPrimaryColor);
        buttonsPanel.setBounds(50, 100, 300, 300);
        buttonsPanel.setLayout(new GridLayout(4, 4, 10, 10));
        buttonsPanel.setBackground(mySecondaryColor);
        buttonsPanel.add(numberButtons[1]);
        buttonsPanel.add(numberButtons[2]);
        buttonsPanel.add(numberButtons[3]);
        buttonsPanel.add(addButton);
        buttonsPanel.add(numberButtons[4]);
        buttonsPanel.add(numberButtons[5]);
        buttonsPanel.add(numberButtons[6]);
        buttonsPanel.add(subButton);
        buttonsPanel.add(numberButtons[7]);
        buttonsPanel.add(numberButtons[8]);
        buttonsPanel.add(numberButtons[9]);
        buttonsPanel.add(mulButton);
        buttonsPanel.add(decButton);
        buttonsPanel.add(numberButtons[0]);
        buttonsPanel.add(equButton);
        buttonsPanel.add(divButton);
        panel.add(buttonsPanel);
        panel.add(negButton);
        panel.add(delButton);
        panel.add(clrButton);
        panel.add(textfield);
        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textfield.setText(textfield.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            if(!textfield.getText().isEmpty()) {
                if(num1 != 0){
                    num2 = Double.parseDouble(textfield.getText());
                    result = num1 + num2;
                    num1 = result;
                    num2 =0;
                    result = 0;
                    textfield.setText("");
                }else {
                    num1 = Double.parseDouble(textfield.getText());
                    operator = '+';
                    textfield.setText("");
                }
            }
        }
        if (e.getSource() == subButton) {
            if(!textfield.getText().isEmpty()) {
                if(num1 != 0){
                    num2 = Double.parseDouble(textfield.getText());
                    result = num1 - num2;
                    num1 = result;
                    num2 =0;
                    result = 0;
                    textfield.setText("");
                }else {
                    num1 = Double.parseDouble(textfield.getText());
                    operator = '-';
                    textfield.setText("");
                }
            }

        }
        if (e.getSource() == mulButton) {
            if(!textfield.getText().isEmpty()) {
                if(num1 != 0){
                    num2 = Double.parseDouble(textfield.getText());
                    result = num1 * num2;
                    num1 = result;
                    num2 =0;
                    result = 0;
                    textfield.setText("");
                }else {
                    num1 = Double.parseDouble(textfield.getText());
                    operator = '*';
                    textfield.setText("");
                }
            }
        }
        if (e.getSource() == divButton) {
            if(!textfield.getText().isEmpty()) {
                if(num1 != 0){
                    num2 = Double.parseDouble(textfield.getText());
                    result = num1 / num2;
                    num1 = result;
                    num2 =0;
                    result = 0 ;
                    textfield.setText("");
                }else {
                    num1 = Double.parseDouble(textfield.getText());
                    operator = '/';
                    textfield.setText("");
                }
            }
        }
        if (e.getSource() == equButton) {
            if (!textfield.getText().isEmpty()) {
                num2 = Double.parseDouble(textfield.getText());
                switch (operator) {
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
        }
        if (e.getSource() == clrButton) {
            textfield.setText("");
        }
        if (e.getSource() == delButton) {
            if (!textfield.getText().isEmpty()) {
                String string = textfield.getText();
                textfield.setText("");
                for (int i = 0; i < string.length() - 1; i++) {
                    textfield.setText(textfield.getText() + string.charAt(i));
                }
            }
        }
        if (e.getSource() == negButton) {
            if(!textfield.getText().isEmpty()){
                double temp = Double.parseDouble(textfield.getText());
                temp *= -1;
                textfield.setText(String.valueOf(temp));
            }else{
                textfield.setText("-");
            }
        }
    }
}