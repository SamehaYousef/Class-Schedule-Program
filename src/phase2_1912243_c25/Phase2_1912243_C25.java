//Program_Class Schedule
package phase2_1912243_c25;

import java.util.Scanner;

public class Phase2_1912243_C25 {
    

    public static void main(String[] args) {
    
    Scanner y= new Scanner(System.in);
    int courseChoice;
    String yesNo = null;
    String finalTime="";
    double endTime;
    String[] registeredCourse= new String[5];
    String[] startTime= new String[5];
    int[] day = new int[5];
    String hrS;
    int hr;
    int min;
    String startTimeS;
    int dayNum;
    String courseName="";
    boolean verify;
    
   

    
    System.out.println("|---------------------------------------------------"
            + "-------------------------------|");
    System.out.println("|------------\t\t   Fall 2019 Schedule Program\t\t\t--"
            + "---------|");
    System.out.println("|------------------------------------------------------"
            + "----------------------------|");
    
    System.out.print("> Enter your name: ");
    String name = y.nextLine();
    
    System.out.println("|------------------------------------------------------"
            + "----------------------------|");
    System.out.println("|------------\t\t   Fall 2019 Schedule Program\t\t\t---"
            + "--------|");
    System.out.println("|------------------------------------------------------"
            + "----------------------------|");
    
    System.out.println("  Welcome " +name.toUpperCase().trim() + " to your "
            + "class schedule program!");
    
    System.out.println("|-----------------------------------------------------"
            + "-----------------------------|");
     
  
    
    Scanner x= new Scanner(System.in);
    int count=0;
    char choice;
    do{ 
        displayMainMenu();  
        choice=inputAndCheck();//character
    
    
        switch(choice){
        
         case 'A':
            String [] fourthSemesterCourses = {"ISLM101","SCHP231","SCMT221",
                "CCCS222","CCCS220"};
            
            String [] prerequisites={"No prerequiest","PHY-101","SCMT-231",
                "MATH-110","CCCS210"};
            do{
             
             
            do{
              
              courseChoice=displaySecondMenu();

              if (courseChoice == 6) break;  
              
              courseName=fourthSemesterCourses[courseChoice-1];
                
              verify=findCourse(registeredCourse, courseName);
              
                
              if(verify==true){
                  
                  
                if(courseChoice==1) 
                    System.out.println(prerequisites[courseChoice-1]
                        +" course needed."); 
                    
             
                else {       
                System.out.print("Did you finish the "
                + "prerequiest course \""+ prerequisites[courseChoice-1]
                        +"?\" (yes\\no)? "); 
                yesNo = x.next().toLowerCase().trim(); 
                }
                
                               
                if (courseChoice==1 || "yes".equals(yesNo.toLowerCase().trim()) )
                {
                registeredCourse[count]=courseName;  
                
                do{
                //time
                System.out.print("Enter the start time in the (format XX.XX): ");
                
                startTimeS = x.next().trim();
               
               
                while (!(startTimeS.indexOf(".") == 2 && startTimeS.length() == 5)){
                    
                    System.out.println("Invalid time format! Please try again");
                    System.out.print("Enter the start time in the (format XX.XX): ");
                    startTimeS = x.next().trim();
                }
                     
                     hrS= startTimeS.substring(0,2); //hr string
                     hr = Integer.parseInt(hrS); //hr int
                    
                    String minS= startTimeS.substring(3);// min string
                     min = Integer.parseInt(minS);// min int 
                    
                     if(!(hr >= 8 && hr <= 23) || !(min >= 0 && min <= 59))
                     System.out.println("Invalid time format! Please try again"); 
                   
                   }while(!(hr >= 8 && hr <= 23) || !(min >= 0 && min <= 59));
                    
                    startTime[count]=startTimeS; 
                    do{
                    System.out.print("Enter the class days (1 For UTR, 2 for MW)"
                            + ": ");
                    dayNum= x.nextInt();
                    
                    if (dayNum == 1 || dayNum ==2 ){
                           
              System.out.println("The course "+courseName+ " has been added!");
                         break;
                           }
                    
                    else
                        System.out.println("Invalid Selection! Try Again!");
                  
                    
                        }while(dayNum != 1 || dayNum != 2);
                    
                    day[count]=dayNum;  //num of day saved in count index
                  count++; }
                      
          else        
            System.out.println("You will not be able to add the course "
           + courseName+ " since\nthe prerequisite is "
                   + "not met.");
             }  
              
         else{
                    
              System.out.println("You can not add the course " + courseName + 
                      " beacuse it had been already added"); break;}
            
             }while(true); 
             
if (courseChoice == 6) break;  
             
             }while(true); break; 
            
        
        case 'G':
                printAllCourses();
            break;
           
        case 'P': 
            displayAddedCourses(registeredCourse, startTime,
         day); break; 
            
        case 'F':  System.out.print("Enter the course code: ");
                   String search= y.nextLine().toUpperCase().trim();
                   
                   boolean doesCourseExist = findCourse(registeredCourse,search); 
                   
                   if(doesCourseExist==false)
                       System.out.println("The course is listed in your schedule");
                   else 
                       System.out.println("The course is NOT listed in your schedule");
                       break;
            
        case 'E':  System.out.println("> Exiting the program...\n> Goodbye!");
                   System.exit(0); break;
                   
       
}}while(choice != 'E');}
   
    
/////////////////////////////////METHODS////////////////////////////////////////
    public static void displayMainMenu(){
        
System.out.println("|-----------------------------------------------------"
            + "-----------------------------|");
System.out.println("|------------\t\t   Fall 2019 Schedule Program\t\t\t--"
            + "---------|");
System.out.println("|-----------------------------------------------------"
            + "-----------------------------|");
    
System.out.println("|  A/a: Enter A or a for Adding a Course\t\t\t\t\t   |");
     
System.out.println("|  G/g: Enter G or g for Getting the courses details"
   + "\t\t\t\t   |");

System.out.println("|  P/p: Enter P or p for Printing the added courses"
   + "\t\t\t\t   |");
    
System.out.println("|  E/e: Enter E or e for Exiting the Program\t\t\t\t\t   |");

System.out.println("|  F/f: Enter F or f for Finding a course\t\t\t\t\t   |");


System.out.println("|-----------------------------------------------------"
    + "-----------------------------|");

    }
    
//////////////////////////////////////////////////////////////
    
