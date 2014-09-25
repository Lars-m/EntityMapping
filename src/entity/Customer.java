/*
 */

package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 * @author Lars Mortensen
 */
@Entity
public class Customer implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="s1")
  @SequenceGenerator(name="s1",sequenceName = "JUMBAJUMBA",
                     initialValue = 200000,allocationSize = 1)
  private Integer id;
  private String name;
  
  @ElementCollection
  private List<String> hobbies = new ArrayList();
  
  @ElementCollection
  @MapKeyColumn(name = "Phone")
  @Column(name = "description")
  private Map<String,String> phones = new HashMap();
  
    
  @ManyToMany
  List<Address> a = new ArrayList();
  
  public void addPhone(String no, String des){
    phones.put(no, des);
  }
  
  public String getDescription(String phone){
    return phones.get(phone);
  }
  
  public void addHobby(String hobby){
    hobbies.add(hobby);
  }
  
  public String getHobbies(){
    String hob = "";
    for(String hobby : hobbies){
      if(!hob.isEmpty()){
        hob+= ", ";
      }
      hob += hobby;
    }
    return hob;
  }

  public Customer(String name) {
    this.name = name;
  }

  public Customer() {}
  
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  

}
