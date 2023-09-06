package GradingSystem;

import java.util.*;

   public class Functions 
   {
     Grade grade = new Grade();
     

     Scanner sc = new Scanner(System.in);

    public void func()
    {

      boolean exit = false;
      while(!exit) 
      {
        
        System.out.println("What do you want to do?\n" +
        "1. Add Students.\n" + 
        "2. Search Student.\n" +
        "3. Remove Student.\n" +
        "4. Exit.");          
                            
        int choice = sc.nextInt();
        sc.close();
        String name;
        double prelim, midterms, prefinals, finals;
  
        switch (choice) {
  
          case 1:
            System.out.println("ADD STUDENT: ");
            sc.nextLine();

            System.out.println("Student surname: ");
            name = sc.nextLine();

            System.out.print("Prelim: ");
            prelim = sc.nextDouble();

            System.out.println("Midterms: ");
            midterms = sc.nextDouble();

            System.out.println("Prefinals: ");
            prefinals = sc.nextDouble();

            System.out.println("Finals: ");
            finals = sc.nextDouble();
           
            grade.addGrade(name, prelim, midterms, prefinals, finals);
            System.out.println("Student added!");

          case 2:

            int index = -1;

            System.out.println("SEARCH STUDENT: ");
            sc.nextLine();

            System.out.println("Student surname: ");
            String search = sc.nextLine();

            for (int i = 0; i < grade.surname.size(); i++)
            {
              if (grade.surname.get(i) == search) 
              {
                index = i;
                System.out.println(grade.surname.get(index) + 
                                   grade.Prelim.get(index) +
                                   grade.Midterm.get(index) +
                                   grade.Prefinals.get(index) +
                                   grade.Finals.get(index)
                                   );


              }
            }
        }
      }
    }

     




     



     
     





   }




