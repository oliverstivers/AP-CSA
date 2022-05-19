import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import java.awt.Font;

import javax.swing.*;

import java.awt.event.*;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
public class MyFrame extends JFrame implements ActionListener{
    JTextField textField;
    JButton convert;
    @SuppressWarnings("rawtypes")
    JComboBox from;
    @SuppressWarnings("rawtypes")
    JComboBox to;
    JLabel label3;
    GridBagConstraints gbc = new GridBagConstraints();
    MyFrame(){
        
        this.setLayout(new GridBagLayout());
        this.setSize(800, 500); 
        this.setVisible(true);
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.setTitle("Currency Converter");
        this.setResizable(false);
        ImageIcon image = new ImageIcon("src/money.png");
        this.setIconImage(image.getImage());
        

        JLabel label = new JLabel();
        label.setForeground(new Color(255, 255, 255));
        label.setFont(new Font("Roboto", Font.PLAIN, 20));
        label.setSize(300, 300);
        label.setText("Welcome to the currency converter!");
        
        
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250, 40));
        textField.setText("start amount");
        textField.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            if (textField.getText().equals("start amount")) {
                textField.selectAll();
            }
        }

        });
        textField.setFont(new Font("Roboto", Font.PLAIN, 18));
        textField.setBackground(new Color(145, 148, 150));
        textField.setForeground(Color.white);
        textField.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        

        convert = new JButton("Convert");
        convert.addActionListener(this);
        
        
        String[] currency = {"Yen", "Euro", "Pound", "CAD", "USD"};
        from = new JComboBox<String>(currency);
        
        to = new JComboBox<String>(currency);
        
        convert.setSize(100, 40);
        
        JLabel label2 = new JLabel();
        label2.setText("to");
        label2.setFont(new Font("Roboto", Font.PLAIN, 15));
        label2.setForeground(new Color(255, 255, 255));
        label3 = new JLabel();
        
        label3.setFont(new Font("Roboto", Font.PLAIN, 15));
        label3.setForeground(new Color(255, 255, 255));
        gbc.gridx = 0;
        gbc.gridy = 0;
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(49, 50, 51));
        p1.setLayout(new GridBagLayout());
        
       JPanel p2 = new JPanel();
        p2.setBackground(new Color(49, 50, 51));
        p2.setLayout(new GridBagLayout());

        p1.add(label, gbc);
        p2.add(textField, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        p2.add(from, gbc);
        gbc.gridx = 2;
        p2.add(label2, gbc);
        gbc.gridx = 3;
        p2.add(to, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 5;
        p2.add(convert, gbc);
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(p1, gbc);
        gbc.gridy = 1;
        this.add(p2, gbc);
        this.getContentPane().setBackground(new Color(49, 50, 51));
        
        this.pack();
        this.setSize(800, 500);
    }  
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == convert){
            double converted = Converter.convert(from.getSelectedItem().toString().toUpperCase(),
            to.getSelectedItem().toString().toUpperCase(), Double.parseDouble(textField.getText())
            );
            String output = "" + converted;
            switch(to.getSelectedItem().toString().toUpperCase()){
                case "EURO":
                    output = "€" + output;
                    break;
                case "YEN": 
                    output = "¥" + output;
                    break;
                case "USD":
                    output = "$" + output;
                    break;
                case "POUND":
                    output = "£" + output;
                    break;
                case "CAD":
                    output = "CAD$" + output;
                    break;
            }
            label3.setText(output);
        }
    } 
}
