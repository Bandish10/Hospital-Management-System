//The main fuction of this class is that it handles all editorial functions
import java.io.*;
import java.util.*;
class Make
{
     private static String tab="\t\t\t\t\t\t";
     private static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     public static void line()      //method to draw lines
     {
          for(int i=0;i<=200;i++)
               System.out.print("=");   //drawing a line()
          System.out.println("");
     }//end of line()

     public static void wish()      //method to print goodbye messages
     {
          System.out.print('\u000C');
          line();
          System.out.println(tab+"HAVE A GOOD DAY !!");
          line();
          time();     //time loop
     }//end of wish()

     public static void error()     //method to print error messages
     {
          System.out.print('\u000C');
          line();
          System.out.println(tab+"INVALID CHOICE !!");
          line();
          time();     //delay loop
     }//end of error()

     public static String align(String s,int n)    //method which adds spaces to data to make them of the same length
     {
          String t=s;
          for(int i=t.length();i<n;i++)
               t+=" ";    //adding spaces
          return t;
     }//end of align()

     public static void time()      //function to delay operations
     {
          for(long i=-999999999l;i<9999999l;i++)    //delay loop
          {
          }//end of for()
     }//end of time()

     public static void bill(String rec)throws IOException        //method to print bills
     {
          Calendar c1=Calendar.getInstance();     //using calender class
          System.out.print('\u000C');     //clear screen
          //input
          System.out.println("Enter name of the patient  ... ");
          String nc=br.readLine();
          //bill printing
          System.out.print('\u000C');            //clearscreen
          String Billno=String.valueOf((long)(Math.random()*10000000000l)+1);     //generating bill no.
          StringTokenizer st=new StringTokenizer(rec,"#");
          String docid=st.nextToken();
          String nb=st.nextToken();
          String age=st.nextToken();
          String qual=st.nextToken();
          String fees=st.nextToken();
          line();
          System.out.println(tab+"BILL");
          line();
          System.out.println("BILL.No - "+Billno+tab+" Patient Name - "+nc+"\n");
          line();
          System.out.println("Date of Purchase -    "+tab+c1.get(Calendar.DATE)+"/"+(c1.get(Calendar.MONTH)+1)+"/"+c1.get(Calendar.YEAR));
          System.out.println("DOCTOR ID -                "+tab+docid);
          System.out.println("Name of the Doctor -    "+tab+nb);
          System.out.println("Age -                  "+tab+age);
          System.out.println("Qualification -              "+tab+qual);
          System.out.println("");
          System.out.println("Net Total -           "+tab+fees);
          line();
          time();
          System.out.println("Press Enter to continue  ...");
          br.readLine();
     }//end of bill()

     public static void reciept(String rec)throws IOException
     {
          Calendar c1=Calendar.getInstance();     //using calender class
          System.out.print('\u000C');     //clear screen
          //input
          System.out.println("Enter name of the Patient  ... ");
          String nc=br.readLine();
          //printing reciept
          System.out.print('\u000C');   //clear screen
          String Billno=String.valueOf((long)(Math.random()*10000000000l)+1);   //generating reciept number
          StringTokenizer st=new StringTokenizer(rec,"#");
          String docid=st.nextToken();
          String nb=st.nextToken();
          String age=st.nextToken();
          String qual=st.nextToken();
          String fees=st.nextToken();
          line();
          System.out.println(tab+"ISSUE RECIEPT");
          line();
          System.out.println("BILL.No - "+Billno+tab+" Patient Name - "+nc+"\n");
          line();
          System.out.println("Date of Appointment-      "+tab+c1.get(Calendar.DATE)+"/"+(c1.get(Calendar.MONTH)+1)+"/"+c1.get(Calendar.YEAR));
          System.out.println("DOCTOR ID -                "+tab+docid);
          System.out.println("Name of the Doctor -    "+tab+nb);
          System.out.println("Age -                 "+tab+age);
          System.out.println("Qualification -              "+tab+qual);
          System.out.println("Net Total -               "+tab+fees);
          line();
          time();
          System.out.println("Press Enter to continue  ...");
          br.readLine();
     }//end  of reciept()
}//end of class Make