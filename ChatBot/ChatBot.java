import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ChatBot extends JFrame{
  String str = "";
  JPanel panel = new JPanel();
  ImageIcon icon = new ImageIcon("alpaca.jpg");
  JLabel labelicon = new JLabel(icon);
  JLabel label = new JLabel();
  JTextField field = new JTextField(35);
  JButton button = new JButton("Speak to the Alpaca Bot");
  
  public ChatBot(String string){
    str = string;
    //default jframe setup (can call methods from JFrame)
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    setResizable(false);
    setSize(500,500);
    setTitle("Alpaca Bot");
    panel.add(field);
    
    field.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        String str = field.getText();
      }
    });
    
    panel.add(labelicon);
    
    panel.add(button);
    
    //for the button on every click there will be an action performed where the chatbot will read the text and respond with
    //certain strings that contain a key word
    button.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        String str = field.getText();
        if(str.contains("school")){
          ChatBotResponse s = new ChatBotResponse(str);
          label.setText(s.getSchool());
          //else if used for the alpaca not having to say other things
        } else if (str.contains("hello") || str.contains("hi") || str.contains("hola")){
          ChatBotResponse s = new ChatBotResponse(str);
          label.setText(s.getGreetings());
        } else if (str.contains("sister") || str.contains("brother") || str.contains("sibling")){
          if(str.contains("sister")){
            str = "sister";
          } else if(str.contains("brother")){
            str = "brother";
          } else if(str.contains("sibling")){
            str= "sibling";
          }
          ChatBotResponse s = new ChatBotResponse(str);
          label.setText(s.getSibling());
        } else if(str.contains("Bronx")){
          ChatBotResponse s = new ChatBotResponse("the Bronx");
          label.setText(s.getBorough());
        } else if(str.contains("Manhattan")){
          ChatBotResponse s = new ChatBotResponse("Manhattan");
          label.setText(s.getBorough());
        } else if(str.contains("Queens")){
          ChatBotResponse s = new ChatBotResponse("Queens");
          label.setText(s.getBorough());
        } else if(str.contains("Brooklyn")){
          ChatBotResponse s = new ChatBotResponse("Brooklyn");
          label.setText(s.getBorough());
        } else if(testNumber(str)==false && testHex(str)==true){
          DBHConverter h = new DBHConverter(str,0,0,0);
          label.setText(h.getDecimalFromHex(str)+" "+h.getBinaryFromDecimal(h.getDecimalFromHex(str)));
        } else if(testNumber(str)==true && testBinary(str)==false){
          DBHConverter h = new DBHConverter(str,0,0,0);
          int temp = Integer.parseInt(str);
          label.setText(h.getBinaryFromDecimal(temp)+" "+h.getHexFromDecimal(temp));
        } else if(testBinary(str)==true){
          DBHConverter h = new DBHConverter(str,0,0,0);
          int temp = Integer.parseInt(str);
          label.setText(h.getDecimalFromBinary(temp)+" "+h.getHexFromDecimal(h.getDecimalFromBinary(temp)));
        } else {
          //if nothing else goes through, then it will return unknown
          label.setText("I don't understand");
        }
      }
    });
    
    panel.add(label);
    add(panel);
  }
  //try to find the parseInt for the hex tester or else catch an error and return the boolean
  public boolean testHex(String str) {
    boolean bool = false;
    try{
      int temp = Integer.parseInt(str, 16);
      bool = true;
    } catch (NumberFormatException e) {
      bool = false;
    }
    return bool;
  }
  //try to find the parseInt for the number tester or else catch an error and return the boolean
  public boolean testNumber(String str){
    boolean bool = false;
    try{
      int temp = Integer.parseInt(str);
      bool = true;
    } catch (NumberFormatException e) {
      bool = false;
    }
    return bool;
  }
  //while loop to determine a string of 1 and 0s
  public boolean testBinary(String str){
    int temp = Integer.parseInt(str);
    while(temp != 0){
      if(temp%10>1){
        return false;
      }
      temp/=10;
    }
    return true;
  }
  
  public static void main(String args[]){
    new ChatBot("");
  }
}