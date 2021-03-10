package com.company;

//import java.sql.Date;
//import com.company.E_healthcare;
//import java.util.ArrayList;
import java.util.List;

public interface FAccount {

    E_healthcare getE_healthcare(int p_id);
    boolean insertE_healthcare(E_healthcare e_healthcare);
    E_healthcare searchByName(String p_name);
    boolean deleteE_healthcare(int p_id);
    List<E_healthcare> getAllE_healthcare();
}
