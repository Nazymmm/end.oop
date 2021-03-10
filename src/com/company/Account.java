package com.company;

//import com.company.FSql;
//import com.company.E_healthcare;
//import com.company.FAccount;
import java.sql.SQLException;
import java.lang.ClassNotFoundException;
import java.sql.*;

import java.util.LinkedList;
import java.util.List;

public class Account implements FAccount {
    private final FSql db;

    public Account(FSql db)
    {this.db=db;}


    @Override
    public boolean insertE_healthcare(E_healthcare e_healthcare) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO E_healthcare (p_name, p_last_name,address,IIN,appointment,price,referral) VALUES (?, ?, ?, ?, ?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, e_healthcare.getP_name());
            st.setString(2, e_healthcare.getP_last_name());
            st.setString(3, e_healthcare.getAddress());
            st.setInt(4, e_healthcare.getIIN());
            st.setBoolean(5, e_healthcare.getAppointment());
            st.setInt(6, e_healthcare.getPrice());
            st.setString(8, e_healthcare.getReferral());
            st.execute();
            return true;

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                assert con != null;
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }


    @Override
    public E_healthcare getE_healthcare(int p_id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT p_id, p_name, p_last_name,address,IIN,appointment,price,appoint_date,referral FROM E_healthcare WHERE p_id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, p_id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return new E_healthcare(
                        rs.getInt("p_id"),
                        rs.getString("p_name"),
                        rs.getString("p_last_name"),
                        rs.getString("address"),
                        rs.getInt("IIN"),
                        rs.getBoolean("appointment"),
                        rs.getInt("price"),
                        rs.getDate("appoint_date"),
                        rs.getString("referral"));
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                assert con != null;
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }


    @Override
    public List<E_healthcare> getAllE_healthcare() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT p_id, p_name, p_last_name,address,IIN,appointment,price,appoint_date,referral FROM E_healthcare";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<E_healthcare> e_healthcares = new LinkedList<>();

            while (rs.next()) {
                E_healthcare e_healthcare= new E_healthcare(
                        rs.getInt("p_id"),
                        rs.getString("p_name"),
                        rs.getString("p_last_name"),
                        rs.getString("address"),
                        rs.getInt("IIN"),
                        rs.getBoolean("appointment"),
                        rs.getInt("price"),
                        rs.getDate("appoint_date"),
                        rs.getString("referral"));
                e_healthcares.add(e_healthcare);
            }
            return e_healthcares;

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                assert con != null;
                con.close();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public E_healthcare searchByName(String p_name) {
        Connection con;

        try {
            con = db.getConnection();

            PreparedStatement preparedStatement = con.prepareStatement("SELECT*FROM E_healthcare where p_name=?");
            preparedStatement.setString(1, p_name);
            ResultSet rs = preparedStatement.executeQuery();

            List<E_healthcare> e_healthcares = new LinkedList<>();


            while (rs.next()) {
                E_healthcare e_healthcare = new E_healthcare(
                        rs.getInt("p_id"),
                        rs.getString("p_name"),
                        rs.getString("p_last_name"),
                        rs.getString("address"),
                        rs.getInt("IIN"),
                        rs.getBoolean("appointment"),
                        rs.getInt("price"),
                        rs.getDate("appoint_date"),
                        rs.getString("referral"));
                e_healthcares.add(e_healthcare);
                return e_healthcare;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean deleteE_healthcare(int p_id) {
        Connection con;

        try {
            con = db.getConnection();

            PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM E_healthcare WHERE p_id=?");

            preparedStatement.setInt(1, p_id);

            preparedStatement.execute();

            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


}
