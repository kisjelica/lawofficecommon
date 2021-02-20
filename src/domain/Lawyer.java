/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Objects;


/**
 *
 * @author rastko
 */
public class Lawyer implements GenericEntity {

    private Long lawyerID;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDateTime dateOfEmployment;

    public Lawyer() {
    }

    public Lawyer(Long advokatID, String username, String password, String ime, String prezime, LocalDateTime datumZaposlenja) {
        this.lawyerID = advokatID;
        this.username = username;
        this.password = password;
        this.firstName = ime;
        this.lastName = prezime;
        this.dateOfEmployment = datumZaposlenja;
    }

    public Long getLawyerID() {
        return lawyerID;
    }

    public void setLawyerID(Long lawyerID) {
        this.lawyerID = lawyerID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public LocalDateTime getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(LocalDateTime dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    @Override
    public String getTableName() {
        return "lawyer";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "lawyerid,username,password,firstname,lastname,dateofemployment";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(lawyerID).append(",")
                .append("'").append(username).append("',")
                .append("'").append(password).append("',")
                .append("'").append(firstName).append("',")
                .append("'").append(lastName).append("',")
                .append(dateOfEmployment);
        return sb.toString();
    }

    @Override
    public void setId(Long id) {
        this.lawyerID = id;
    }

    @Override
    public GenericEntity getNewRecord(ResultSet rs) throws SQLException {
        return new Lawyer(rs.getLong("lawyerid"), rs.getString("username"), rs.getString("password"), rs.getString("firstname"), rs.getString("lastname"), rs.getObject(("dateofemployment"), LocalDateTime.class));
    }

    @Override
    public String setAtrValues() {
        return "username=" + "'" + username + "'" + ", " + "password=" + "'" + password + "'" + ", " + "firstname=" + "'" + firstName + "'" +", " + "lastname=" + "'" + lastName + "'" + ", " + "dateofemployment=" + "'" + dateOfEmployment + "'";

    }

    @Override
    public String getWhereCondition() {
        return "lawyerid=" + lawyerID;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

  
    @Override
    public String getPrimaryKey() {
        return "lawyerid";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Lawyer other = (Lawyer) obj;
        if (!Objects.equals(this.lawyerID, other.lawyerID)) {
            return false;
        }
        return true;
    }
    
    
}
