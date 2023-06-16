/*This class acts as the main starting point of the software. It initiates the software by 
calling for the admin and user login accounts */
import java.util.*;
import java.io.*;
class MainSystem
{
     private static String tab="\t\t\t\t\t\t";
     //this function shows the menu to the user and calls for other methods as per the ussers choice
     public static void main(String args[])throws IOException
     {
          int i,j,c;
          Scanner sc=new Scanner(System.in);
          //displaying head page
          System.out.println("\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t\t\tHOSPITAL MANAGEMENT SYSTEM\n\n");
          System.out.println(tab+"\tDeveloped by BANDISH BHATTACHARYYA .\n\n\n\n\n");
          Make.time();     //time delay   
          while(true)
          {
               do
               {
                    disp();
                    //input
                    System.out.println(tab+"Enter your choice ....(1-3)");
                    c=sc.nextInt();
                    
                    if(c!=1 && c!=2 && c!=3) //handling invalid inputs
                         Make.error();
               }while(c!=1 && c!=2 && c!=3);
               //end of do-while()
               switch(c)
               {
                    case 1:
                    Admin.main();//method call
                    break;
                    
                    case 2:
                    Receptionist.main();   //method call
                    break;
                    
                    case 3:
                    Make.wish();   //goodbye message
                    System.exit(0);     //terminating program
               }//end of switch-case()
          }//end of for()
     }//end of main()
     //this method displays the main menu
     public static void disp()
     {
          System.out.println('\u000C');      //clearscreen
          Make.line();
          System.out.println(tab+"MENU");
          Make.line();
          System.out.println(tab+"1    -      ADMIN LOGIN .");
          System.out.println(tab+"2    -      RECEPTIONIST LOGIN .");
          System.out.println(tab+"3    -      EXIT .");
          Make.line();
     }//end of disp()
}//end of class MainSystem