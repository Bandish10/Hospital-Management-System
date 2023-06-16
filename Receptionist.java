/*This class Handles all operatins related to the Receptionist*/
import java.io.*;
import java.util.*;
class Receptionist
{
    private static String tab="\t\t\t\t\t\t";
    private static String name="";
    private static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         //method for getting user's choice and invoke methods accordingly
    public static void main()throws IOException
    {
         //receptionist's login
        if(login()==false)
            return; //returning to the Main Menu
        
        while(true)
        {
            dispMenu();  //displaying menu
            System.out.println("Enter your choice ... ");
            
            switch(Integer.parseInt(br.readLine()))
            {
                case 1:
                Doctorlist.add();    //method call
                break;
                
                case 2:
                Doctorlist.remove(); //method call
                break;
                
                case 3:
                Doctorlist.display();     //method call
                break;
                
                case 4:
                Busylist.display();   //method call
                break;
                
                case 5:
                Doctorlist.search();      //method call
                break;
                
                case 6:
                Doctorlist.issue();       //method call
                break;
                
                case 7:
                Busylist.ret();       //method call
                break;
                
                case 8:
                Make.wish();            //printing goodbye message
                return;
                
                default:
                Make.error();      //handling exceptions 
            }//end of switch-case()
        }//end of while
    }//end of main()
    //method to Receptionist login
    public static boolean login()throws IOException
    {
        System.out.print('\u000C');     //clear screen
        //input
        Make.line();
        System.out.println(tab+"Receptionist Login");
        Make.line();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Unique Id ...");
        String ul=br.readLine();
        System.out.println("Enter Password...");
        String pl=br.readLine();
        BufferedReader brf=new BufferedReader(new FileReader("Receptionist.txt"));
        String rec="";
        
        while((rec=brf.readLine())!=null)//reading receptionist file
        {
            StringTokenizer st=new StringTokenizer(rec,"#");
            String n=st.nextToken().trim();//separating tokens
            String u=st.nextToken().trim();
            String p=st.nextToken();
            if(ul.equals(u) && pl.equals(p)) //password and unique id checking
            {
                name=n;  //initializing the name
                return true;
            }//end of if
        }//end of while()
        //handling exceptions
        System.out.print('\u000C');     //clear screen
        Make.line();
        System.out.println(tab+"Invalid Unique Id or Password !!!");
        Make.line();
        Make.time();     //delay()
        return false;
    }//end of login()

    public static void dispMenu()       //method to display receptionist Menu
    {
        System.out.print('\u000C');     //clear screen
        Make.line();
        System.out.println(tab+"Welcome ! "+name);
        Make.line();
        System.out.println(tab+"MENU");
        Make.line();
        System.out.println(tab+"1  -    Add a Doctor");
        System.out.println(tab+"2  -    Remove a Doctor");
        System.out.println(tab+"3  -    Display List of available Doctors");
        System.out.println(tab+"4  -    Display currently appointed Doctors");
        System.out.println(tab+"5  -    Search for a Doctor");
        System.out.println(tab+"6  -    Book an Appointment");
        System.out.println(tab+"7  -    Remove an Appointment");
        System.out.println(tab+"8  -    LOGOUT");
        Make.line();
    }//end of dispMenu()
}//end of class