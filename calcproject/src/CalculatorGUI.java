//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI implements ActionListener {
    private JFrame frame;
    private JTextField textField;
    private JPanel panel;
    private JButton[] numberButtons = new JButton[10];
    private JButton[] functionButtons = new JButton[6];
    private JButton addButton, subButton, mulButton, divButton, decButton, equalButton, clrButton;
    private double num1, num2, result;
    private char operator;

    public CalculatorGUI() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(30, 40, 330, 50);
        textField.setEditable(false);
        frame.add(textField);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equalButton = new JButton("=");
        clrButton = new JButton("C");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equalButton;

        for (int i = 0; i < 6; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(new Font("Arial", Font.BOLD, 18));
            functionButtons[i].setFocusable(false);
        }

        clrButton.addActionListener(this);
        clrButton.setFont(new Font("Arial", Font.BOLD, 18));
        clrButton.setFocusable(false);

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 18));
            numberButtons[i].setFocusable(false);
        }

        panel = new JPanel();
        panel.setBounds(30, 100, 330, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Adding buttons to panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(divButton);

        frame.add(panel);
        clrButton.setBounds(150, 410, 100, 40);
        frame.add(clrButton);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == equalButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/':
                    if (num2 != 0) result = num1 / num2;
                    else {
                        textField.setText("Error");
                        return;
                    }
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
        }
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}