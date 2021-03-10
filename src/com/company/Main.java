package com.company;

//import com.company.*;
//import com.company.Controller;
//import com.company.Sql;
//import com.company.FSql;
//import com.company.E_healthcare;
//import com.company.Account;
//import com.company.FAccount;
//
//import java.util.List;

public class Main {

    public static void main(String[] args) {
        FSql db = new Sql();
        FAccount repositor=new Account(db) ;
        Controller controller=new Controller(repositor);
        MyApplication app=new MyApplication(controller);
        app.start();
    }
}

