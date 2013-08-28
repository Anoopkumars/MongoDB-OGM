/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Untersuchungsraum;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.NumericField;
import org.hibernate.search.annotations.Store;

/**
 *
 * @author Babak
 */

@Entity
@Indexed

//@Table(name="Users")
public class User{
    @DocumentId
    @Id
    @GeneratedValue
 //   @GenericGenerator(name="uuid",strategy = "uuid2")
    private String  id;
            
//    @Column(name="City")
    @Field(index= Index.YES,analyze = Analyze.YES,store = Store.NO)
    private String city;
    
//    @Column(name="UserID")
    @NumericField
    @Field(index= Index.YES,analyze = Analyze.NO,store = Store.NO)
    private int UserID;
    
            

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void set_Id(String id) {
        this.id = id;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the IdU
     */
    public int getUserID() {
        return UserID;
    }

    /**
     * @param IdU the IdU to set
     */
    public void setUserID(int UserID) {
        this.UserID = UserID;
    }
    
}
