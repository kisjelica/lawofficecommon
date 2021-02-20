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
public class InvoiceItem implements GenericEntity{
    private Invoice invoice;
    private Service service;
    private int orderNumber;
    private BigDecimal price;
    private int quantity;
    private BigDecimal amount;

    public InvoiceItem() {
    }

    public InvoiceItem(Invoice invoice, Service service, int orderNumber, BigDecimal price, int quantity, BigDecimal amount) {
        this.invoice = invoice;
        this.service = service;
        this.orderNumber = orderNumber;
        this.price = price;
        this.quantity = quantity;
        this.amount = amount;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String getTableName() {
        return "invoiceitem";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "invoiceid,ordernumber,price,quantity,amount,serviceid";
    }

    @Override
    public String setAtrValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(invoice.getInvoiceID()).append(",")
          .append(orderNumber).append(",")
          .append(price).append(",")
          .append(quantity).append(",")
          .append(amount).append(",")
          .append(service.getServiceID());
        return sb.toString();
    }

    @Override
    public String getWhereCondition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GenericEntity getNewRecord(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPrimaryKey() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
