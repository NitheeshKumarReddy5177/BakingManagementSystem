
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class MiniStatement extends JFrame implements ActionListener{
    String pinnumber;
    MiniStatement(String pinnumber){
        
        setTitle("Mini Statememt");
        
        setLayout(null);
        JLabel mini = new JLabel("");
//        text.setBounds(170, 300, 400, 30);
//        text.setForeground(Color.WHITE);
//        text.setFont(new Font("System", Font.BOLD, 15));
        add(mini);
        
        JLabel bank = new JLabel("Smart Bank");
        bank.setBounds(130, 10, 200, 100);
//        bank.setForeground(Color.WHITE);
        bank.setFont(new Font("System", Font.BOLD, 18));
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20, 100, 300, 30);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);
        
//        
        try{
            
         Conn conn = new Conn();
        ResultSet rs = conn.s.executeQuery("SELECT * FROM login WHERE pin = '" + pinnumber + "'");
//         ResultSet rs = conn.s.executeQuery("SELECT * FROM login WHERE pin = '6203'");
        
        while (rs.next()){
            card.setText("Card Number : "+rs.getString("cardnumber").substring(0,4)+ "XXXXXXXX"+rs.getString("cardnumber").substring(12));
        }
        }catch (Exception e){
            System.out.println(e);
        }
        
        try{
            Conn conn = new Conn();
            int bal =0;
            ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinnumber + "'");
//            ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE pin = '6203'");
          
            while (rs.next()){
                mini.setText(mini.getText()+ "<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("amount")+"<br><br><html>");          
                if(rs.getString("type").equals("Deposit")){
                       bal += Integer.parseInt(rs.getString("amount"));
                }else{ 
                       bal -=Integer.parseInt(rs.getString("amount"));
                } 
            }
            balance.setText("Your Current Account Balance is Rs "+bal);
        }catch(Exception e){
            System.out.println(e);
        }
        mini.setBounds(20, 140, 400, 300);
        
        setSize(450, 600);
        setLocation(20, 20);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    
    
    public void actionPerformed(ActionEvent ae) {
//        setVisible(true);
//        new Transactions(pinnumber).setVisible(true);
    }
    public static void main(String[] args){
        new MiniStatement("");
        
    }
    
}
