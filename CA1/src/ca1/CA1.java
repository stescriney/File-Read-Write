/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca1;
import java.io.*;//import java I/O library
import java.util.Scanner;//import scanner

/**
 *
 * @author x18160786
 */
public class CA1 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
  public static void main(String[] args)throws IOException {
        // TODO code application logic here
        
     //creat null objects
     FileWriter myWrite = null;
     FileReader myRead = null;
     BufferedReader bRead = null;
     Scanner sc = null;
     
     
     try{
     
         myWrite = new FileWriter("src/outputCA1.txt");//select destination file for input
         myRead = new FileReader("src/inputCA1backUp.txt");//select destination file for backup
         bRead = new BufferedReader(myRead);//set BufferedReader to send data to backup destination
         sc = new Scanner (System.in);
         
         
         //input
         System.out.println("Please enter name");
         String name = sc.next();
         
         System.out.println("Please enter choice1: A, B, C ");
         String choice1 = sc.next();
         
         System.out.println("Please enter choice2: A, B, C ");
         String choice2 = sc.next();
        
         //ensure all input before throwing exception
         while(name != null && choice1 != null && choice2 != null){
         
             
             //save input in chosen file using FileWriter
             
             myWrite.write(name);
             myWrite.write(choice1);
             myWrite.write(choice2);
             
             //send input to back up file using BufferedReader
             
             name = bRead.readLine();
             choice1 = bRead.readLine();
             choice2 = bRead.readLine();
             
             
             
         }//close while
             
     }//close try
        
     
     catch(IOException e){//catch exception in case of missing input
         
         System.out.println("Exception: Please Complete name and choices");
     
     }//close catch
     
    finally{
     
         if(myRead !=null){
            myRead.close();
         }//close if//close FileReader
     
         myWrite.close();//close FileWriter
         bRead.close();//closeBufferedReader
         
         
         System.out.println("Complete");
     
   }//close finally
     
  }//close main
    
}//close class
