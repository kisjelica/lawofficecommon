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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author rastko
 */
public class Invoice implements GenericEntity {

    private Lawyer lawyer;
    private Client client;
    private Long invoiceID;
    private String invoiceNumber;
    private BigDecimal invoiceTotal;
    private LocalDateTime invoiceDate;
    private boolean cancelled;
    private boolean processed;
    private List<InvoiceItem> items;

    public Invoice() {
        this.items = new ArrayList<>();
        this.invoiceTotal = BigDecimal.ZERO;
    }

    public Invoice(Lawyer lawyer, Client client, Long invoiceID, String invoiceNumber, BigDecimal invoiceTotal, LocalDateTime invoiceDate, boolean cancelled, boolean processed) {
        this.lawyer = lawyer;
        this.client = client;
        this.invoiceID = invoiceID;
        this.invoiceNumber = invoiceNumber;
        this.invoiceTotal = invoiceTotal;
        this.invoiceDate = invoiceDate;
        this.cancelled = cancelled;
        this.processed = processed;
        
    }

    public Lawyer getLawyer() {
        return lawyer;
    }

    public void setLawyer(Lawyer lawyer) {
        this.lawyer = lawyer;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(Long invoiceID) {
        this.invoiceID = invoiceID;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public BigDecimal getInvoiceTotal() {
        return invoiceTotal;
    }

    public void setInvoiceTotal(BigDecimal invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public List<InvoiceItem> getItems() {
        return items;
    }

    public void setItems(List<InvoiceItem> items) {
        this.items = items;
    }

    public LocalDateTime getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    @Override
    public String getTableName() {
        return "invoice";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "invoiceid,invoicenumber,invoicetotal,invoicedate,cancelled,processed,lawyerid,clientid";
    }

    @Override
    public String setAtrValues() {
        return "invoicenumber=" + "'" + invoiceNumber + "'" + ", " + "invoicetotal=" + invoiceTotal + ", " + "invoiceDate=" + "'" + invoiceDate + "'" + ", " + "cancelled=" + cancelled + ", " + "processed=" + processed + ", " + "lawyerid=" + lawyer.getLawyerID() + ", " + "clientid=" + client.getClientID();
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(invoiceID).append(",")
                .append("'").append(invoiceNumber).append("',")
                .append(invoiceTotal).append(",")
                .append(invoiceDate).append(",")
                .append(cancelled).append(",")
                .append(processed).append(",")
                .append(lawyer == null ? null : lawyer.getLawyerID()).append(",")
                .append(client == null ? null : client.getClientID());
        return sb.toString();
    }

    @Override
    public String getWhereCondition() {
        return "invoiceid=" + invoiceID;
    }

    @Override
    public void setId(Long id) {
        invoiceID = id;

    }

    @Override
    public GenericEntity getNewRecord(ResultSet rs) throws SQLException {
        return new Invoice((Lawyer)new Lawyer().getNewRecord(rs),(Client) new Client().getNewRecord(rs),rs.getLong("invoiceid"), rs.getString("invoicenumber"), rs.getBigDecimal("invoicetotal"), rs.getObject(("invoicedate"), LocalDateTime.class), rs.getBoolean("cancelled"), rs.getBoolean("processed"));
    }

    @Override
    public String getPrimaryKey() {
        return "invoiceID";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.invoiceID);
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
        final Invoice other = (Invoice) obj;
        if (!Objects.equals(this.invoiceID, other.invoiceID)) {
            return false;
        }
        return true;
    }

}
