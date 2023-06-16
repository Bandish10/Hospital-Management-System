/*This class Handles all operations related to the admin*/
import java.util.*;
import java.io.*;
class Admin
{
     private static String tab="\t\t\t\t\t\t";
     private static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     //Admin username and pasword stored in private variables
     private static String na="admin1",pa="1234567";
     //method for getting user's choice and invoke methods accordingly
     public static void main()throws IOException 
     {
          //admin login
          if(login()==false)
               return;   //returning to main menu

          while(true)
          {
               dispMenu();    //displaying menu
               System.out.println(tab+"Enter your choice ...");
               switch(Integer.parseInt(br.readLine()))
               {
                    case 1:
                    addRecep(); //method call
                    break;

                    case 2:
                    remRecep(); //method call
                    break;

                    case 3:
                    dispRecep();     //method call
                    break;

                    case 4:
                    Doctorlist.display(); //method call
                    break;

                    case 5:
                    Busylist.display();    //method call
                    break;

                    case 6:
                    Make.wish();   //printing goodbye message
                    return;

                    default:
                    Make.error();  //printing error messages for exceptions
                    Make.time();     //delay
               }//end of switch-case()
          }//end of while()
     }//end of main()
     //method to add Receptionist
     public static void addRecep()throws IOException
     {
          int i;
          System.out.print('\u000C');     //clear screen
          Make.line();
          System.out.println(tab+"ADD RECEPTIONIST");
          Make.line();
          //Input
          System.out.println("Enter the name of the RECEPTIONIST ...");
          String nl=br.readLine();
          nl=Make.align(nl,30);         //aligning name
          System.out.println("Enter Unique Id ...(7 digits)");
          String ul=br.readLine();
          ul=Make.align(ul,10);         //aligning unique id 
          System.out.println("Enter password ...");
          String pl=br.readLine();
          //writing to Receptionist file
          PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("Receptionist.txt",true)));
          pw.println(nl+"#"+ul+"#"+pl);
          pw.close();
          //success message
          System.out.print('\u000C');     //clear screen
          Make.line();
          System.out.println(tab+"RECEPTIONIST Succesfully Added !!!");
          Make.line();
          Make.time();     //delay
     }//end of addRecep()
     //method to remove Receptionists
     public static void remRecep()throws IOException
     {
          System.out.print('\u000C');     //clear screen
          Make.line();
          System.out.println(tab+"REMOVE RECEPTIONIST ");
          Make.line();
          StringTokenizer st=new StringTokenizer("");
          //counting number of records 
          BufferedReader br1=new BufferedReader(new FileReader("Receptionist.txt"));
          int c=0,choice=0,i;
          while(br1.readLine()!=null)
               ++c;

          if(c==0)  //checking for emptyfiles
          {
               System.out.println("No Receptionists Present !!!");
               Make.line();
               Make.time();     //delay
               return;
          }//end of if

          br1.close();
          String n[]=new String[c];
          String record="";
          //displaying list of librarian
          Make.line();
          System.out.println(tab+"LIST OF RECEPTIONISTS");
          Make.line();
          System.out.println("Sl.No\tNAME                          \tUNIQUE ID \t PASSWORD");
          Make.line();
          BufferedReader brf=new BufferedReader(new FileReader("Receptionist.txt"));
          for(i=0;i<c;i++)        //displaying records
          {
               n[i]=brf.readLine();     //adding records to array
               printRec(n[i],i+1);
          }//end of for()
          Make.line();
          System.out.println("\n\n\n\n\n");
          brf.close();

          System.out.println("Enter Sl.no u want to delete ...");     //input
          choice=Integer.parseInt(br.readLine());
          if(choice<1 || choice>c) //handling exceptions
          {
               Make.error();  //printing error message
               return;
          }
          choice--;
          //rewriting file
          PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("Receptionist.txt")));
          for(i=0;i<c;i++)
          {
               if(i==choice)
                    continue;
               else
                    pw.println(n[i]);
          }//end of for()
          pw.close();
          //displaying successs message
          System.out.print('\u000C');     //clear screen
          Make.line();
          System.out.println(tab+"Receptionist Succesfully Removed !!!");
          Make.line();
          Make.time();     //delay
     }//end of remRecep()
     //method to display the receptionist list
     public static void dispRecep()throws IOException
     {
          System.out.print('\u000C');     //clear screen
          StringTokenizer st=new StringTokenizer("");
          BufferedReader brf=new BufferedReader(new FileReader("Receptionist.txt"));
          String record="";
          Make.line();
          System.out.println(tab+"LIST OF RECEPTIONISTS");
          Make.line();
          System.out.println("Sl.No\tNAME                          \tUNIQUE ID \t PASSWORD");
          Make.line();
          int c=0;
          
          while((record=brf.readLine())!=null)    //printing records
               printRec(record,++c);
          
          if(c==0)//checking for empty files
          {
               System.out.println("No Receptionist Present !!!");
               Make.line();
               Make.time();     //delay
               return;
          }
          Make.line();
          System.out.println("\n\n\n\n\n");
          brf.close();
          Make.time();     //delay
          System.out.println("Press Enter key to go back ...");
          br.readLine();
     }//end of dispRecep()
     //method to print records
     private static void printRec(String s,int i)
     {
          StringTokenizer st=new StringTokenizer(s,"#");
          //tokenizing strings
          String nl=st.nextToken();
          String ul=st.nextToken();
          String pl=st.nextToken();
          System.out.println(i+".   \t"+nl+"\t"+ul+"\t"+pl);
     }//end of printRec()
     //method for the admin login
     private static boolean login()throws IOException
     {
          //Input
          System.out.print('\u000C');     //clear screen
          Make.line();
          System.out.println(tab+"\t\tADMIN LOGIN");
          Make.line();
          System.out.println("Enter username ...");
          String a=br.readLine();
          System.out.println("Enter password ...");
          String b=br.readLine();
          //checking if the input is correct
          if(a.equals(na)==false || b.equals(pa)==false)
          {
               System.out.print('\u000C');     //clear screen
               Make.line();
               System.out.println(tab+"INVALID USERNAME OR PASSOWORD");
               Make.line();
               Make.time();     //delay
               return false;
          }
          else
               return true;
     }//end of login()
     //method to display the admin menu
     private static void dispMenu()
     {
          System.out.print('\u000C');     //clear screen
          Make.line();
          System.out.println(tab+"WELCOME ADMIN !!!");
          Make.line();
          System.out.println(tab+"\t\tMENU");
          Make.line();
          System.out.println(tab+"1   -    Add Receptionist");
          System.out.println(tab+"2   -    Remove Receptionist");
          System.out.println(tab+"3   -    Display Receptionist List");
          System.out.println(tab+"4   -    Display Doctor list");
          System.out.println(tab+"5   -    Display Busy list");
          System.out.println(tab+"6   -    LOGOUT");
          Make.line();
     }//end of dispMenu()
}//end of class