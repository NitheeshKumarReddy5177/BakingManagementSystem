
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    
    JButton back;
    String pinnumber;
    
    BalanceEnquiry(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        
        // Load background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        // Back button
        back = new JButton("BACK");
        back.setBounds(360, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        // Retrieve balance from database
        int balance = 0;
        Conn c = new Conn();
        try {
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinnumber + "'");
            while (rs.next()) {
                int amount = Integer.parseInt(rs.getString("amount"));
                if (rs.getString("type").equals("Deposit")) {
                    balance += amount;
                } else { 
                    balance -= amount;
                } 
            }
            
            // Close resources
            rs.close();
            c.s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        // Display balance on the GUI
        JLabel text = new JLabel("Your Current Account Balance is : " + balance);
        text.setBounds(170, 300, 400, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 15));
        image.add(text);
        
        // Frame settings
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(true);
        new Transactions(pinnumber).setVisible(true);
    }
    
    public static void main(String[] args) {
        new BalanceEnquiry("123456"); // Replace with an actual pinnumber
    }
}
