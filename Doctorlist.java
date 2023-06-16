import java.util.*;
import java.io.*;
class Doctorlist
{
     private static String tab="\t\t\t\t\t\t";
     private static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     //array to store specialities
     private static String n[]={"Cardiologist","Neurologist","ENT","Orthopaedic","Dentist","General"};
     //method to display the doctorlist
     public static void display()throws IOException
     {
          System.out.print('\u000C');     //clear screen
          Make.line();   Make.line();
          System.out.println("\n"+tab+"LIST OF DOCTORS\n");
          Make.line();   Make.line();
          //loop to print all specialities
          for(int i=0;i<n.length;i++)
          {
               BufferedReader brf=new BufferedReader(new FileReader(n[i]+".txt"));

               if(brf.readLine()==null)    //checking for empty files
               {
                    brf.close();
                    continue;
               }

               brf.close();
               Make.line();
               System.out.println(tab+n[i]);
               Make.line();
               System.out.println("SL.NO\tIDOCTOR ID      \tNAME                                            \tAGE              \tQUALIFICATION\tFEES");
               Make.line();
               BufferedReader brf2=new BufferedReader(new FileReader(n[i]+".txt"));
               String rec="";
               int c=1;
               //printing records
               while((rec=brf2.readLine())!=null)
                    printRec(rec,c++);

               Make.line();
               brf2.close();
          }//end of for()
          Make.time();     //delay
          System.out.println("\n\n\n\n Press Enter key to continue ...");
          br.readLine();
     }//end of display()
     //method to print records
     private static void printRec(String s,int i)
     {
          StringTokenizer st=new StringTokenizer(s,"#");
          //tokenizing records
          String docid=st.nextToken();
          String nb=st.nextToken();
          String age=st.nextToken();
          String qual=st.nextToken();
          String fees=st.nextToken();
          //printing records
          System.out.println(i+".   \t"+docid+"\t"+nb+"\t"+age+"\t"+qual+"\t"+fees);
     }//end of printRec()
     //method to add books to the doctorlist
     public static void add()throws IOException
     {
          String gen="";
          System.out.print('\u000C');     //clear screen
          dispSpec();     //display list of specialities
          //input
          System.out.println("Enter The Speciality to which you want to add a Doctor ...(sl.no)");
          int choice=Integer.parseInt(br.readLine());

          if(choice<1 || choice >n.length)//checking for excptions
          {
               Make.error();     //displaying error message
               return;
          }
          else
               gen=n[choice-1];  
          //input
          System.out.print('\u000C');     //clear screen
          Make.line();
          System.out.println(tab+"ADD A DOCTOR");
          Make.line();
          System.out.println("Enter the DOCTOR ID of the DOCTOR ...(10 digits)");
          String docid=br.readLine();
          docid=Make.align(docid,10);     //aligning data
          System.out.println("Enter the name of the DOCTOR ...");
          String nb=br.readLine();
          nb=Make.align(nb,50);         //aligning data
          System.out.println("Enter the AGE ...");
          String age=br.readLine();
          age=Make.align(age,25);         //aligning data
          System.out.println("Enter the QUALIFICATION ...");
          String qual=br.readLine();
          age=Make.align(age,25);         //aligning data
          System.out.println("Enter fees ...");
          int fees=Integer.parseInt(br.readLine());

          String rec=docid+"#"+nb+"#"+age+"#"+qual+"#"+fees;   //generating record

          append(rec,gen);//appending record to doctorlist
          //displaying success message
          System.out.print('\u000C');     //clear screen
          Make.line();
          System.out.println(tab+"Doctor Successfully Added !!");
          Make.line();
          Make.time();     //delay
     }//end of add()
     //method to append records to the doctorlist
     public static void append(String rec,String f)throws IOException
     {
          f=f+".txt";
          PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter(f,true)));
          pw.println(rec);    //writing records
          pw.close();
     }//end of append
     //method to remove records from the doctorist
     public static void remove()throws IOException
     {
          System.out.print('\u000C');     //clear screen
          dispSpec();        //displaying speciality list
          //input
          System.out.println("Enter the Speciality from which you wish to remove the Doctor ...(sl.no)");
          int choice=Integer.parseInt(br.readLine()),c=0;

          if(choice>n.length || choice <1)        //checking for exceptions
          {
               Make.error();     //displaying error message
               return;
          }//end of if

          System.out.print('\u000C');     //clear screen
          Make.line();
          String rec="";
          BufferedReader brf=new BufferedReader(new FileReader(n[choice-1]+".txt"));
          //displaying list of books
          Make.line();
          System.out.println(tab+"LIST OF DOCTORS ");
          Make.line();
          System.out.println("SL.NO\tDOCTOR ID      \tNAME                                              \tAGE               \tQUALIFICATION                  \t FEES");
          Make.line();
          while((rec=brf.readLine())!=null)       //displaying records
               printRec(rec,++c);

          if(c==0)//checking for empty files
          {
               System.out.println("No Doctors Under this Category");
               Make.line();
               Make.time();     //delay
               return;
          }//end of if 
          //input
          Make.line();
          brf.close();
          System.out.println("Enter the Doctor which you wish to remove ...(sl.no)");
          int sl=Integer.parseInt(br.readLine());

          if(sl<1 || sl>c)// handling exceptions
          {
               Make.error();     //displaying error message
               return;
          }//end of if 

          delete(n[choice-1]+".txt",--sl,c);      //deleting records
          System.out.print('\u000C');     //clear screen
          //displaying success message
          Make.line();
          System.out.println(tab+"Doctor Successfully Removed !!");
          Make.line();
          Make.time();     //delay
     }//end of remove()
     //mehod to delete records for the doctor list
     public static void delete(String f,int choice,int c)throws IOException
     {
          int i;
          StringTokenizer st=new StringTokenizer("");
          String n[]=new String[c];
          BufferedReader brf=new BufferedReader(new FileReader(f));
          for(i=0;i<c;i++)    //reading files        
               n[i]=brf.readLine();     //storing data to array
          brf.close();
          //rewriting data to file without the removed record
          PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter(f)));
          for(i=0;i<c;i++)
          {
               if(i==choice)
                    continue;
               else
                    pw.println(n[i]);
          }
          pw.close();
     }//end of delete

     public static void issue()throws IOException
     {
          System.out.print('\u000C');     //clear screen
          dispSpec();           //displaying speciality
          //input
          System.out.println("Enter the Speciality to which you wish to book an appointment..(sl.no)");
          int choice=Integer.parseInt(br.readLine()),c=0;
          System.out.print('\u000C');     //clear screen
          if(choice>n.length || choice <1)   //checking for exceptions
          {
               Make.error();     //displaying error message
               return;
          }//end of if
          //displaying doctorlist
          Make.line();
          System.out.println(tab+"LIST OF DOCTORS ");
          Make.line();
          System.out.println("SL.NO\tDOCTOR ID       \tNAME                                              \tAGE                \tQUALIFICATION              \tFEES");
          Make.line();
          String rec="";
          BufferedReader brf=new BufferedReader(new FileReader(n[choice-1]+".txt"));

          while((rec=brf.readLine())!=null)//reading file
               printRec(rec,++c);            //printing records

          if(c==0)          //checking for empty file
          {
               System.out.println("No Doctors Under this Category");
               Make.line();
               Make.time();     //delay
               return;
          }//end of if
          //input
          Make.line();
          brf.close();
          System.out.println("Enter the Doctor which you wish to book an appointment with ...(sl.no)");
          int sl=Integer.parseInt(br.readLine());

          if(sl<1 || sl>c)       //checking for exceptions
          {
               Make.error();     //displaying error message
               return;
          }//end of if
          BufferedReader brf2=new BufferedReader(new FileReader(n[choice-1]+".txt"));
          int i=1;

          while((rec=brf2.readLine())!=null)      //loop to extract the record
          {
               if(i==sl)
                    break;
               i++;
          }//end of while
          brf2.close();

          Busylist.add(rec+"#"+n[choice-1]);    //adding the record to Busylist
          delete(n[choice-1]+".txt",--sl,c); //deleting the record from doctorlist
          Make.reciept(rec);  //printing the reciept
     }
     //method to search for a boook
     public static void search()throws IOException
     {
          System.out.print('\u000C');     //clear screen
          //input
          Make.line();
          System.out.println(tab+"Search A Doctor");
          Make.line();
          System.out.println("Enter The name of the Doctor - ");
          String x=br.readLine();
          boolean flag=false;
          outer:
          for(int i=0;i<n.length;i++)//loop to search betweeen specialities
          {
               BufferedReader brf=new BufferedReader(new FileReader(n[i]+".txt"));

               if(brf.readLine()==null)//checking for empty files
               {
                    brf.close();
                    continue;
               }//end of if 

               brf.close();
               BufferedReader brf2=new BufferedReader(new FileReader(n[i]+".txt"));
               String rec="";

               while((rec=brf2.readLine())!=null) //reading the file
               {
                    StringTokenizer st=new StringTokenizer(rec,"#");
                    String isbn=st.nextToken();   //tokenizing records
                    String nb=st.nextToken();

                    if(nb.trim().equals(x))  //checking for the doctor
                    {
                         //printing success message
                         flag=true;
                         System.out.print('\u000C');     //clear screen
                         Make.line();
                         System.out.println("Doctor is found in the Directory !! ");
                         Make.line();
                         System.out.println("\n\nDOCTOR ID - "+isbn+"\nSPECIALITY - "+n[i]);
                         Make.time();     //delay
                         break outer;
                    }//end of if
               }//end of while
               brf2.close();
          }//end of for()
          if(flag==false)
          {
               if(!Busylist.check(x)) //checking for the doctor in the busy list
               {
                    //printing appropriate message
                    System.out.print('\u000C');     //clear screen
                    Make.line();
                    System.out.println("SORRY !! DOCTOR UNAVAILABLE");
                    Make.line();
                    Make.time();     //delay
               }//end of inner if
          }//end of outer if
     }//end of search()
     //method to display the speciality
     public static void dispSpec()
     {
          Make.line();
          System.out.println(tab+"SPECIALITIES");
          Make.line();
          for(int i=0;i<n.length;i++)
               System.out.println(tab+(i+1)+"    -    "+n[i]);   //displaying the specialities
          Make.line();
     }//end of dispSpec()
}//end of class