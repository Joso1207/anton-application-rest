/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author joso
 */
@Entity
@Table(name = "WORK_SHIFT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WorkShift.findAll", query = "SELECT w FROM WorkShift w"),
    @NamedQuery(name = "WorkShift.findById", query = "SELECT w FROM WorkShift w WHERE w.id = :id"),
    @NamedQuery(name = "WorkShift.findByTradable", query = "SELECT w FROM WorkShift w WHERE w.tradable = :tradable"),
    @NamedQuery(name = "WorkShift.findByStartdate", query = "SELECT w FROM WorkShift w WHERE w.startdate = :startdate")})
public class WorkShift implements Serializable {

    @JoinColumn(name = "EMPLOYEEID", referencedColumnName = "ID")
    @ManyToOne
    private Employee employeeid;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "TRADABLE")
    private Boolean tradable;
    @Column(name = "STARTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;

    public WorkShift() {
    }

    public WorkShift(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getTradable() {
        return tradable;
    }

    public void setTradable(Boolean tradable) {
        this.tradable = tradable;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WorkShift)) {
            return false;
        }
        WorkShift other = (WorkShift) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.WorkShift[ id=" + id + " ]";
    }

    public Employee getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Employee employeeid) {
        this.employeeid = employeeid;
    }
    
}
