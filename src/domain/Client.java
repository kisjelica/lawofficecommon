/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rastko
 */
public class Client implements GenericEntity {

    private Long clientID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private Lawyer lawyer;

    public Client() {
    }

    public Client(Long clientID, String firstName, String lastName, String phoneNumber, String email, Lawyer lawyer) {
        this.clientID = clientID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.lawyer = lawyer;
    }

    public Lawyer getLawyer() {
        return lawyer;
    }

    public void setLawyer(Lawyer lawyer) {
        this.lawyer = lawyer;
    }

    public Long getClientID() {
        return clientID;
    }

    public void setClientID(Long clientID) {
        this.clientID = clientID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getTableName() {
        return "client";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "clientid,cfirstname,clastname,phonenumber,email,lawyerid";
    }

    @Override
    public String setAtrValues() {
        return "cfirstname=" + "'" + firstName + "'" + ", " + "clastname=" + "'" + lastName + "'" + ", " + "phonenumber=" + "'" + phoneNumber + "'" + ", " + "email=" + "'" + email + "'" + ", " + "lawyerid= " +lawyer.getLawyerID();
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(clientID).append(",")
                .append("'").append(firstName).append("',")
                .append("'").append(lastName).append("',")
                .append("'").append(phoneNumber).append("',")
                .append("'").append(email).append("',")
                .append(lawyer == null ? null : lawyer.getLawyerID());
        return sb.toString();
    }

    @Override
    public String getWhereCondition() {
        return "clientid= " +clientID;
    }

    @Override
    public void setId(Long id) {
        clientID = id;
    }

    @Override
    public GenericEntity getNewRecord(ResultSet rs) throws SQLException {
        return new Client(rs.getLong("clientid"), rs.getString("cfirstname"),rs.getString("clastname"), rs.getString("phonenumber"), rs.getString("email"), (Lawyer) new Lawyer().getNewRecord(rs));
    }

    

    @Override
    public String getPrimaryKey() {
        return "clientid";
    }

}
