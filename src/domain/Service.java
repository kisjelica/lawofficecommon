/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rastko
 */
public class Service implements GenericEntity{
    private Long serviceID;
    private String serviceName;
    private String serviceDescription;
    private BigDecimal fee;

    public Service() {
    }

    public Service(Long serviceID, String serviceName, String serviceDescription, BigDecimal fee) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.fee = fee;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public Long getServiceID() {
        return serviceID;
    }

    public void setServiceID(Long serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    @Override
    public String toString() {
        return serviceName;
    }

    @Override
    public String getTableName() {
        return "service";
    }

    @Override
    public String getColumnNamesForInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String setAtrValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getInsertValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWhereCondition() {
        return "serviceid=" + serviceID;
    }

    @Override
    public void setId(Long id) {
        serviceID = id;
    }

    @Override
    public GenericEntity getNewRecord(ResultSet rs) throws SQLException {
        return new Service(rs.getLong("serviceid"), rs.getString("servicename"), rs.getString("servicedescription"), rs.getBigDecimal("fee"));
    }

    @Override
    public String getPrimaryKey() {
        return "serviceid";
    }
    
    
}
