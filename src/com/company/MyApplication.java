package com.company;
//import com.company.Controller;
//import com.company.E_healthcare;
//
//import java.time.LocalDate;
//import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
    private final Controller controller;
    private final Scanner sc;
    public MyApplication(Controller controller) {
        this.controller = controller;
        sc = new Scanner(System.in);
    }
    public void start()
    {
        while(true)
        {
            System.out.println("Select option:(1-3)");
            System.out.println("1)Get all patient");
            System.out.println("2)Get patient by id");
            System.out.println("3)Insert patient");
            System.out.println("4)Search Patient name");
            System.out.println("5)Delete Patient ");
            System.out.println("0) Exit");
            System.out.println();
            try {
                System.out.println("Enter the option:(1-5)");
                int option=sc.nextInt();
                if (option==1)
                {
                    getAllE_healthcareMenu();
                }
                else if (option==2)
                {
                    getE_healthcareByIdMenu();
                }
                else if(option==3)
                {
                    insertE_healthcareMenu();
                }
                else if(option==4)
                {
                    searchE_healthcareMenu();
                }
                else if(option==5)
                {
                    deleteE_healthcareMenu();
                }
                else{
                    break;
                }

            }  catch (InputMismatchException e )
            {
                System.out.println("Input must be integer");
                sc.nextLine();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
    }
    public void getAllE_healthcareMenu()
    {
        String response=controller.getAllE_healthcare();
        System.out.println(response);
    }
    public  void getE_healthcareByIdMenu(){
        System.out.println("Id of patient");
        int p_id=sc.nextInt();
        String response= controller.getE_healthcare(p_id);
        System.out.println(response);
    }
    public void searchE_healthcareMenu() {
        System.out.println("Write the name of patient!");
        String p_name = sc.next();
        String response = controller.searchByName(p_name);
        System.out.println(response);
    }
    public void insertE_healthcareMenu()
    {

        System.out.println("Name of patient!");
        String p_name=sc.next();
        System.out.println("Last name of patient!");
        String p_last_name=sc.next();
        System.out.println("Address of e_healthcare!");
        String address=sc.next();
        System.out.println("IIN of patient!");
        int IIN=sc.nextInt();
        System.out.println("Appointment of patient!");
        Boolean appointment=sc.nextBoolean();
        System.out.println("Price of appointment!");
        int price = sc.nextInt();
        System.out.println("Patient's referral");
        String referral = sc.next();
        String response =controller.insertE_healthcare(p_name, p_last_name,address,IIN,appointment,price,referral);
        System.out.println(response);

    }


    public void deleteE_healthcareMenu() {
        System.out.println("Write medicine's id!");
        int p_id = sc.nextInt();

        String response = controller.deleteE_healthcare(p_id);

        System.out.println(response);
    }

}
