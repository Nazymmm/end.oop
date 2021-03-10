package com.company;

//import com.company.E_healthcare;
//import com.company.FAccount;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

public class Controller {

    private final FAccount repositor;

    public Controller(FAccount repositor) {
        this.repositor = repositor;
    }


    public String getE_healthcare(int p_id) {
        String result =repositor.getE_healthcare(p_id).toString();

        return result;
    }
    public String deleteE_healthcare(int p_id){
        E_healthcare e_healthcare =repositor.getE_healthcare(p_id);
        boolean created=repositor.deleteE_healthcare(p_id);
        return (created?"E_healthcare deleted" : "E_healthcare deleted was failed");
    }
    public  String searchByName(String p_name)
    {
        E_healthcare e_healthcare=repositor.searchByName(p_name);
        return (e_healthcare==null ? "E_healthcare was not Found" : e_healthcare.toString());
    }

    public String insertE_healthcare(String p_name, String p_last_name, String address, int IIN, Boolean appointment, int price,String referral) {


        boolean inserted =repositor.insertE_healthcare(new E_healthcare( p_name, p_last_name,address,IIN,appointment,price,referral));

        if (inserted) {
            return "e_healthcare created";
        }

        return "e_healthcare not created";
    }
    public String getAllE_healthcare()
    {
        List<E_healthcare> e_healthcare= repositor.getAllE_healthcare();
        return e_healthcare.toString();
    }

}