package ard;

import java.lang.*;
import javax.swing.*;
import java.util.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import jssc.SerialPort;
import jssc.*;
import java.lang.*;

public class ARD {

    public static SerialPort SP1;
    private JButton HIGH;
    private JButton LOW;
    private JFrame Frame;
    boolean tH= false;
    boolean tL= false;    
    public ARD(){
    
    run();
    }
    
     public static void main(String[] args) {
      ARD DEMO= new ARD();
    }
    
     public void run(){
         Frame = new JFrame("ARD");
         Frame.setSize(200,200);
         Frame.setLayout(new FlowLayout());     
     SP1 = new SerialPort("COM7");
     HIGH= new JButton("HIGH");
     LOW= new JButton("LOW");

    HIGH.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent e) {
          
      tH=true;
      tL=false;
      System.out.println("HIGH");
          }});
       
      LOW.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent e) {
            tH=false;
            tL=true;
       System.out.println("LOW");     
          }});
     
      try{
        SP1.openPort();
     SP1.setParams(115200,8,1,0);
     
     if(tH){
      /*   
      if(SP1.getInputBufferBytesCount()>0){
       String data = SP1.readString();
       System.out.println(data);}
      else SP1.writeString("1");*/
      SP1.writeInt(1);
     }
        
    if(tL){
     /*    
      if(SP1.getInputBufferBytesCount()>0){
       String data = SP1.readString();
       System.out.println(data);}
      else SP1.writeString("2");*/
     
     SP1.writeInt(2);  
    } 
     
 }catch(SerialPortException ex){} 
      
      Frame.add(HIGH);
      Frame.add(LOW);
      Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setVisible(true);
     }
    
    
   public static class PortW implements SerialPortEventListener{
   
        public void serialEvent(SerialPortEvent event){
         
            if(event.isRXCHAR()&&event.getEventValue()>0){
            try{
       
          String data = SP1.readString(event.getEventValue());
          System.out.println(data);
       
           }
            catch(SerialPortException ex){}
            }
        }
   }  
   
}