    public static int displaySecondMenu(){

Scanner x= new Scanner(System.in);
int choosenNum;
boolean verify=true;

do {     
System.out.println("|--------------------------------------------"
                    + "--------------------------------------|");
System.out.println("|------------\t\t   Fall 2019 Schedule Program"
                    + "\t\t\t-----------|");
System.out.println("|----------------------------------------------"
                    + "------------------------------------|");
System.out.println("|\t\t\t  CS/AI Department-Forth Semester\t\t\t   |\n"
+ "| 1. ISLM101  \t\t\t\t\t\t\t\t\t   |\n"
+ "| 2. SCHP231  \t\t\t\t\t\t\t\t\t   |\n"
+ "| 3. SCMT221  \t\t\t\t\t\t\t\t\t   |\n"
+ "| 4. CCCS222  \t\t\t\t\t\t\t\t\t   |\n"
+ "| 5. CCCS220  \t\t\t\t\t\t\t\t\t   |\n"
+ "| 6. Return to main menu  \t\t\t\t\t\t\t   |");
System.out.println("|---------------------------------------------"
                    + "-------------------------------------|");
System.out.print("> Please type the number of the choice:");
choosenNum = x.nextInt();

if(!((choosenNum >=1) && (choosenNum <=6))){
    System.out.println("\nInvalid Selection! Try Again");
    verify=false;}
else
    return choosenNum;
    
    
} while(!(verify)); 

return choosenNum;
}
////////////////////////////////////////////////////////////////////////////////
    
