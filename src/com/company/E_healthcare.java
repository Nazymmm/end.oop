package com.company;
import java.util.Date;

public class E_healthcare {
    private int p_id;
    private String p_name;
    private String p_last_name;
    private String address;
    private int IIN;

    private Boolean appointment;
    private int price;
    private Date appoint_date;
    private String referral;
    
    public E_healthcare(int p_id,String p_name,String p_last_name,String address,int IIN, Boolean appointment,int price,Date appoint_date,String referral){

        setP_id(p_id);
        setP_name(p_name);
        setP_last_name(p_last_name);
        setAddress(address);
        setIIN(IIN);
        setAppointment(appointment);
        setPrice(price);
        setAppoint_date(appoint_date);
        setReferral(referral);
    }

    public E_healthcare(String p_name, String p_last_name, String address, int iin, Boolean appointment, int price, String referral) {
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_last_name() {
        return p_last_name;
    }

    public void setP_last_name(String p_last_name) {
        this.p_last_name = p_last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIIN() {
        return IIN;
    }

    public void setIIN(int IIN) {
        this.IIN = IIN;
    }

    public Boolean getAppointment() {
        return appointment;
    }

    public void setAppointment(Boolean appointment) {
        this.appointment = appointment;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getAppoint_date() {
        return appoint_date;
    }

    public void setAppoint_date(Date appoint_date) {
        this.appoint_date = appoint_date;
    }

    public String getReferral() {
        return referral;
    }

    public void setReferral(String referral) {
        this.referral = referral;
    }

    @Override
    public String toString() {
        return "E_healthcare{" +
                "id=" + p_id +
                ", name='" + p_name + '\'' +
                ", last_name='" + p_last_name + '\'' +
                ", address='" + address + '\'' +
                ", IIN=" + IIN +
                ", appointment=" + appointment +
                ", price=" + price +
                ", appoint_date=" + appoint_date +
                ", referral='" + referral + '\'' +
                '}';
    }
}

