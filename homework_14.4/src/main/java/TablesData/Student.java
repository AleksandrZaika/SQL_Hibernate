package TablesData;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Students")
public class Student implements Serializable {

    private Integer id;
    private String name;
    private Integer age;
    private Date registrationDate;
    private List<Course> courses;
    private List<Subscription> subscriptions;
    private List<LinkedPurchaseList> linkedPurchaseList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, insertable=false, updatable=false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name = "registration_date")
    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @ManyToMany(mappedBy="students")
    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @OneToMany(mappedBy = "student")
    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    @OneToMany(mappedBy = "student")
    public List<LinkedPurchaseList> getLinkedPurchaseList() {
        return linkedPurchaseList;
    }

    public void setLinkedPurchaseList(List<LinkedPurchaseList> linkedPurchaseList) {
        this.linkedPurchaseList = linkedPurchaseList;
    }
}
