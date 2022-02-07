
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


public class Test {
  
    public static SerialPort SP1;
    
    
    public Test(){
    
    run();
    }
    
     public static void main(String[] args) {
      Test DEMO= new Test();
    }
    
     public void run(){
     SP1 = new SerialPort("COM7");

     
     try{
        SP1.openPort();
     SP1.setParams(115200,8,1,0);
     while(true){
         
      if(SP1.getInputBufferBytesCount()>0){
       String data = SP1.readString();
       System.out.println(data);}
      else SP1.writeString("1");
     }}catch(SerialPortException ex){}=   
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
