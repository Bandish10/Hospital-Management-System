/*This class handles all operations related to the busylist*/
import java.io.*;
import java.util.*;
class Busylist
{
     private static String tab="\t\t\t\t\t\t";
     private static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     //method to display the busy list
     public static void display()throws IOException
     {
          System.out.print('\u000C');   //clear screen
          BufferedReader brf=new BufferedReader(new FileReader("Busylist.txt"));
          String rec="";
          int c=0;
          //displaying busylist
          Make.line();
          System.out.println(tab+"BUSY DOCTORS");
          Make.line();
          System.out.println("SL.NO\tDOCTOR ID      \tNAME                                              \tAGE               \tQUALIFICATION                 \tFEES \tSPECIALITY");
          Make.line();

          while((rec=brf.readLine())!=null)//reading files
               printRec(rec,++c);     //printing records

          if(c==0)//checking for an empty file
          {
               System.out.println("No Busy Doctors");
               Make.line();
               Make.time();     //delay
               return;
          }//end of if

          Make.line();
          brf.close();
          Make.time();     //delay
          System.out.println("Press Enter to continue ...");
          br.readLine();
     }
     //method for removing an appointment
     public static void ret()throws IOException
     {
          System.out.print('\u000C');   //clear screen
          BufferedReader brf=new BufferedReader(new FileReader("Busylist.txt"));
          String rec="";
          int c=0;
          //displaying busylist
          Make.line();
          System.out.println(tab+"REMOVE AN APPOINTMENT");
          Make.line();
          System.out.println(tab+"BUSY DOCTORS");
          Make.line();
          System.out.println("SL.NO\tDOCTOR ID       \tNAME                                              \tAGE              \tQUALIFICATION                \tFEES \tSPECIALITY");
          Make.line();

          while((rec=brf.readLine())!=null)//reading files
               printRec(rec,++c);          //printing records

          if(c==0)    //checking for empty files
          {
               System.out.println("No Busy Doctors");
               Make.line();
               Make.time();     //delay
               return;
          }//end of if

          Make.line();
          brf.close();
          //input
          System.out.println("Enter the Appointment which you wish to remove ...(sl.no)");
          int sl=Integer.parseInt(br.readLine());

          if(sl<1 || sl>c)//handling exceptions
          {
               Make.error();     //displaying error messsage
               return;//time loop
          }//end of if

          remove(sl-1,c);       //method call
          //displaying succes message
          System.out.print('\u000C');   //clear screen
          Make.line();
          System.out.println(tab+"Doctor Successfully Removed!!");
          Make.line();
          Make.time();     //delay
     }//end of ret()
     //method to remove records
     public static void remove(int choice,int lim)throws IOException
     {
          int i;
          StringTokenizer st=new StringTokenizer("");
          String n[]=new String[lim];
          BufferedReader brf=new BufferedReader(new FileReader("Busylist.txt"));

          for(i=0;i<lim;i++)              //reading file        
               n[i]=brf.readLine();        //storing records in array
          brf.close();
          //separating ids and offiial records
          String rec=n[choice];
          String gen=rec.substring(rec.lastIndexOf("#")+1);
          String data=rec.substring(0,rec.lastIndexOf("#"));
          
          Doctorlist.append(data,gen);         //adding book to busylist
          //rewriting the file without the removed record
          PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("Busylist.txt")));
          for(i=0;i<lim;i++)
          {
               if(i==choice)
                    continue;
               else
                    pw.println(n[i]);
          }//end of for()
          pw.close();
     }//end of remove()
     //method to print records
     public static void printRec(String rec,int i)
     {
          StringTokenizer st=new StringTokenizer(rec,"#");
          //tokenizing records
          String docid=st.nextToken();
          String nb=st.nextToken();
          String age=st.nextToken();
          String qual=st.nextToken();
          int price=Integer.parseInt(st.nextToken());
          String spec=st.nextToken();
          //printing records
          System.out.println(i+".   \t"+docid+"\t"+nb+"\t"+age+"\t"+qual+"\t"+price+"   \t"+spec);
     }//end of printRec()
     //method to add to busylist
     public static void add(String rec)throws IOException
     {
          PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("Busylist.txt",true)));
          pw.println(rec);    //writing records
          pw.close();
     }//end of add()
     //method to check whether a book is present in the borrowlist or not
     public static boolean check(String x)throws IOException
     {
          boolean flag=false;
          BufferedReader brf=new BufferedReader(new FileReader("Busylist.txt"));
          String rec="";
          
          while((rec=brf.readLine())!=null)  //reading files
          {
               StringTokenizer st=new StringTokenizer(rec,"#");
               //tokenizing records
               String docid=st.nextToken();
               String nb=st.nextToken();
               String age=st.nextToken();
               String qual=st.nextToken();
               int fees=Integer.parseInt(st.nextToken());
               String gen=st.nextToken();
               
               if(nb.trim().equals(x))//checking for the doctor name
               {
                    flag=true;
                    System.out.print('\u000C');   //clear screen
                    //displaying success message
                    Make.line();
                    System.out.println("The Book Is Issued By A User !! ");
                    Make.line();
                    System.out.println("\n\n ISBN - "+docid+"\n Genre - "+gen);
                    Make.line();
                    Make.time();     //delay
                    break;
               }//end of if
          }//end of for()
          brf.close();
          return flag;
     }//end of check()
}//end of class