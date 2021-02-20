/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author rastko
 */
public class Obligation implements GenericEntity {

    private Long obligationID;
    private String obligationSubject;
    private String obligationDescription;
    private LocalDateTime dateOfObligation;

    public Obligation() {
    }

    public Obligation(Long obavezaID, String obligationSubject, String obligationDescription, LocalDateTime dateOfObligation) {
        this.obligationID = obavezaID;
        this.obligationSubject = obligationSubject;
        this.obligationDescription = obligationDescription;
        this.dateOfObligation = dateOfObligation;
    }

    public Long getObligationID() {
        return obligationID;
    }

    public void setObligationID(Long obligationID) {
        this.obligationID = obligationID;
    }

    public String getObligationSubject() {
        return obligationSubject;
    }

    public void setObligationSubject(String obligationSubject) {
        this.obligationSubject = obligationSubject;
    }

    public String getObligationDescription() {
        return obligationDescription;
    }

    public void setObligationDescription(String obligationDescription) {
        this.obligationDescription = obligationDescription;
    }

    public LocalDateTime getDateOfObligation() {
        return dateOfObligation;
    }

    public void setDateOfObligation(LocalDateTime dateOfObligation) {
        this.dateOfObligation = dateOfObligation;
    }

    @Override
    public String getTableName() {
        return "obligation";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "obligationid,obligationsubject,obligationdescription,dateofobligation";
    }

    @Override
    public String setAtrValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(obligationID).append(",")
                .append("'").append(obligationSubject).append("',")
                .append("'").append(obligationDescription).append("',")
                .append("'").append(dateOfObligation).append("'");
        return sb.toString();
    }

    @Override
    public String getWhereCondition() {
        return "obligationid=" + obligationID;
    }

    @Override
    public void setId(Long id) {
        obligationID = id;
    }

    @Override
    public GenericEntity getNewRecord(ResultSet rs) throws SQLException {
        return new Obligation(rs.getLong("obligationid"), rs.getString("obligationsubject"), rs.getString("obligationdescription"), rs.getObject("dateofObligation", LocalDateTime.class));
    }

    @Override
    public String getPrimaryKey() {
        return "obligationid";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.obligationID);
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
        final Obligation other = (Obligation) obj;
        if (!Objects.equals(this.obligationID, other.obligationID)) {
            return false;
        }
        return true;
    }
    
    
}