 public static char inputAndCheck(){
     
 Scanner x = new Scanner(System.in);       
     //returns the character
     char choice;
     boolean isValid=true;
     
 do{
     System.out.print("> Please enter your choice: ");
     choice = x.nextLine().trim().toUpperCase().charAt(0);
     
     if(!(choice=='A'|| choice=='G'|| choice=='E'|| choice=='F'||choice=='P'))
     {System.out.println("Invalid Selection! Please Try Again!");
         isValid=false;
         displayMainMenu();}
     else 
         isValid=true;
     
 }while(!(isValid)); 
 return choice;
}
///////////////////////////////////////////////////////////////////////////////
 
 public static boolean findCourse(String [] registeredCourse, String courseName){
             
     boolean test=true;
     
 for(int i=0; i < registeredCourse.length && registeredCourse[i] != null;i++){
          if(registeredCourse[i].equals(courseName))
              test= false;
              }
     return test;
}
////////////////////////////////////////////////////////////////////////////////
 
 public static void printAllCourses(){
                  
                  String code1="ISLM101";
                  String name1="Islamic 1"; int cr1=3;
        
                  String code2="SCHP231"; String name2="Physics 2"; int cr2=4;
                  String pre2="PHY101";
                  
                  String code3="SCMT221"; String name3="Linear Algebra"; 
                  String pre3="SCMT231";
                  
                  String code4="CCCS222"; String name4="Discrete Mathematics";
                  String pre4="MATH110";
                  
                  String code5="CCCS220"; String name5="Object Oriented "
                          + "Programming 1";  String pre5="CCCS210";
                          
            System.out.println("|----------------------------------------------"
                    + "------------------------------------|");
            System.out.println("|--------------\t\t\tCourse Information\t\t     "
                    + "--------------|");              
            System.out.println("|----------------------------------------------"
                    + "------------------------------------|");            
            System.out.println("Course\t\tName\t\t\t\tCredit\t\tPrerequiest");
            System.out.println("|----------------------------------------------"
                    + "------------------------------------|");
            System.out.printf("%-16s%-35s%-14d--",code1,name1,cr1);
            
            System.out.printf("\n%-16s%-35s%-14d%s",code2,name2,cr2,pre2);
            System.out.printf("\n%-16s%-35s%-14d%s",code3,name3,cr1,pre3);
            System.out.printf("\n%-16s%-35s%-14d%s",code4,name4,cr1,pre4);
            System.out.printf("\n%-16s%-35s%-14d%s\n",code5,name5,cr1,pre5); 
            System.out.println("|----------------------------------------------"
                    + "------------------------------------|");
 }
 //////////////////////////////////////////////////////////////////////////////
 
 public static void displayAddedCourses(String[] course, String[] startTime,
         int[] day){
 String [] nameOfDays= {"UTR","MW"};    
 double endTime;
 String finalTime = "";
 double startTimeN;
 String weekDay;
 int creditNum;
 int credit[]=new int[5];

      System.out.println("|The course details for Fall 2019:\t\t\t\t\t\t   |");
      System.out.println("|-----------------------------------"
       + "-----------------------------------------------|");
      System.out.println("| Code\t\t\tTime\t\t\tDays\t\t\tCredit"
       + "\t   |");
      System.out.println("|----------------------------------"
                        + "------------------------------------------------|");
 
      for(int i=0; i< 5 && course[i] != null ; i++){      
     
   startTimeN = Double.parseDouble(startTime[i]);
      
        if(day[i]==1){
            endTime = startTimeN + 0.50;}
                        
        else
           endTime = startTimeN + 1.20;  
                        
   finalTime= startTimeN+"0:"+ endTime +"0"; 
       
   weekDay=nameOfDays[day[i]-1];
      
   creditNum=(course[i].equals("SCHP231"))? 4:3; 
   credit[i]=creditNum;
     
   System.out.printf("> "+"%-20s%-27s%-25s%d\n",course[i],finalTime,weekDay,
           credit[i]);

    System.out.println("|----------------------------------"
                        + "------------------------------------------------|");     
 }
    
}

    }
