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
     public void echo(String args[]) {
        for (String input : args) {
            System.out.print(input);
        }
    }

    private static File makeFile(String destinationPath) {
        File file = new File(destinationPath);
        if (!file.isAbsolute()) {
            String curPath = getCurrentPath().toString();
            file = new File(curPath, destinationPath);
        }
        return file;
    }

    public static boolean mkdir(String destinationPath) throws Exception {
        File file = makeFile(destinationPath);

        if (destinationPath.length() == 0 || !file.getParentFile().exists())
            throw new Exception(String.format("cannot create directory ‘%s’: No such file or directory", destinationPath));
        if (file.exists())
            throw new Exception(String.format("cannot create directory ‘%s’: File exists", destinationPath));

        try {
            if (!file.mkdir()) return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean rmdir(String destinationPath) throws Exception {
        File file = makeFile(destinationPath);
        if (destinationPath.length() == 0 || !file.exists())
            throw new Exception(String.format("failed to remove '%s': No such file or directory", destinationPath));
        if (!file.isDirectory())
            throw new Exception(String.format("failed to remove '%s': Not a directory", destinationPath));

        try {
            if (!file.delete())
                return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    // REQUIRES: Path must be valid
    // EFFECTS: creates a new file at the given path.
    public static boolean touch(String destinationPath) throws Exception {
        File file = makeFile(destinationPath);
        if (destinationPath.length() == 0 || !file.getParentFile().exists())
            throw new Exception(String.format("cannot touch '%s': No such file or directory", destinationPath));

        try {
            if (!file.createNewFile()) return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // REQUIRES: Path must be valid
    // EFFECTS: returns a list of files and folders inside the current path.
    public static File[] ls() {
        File file = new File(getCurrentPath().toString());
        return file.listFiles();
    }  
        
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
