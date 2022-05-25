import java.awt.Color;


import java.awt.Dimension;

import java.awt.Font;

import javax.swing.*;

import java.awt.event.*;
import java.io.IOException;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;

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
        this.setSize(475, 350); 
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
        label.setSize(300, 5);
        label.setText("Welcome to the currency converter!");
        
        
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(150, 30));
        textField.setText("start amount");
        textField.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            if (textField.getText().equals("start amount")) {
                textField.selectAll();
            }
        }

        });
        textField.setFont(new Font("Roboto", Font.PLAIN, 18));
        textField.setBackground(new Color(49, 50, 51));
        textField.setForeground(Color.white);
        textField.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        textField.setCaretColor(Color.white);

        convert = new JButton("Convert");
        convert.addActionListener(this);
        
        
        String[] currency = {"JPY", "EUR", "GBP", "CAD", "USD"};
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
        gbc.insets = new Insets(0, 10, 10, 10);
        gbc.anchor = GridBagConstraints.PAGE_START;
        

        p1.add(label, gbc);
        gbc.insets = new Insets(50, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.ipady = 0;
        p2.add(textField, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        p2.add(from, gbc);
        gbc.gridx = 2;
        gbc.insets = new Insets(50, 0, 10, 0);
        p2.add(label2, gbc);
        gbc.gridx = 3;
        gbc.insets = new Insets(50, 10, 10, 0);
        p2.add(to, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 4;
        gbc.ipady = 40;
        gbc.insets = new Insets(0, 0, 0, 0);
        p2.add(convert, gbc);
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.fill = GridBagConstraints.NONE;
        gbc.ipady = 0;
        gbc.ipadx = 0;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        p2.add(label3, gbc);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(p1, gbc);
        gbc.gridy = 1;
        this.add(p2, gbc);
        this.getContentPane().setBackground(new Color(49, 50, 51));
        
        this.pack();
        this.setSize(475, 350);
    }  
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == convert){
            double converted = 0;
            try {
                converted = Converter.convert(from.getSelectedItem().toString().toUpperCase(),
                to.getSelectedItem().toString().toUpperCase(), Double.parseDouble(textField.getText())
                );
            } catch (NumberFormatException | IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            String output = "" + converted;
            switch(to.getSelectedItem().toString().toUpperCase()){
                case "EUR":
                    output = "€" + output;
                    break;
                case "JPY": 
                    output = "¥" + output;
                    break;
                case "USD":
                    output = "$" + output;
                    break;
                case "GBP":
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
