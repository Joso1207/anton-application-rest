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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author joso
 */
@Entity
@Table(name = "TABLE_BOOKING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableBooking.findAll", query = "SELECT t FROM TableBooking t"),
    @NamedQuery(name = "TableBooking.findById", query = "SELECT t FROM TableBooking t WHERE t.id = :id"),
    @NamedQuery(name = "TableBooking.findByEmail", query = "SELECT t FROM TableBooking t WHERE t.email = :email"),
    @NamedQuery(name = "TableBooking.findByGuid", query = "SELECT t FROM TableBooking t WHERE t.guid = :guid"),
    @NamedQuery(name = "TableBooking.findByDate", query = "SELECT t FROM TableBooking t WHERE t.date = :date"),
    @NamedQuery(name = "TableBooking.findByPeriod", query = "SELECT t FROM TableBooking t WHERE t.period = :period")})
public class TableBooking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "GUID")
    private String guid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "PERIOD")
    private Short period;
    @JoinColumn(name = "TABLEID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Diningtable tableid;

    public TableBooking() {
    }

    public TableBooking(Integer id) {
        this.id = id;
    }

    public TableBooking(Integer id, String email, String guid, Date date) {
        this.id = id;
        this.email = email;
        this.guid = guid;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Short getPeriod() {
        return period;
    }

    public void setPeriod(Short period) {
        this.period = period;
    }

    public Diningtable getTableid() {
        return tableid;
    }

    public void setTableid(Diningtable tableid) {
        this.tableid = tableid;
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
        if (!(object instanceof TableBooking)) {
            return false;
        }
        TableBooking other = (TableBooking) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TableBooking[ id=" + id + " ]";
    }
    
}
