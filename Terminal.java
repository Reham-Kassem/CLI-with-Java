/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectos;

import java.util.Scanner;

/**
 *
 * @author aramg
 * 
 * 
 */


class Parser{
  String commandName;
  String[] args;
    
    
    public boolean parse(String input){
        
  
        this.args = input.split(" ");
        this.commandName = this.args[0];
        for (int i=1;i<this.args.length;i++){
           
            this.args[i-1] = this.args[i];
          
            if(i==this.args.length-1){
                this.args[i]="";
            }
        }
               
       
      return true;
        
    }
    public String getCommandName(){
        
        return this.commandName;
        
    }
    public String[] getArgs(){
        return this.args;
    }
    
}


public class Terminal {
    
    
    
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        Parser pars = new Parser();
      
       
        pars.parse("dbhd disb sdv");
        System.out.println(pars.getCommandName());
        String y[]=pars.getArgs();
        for (int i=0; i<y.length;i++){
            
            System.out.print(y[i]+" ");
            if(i==y.length-1){
                System.out.print(y[i]);
            }
        }
       
        
    }
    
}
