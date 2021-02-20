/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 *
 * @author rastko
 */
public class ObligationAttendance implements GenericEntity {

    private Lawyer lawyer;
    private Obligation obligation;
    private boolean attendedObligation;

    public ObligationAttendance() {
    }

    public ObligationAttendance(Lawyer lawyer, Obligation obligation, boolean attendedObligation) {
        this.lawyer = lawyer;
        this.obligation = obligation;
        this.attendedObligation = attendedObligation;
    }

    public boolean isAttendedObligation() {
        return attendedObligation;
    }

    public void setAttendedObligation(boolean attendedObligation) {
        this.attendedObligation = attendedObligation;
    }

    public Lawyer getLawyer() {
        return lawyer;
    }

    public void setLawyer(Lawyer lawyer) {
        this.lawyer = lawyer;
    }

    public Obligation getObligation() {
        return obligation;
    }

    public void setObligation(Obligation obligation) {
        this.obligation = obligation;
    }

    @Override
    public String getTableName() {
        return "tobligationattendance";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "lawyerid,obligationid,attendedobligation";
    }

    @Override
    public String setAtrValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(lawyer.getLawyerID()).append(",")
                .append(obligation.getObligationID()).append(",")
                .append(attendedObligation);
        return sb.toString();
    }

    @Override
    public String getWhereCondition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(Long id) {
    }

    @Override
    public GenericEntity getNewRecord(ResultSet rs) throws SQLException {
        return new ObligationAttendance((Lawyer) new Lawyer().getNewRecord(rs), (Obligation) new Obligation().getNewRecord(rs), rs.getBoolean("attendedobligation"));
    }

    @Override
    public String getPrimaryKey() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final ObligationAttendance other = (ObligationAttendance) obj;
        if (!Objects.equals(this.lawyer, other.lawyer)) {
            return false;
        }
        if (!Objects.equals(this.obligation, other.obligation)) {
            return false;
        }
        return true;
    }
    
}
