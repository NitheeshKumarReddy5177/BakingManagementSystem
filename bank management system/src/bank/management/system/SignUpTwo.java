
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SignUpTwo extends JFrame implements ActionListener{
    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, income, occupation, education;
    String formno;
    SignUpTwo(String formno){
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION - PAGE 2");
        setLayout(null);
 
        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 28));
        additionalDetails.setBounds(270, 80, 400, 35);
        add(additionalDetails);

        JLabel name = new JLabel("Religion :");
        name.setFont(new Font("Raleway", Font.BOLD, 18));
        name.setBounds(110, 140, 100, 30);
        add(name);
        
//        nameTextField = new JTextField();
//        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
//        nameTextField.setBounds(300, 140, 400, 30);
//        add(nameTextField);
        
        String religionArr[]={"Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(religionArr);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel fname = new JLabel("Category :");
        fname.setFont(new Font("Raleway", Font.BOLD, 18));
        fname.setBounds(110, 190, 200, 30);
        add(fname);
        
        String categoryArr[]={"General", "OBC","SC","ST","Other"};
        category = new JComboBox(categoryArr);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel dob = new JLabel("Income :");
        dob.setFont(new Font("Raleway", Font.BOLD, 18));
        dob.setBounds(110, 240, 200, 30);
        add(dob); 
        
        String incomeArr[]={"Null","< 1,50,000", "< 2,50,000","< 5,00,000","Upto 10,00,000"};
        income = new JComboBox(incomeArr);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway", Font.BOLD, 18));
        gender.setBounds(110, 290, 200, 30);
        add(gender);
        
        JLabel email = new JLabel("Qualification :");
        email.setFont(new Font("Raleway", Font.BOLD, 18));
        email.setBounds(110, 315, 200, 30);
        add(email);
        
        String educationArr[]={"Non-Graduation","Graduate", "Post-Graduation","Doctrate","Other"};
        education = new JComboBox(educationArr);
        education.setBounds(300, 310, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);
      

        JLabel maritial = new JLabel("Occupation :");
        maritial.setFont(new Font("Raleway", Font.BOLD, 18));
        maritial.setBounds(110, 360, 200, 30);
        add(maritial);
        
        String ocuupationArr[]={"Salaried","Self Employed", "Busssiness","Student","Retired","Other"};
        occupation = new JComboBox(ocuupationArr);
        occupation.setBounds(300, 360, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
              
        
        JLabel address = new JLabel("PAN Number :");
        address.setFont(new Font("Raleway", Font.BOLD, 18));
        address.setBounds(110, 440, 200, 30);
        add(address);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);
        
        
        JLabel city = new JLabel("Aadhar Number :");
        city.setFont(new Font("Raleway", Font.BOLD, 18));
        city.setBounds(110, 490, 200, 30);
        add(city);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);
        
        JLabel state = new JLabel("Senior Citizen :");
        state.setFont(new Font("Raleway", Font.BOLD, 18));
        state.setBounds(110, 540, 200, 30);
        add(state);
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 120, 30);
        sno.setBackground(Color.WHITE);
        add(sno);   
        
        ButtonGroup seniorCitizenGroup = new ButtonGroup();
        seniorCitizenGroup.add(syes);
        seniorCitizenGroup.add(sno);
        
        JLabel pincode = new JLabel("Existing Account :");
        pincode.setFont(new Font("Raleway", Font.BOLD, 18));
        pincode.setBounds(110, 590, 200, 30);
        add(pincode);
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 80, 30);
        eno.setBackground(Color.WHITE);
        add(eno);   
        
        ButtonGroup existingAccountGroup = new ButtonGroup();
        existingAccountGroup.add(eyes);
        existingAccountGroup.add(eno);
        
        
        JButton next = new JButton("Next..");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 20));
        next.setBounds(620, 660, 100, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String sreligion =(String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorCitizen = null;
        if(syes.isSelected()){
            seniorCitizen="YES";
        }else if(sno.isSelected()){
            seniorCitizen = "No";          
        }
        String existingAccount = null;
        if(eyes.isSelected()){
            existingAccount = "Married";
        }else if(eno.isSelected()){
            existingAccount = "Unmarried";
        }
        String span = pan.getText();
        String saadhar = aadhar.getText();
        try{
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorCitizen+"','"+existingAccount+"')";
                c.s.executeUpdate(query);
                //SignUP 3 Object 
                setVisible(false);
                new SignUpThree(formno).setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args){
        new SignUpTwo("");
    }
    
}
