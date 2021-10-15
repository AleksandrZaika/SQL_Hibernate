package TablesData;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "PurchaseList")
public class PurchaseList {

    private PurchaseKey purchaseKey;
    private String studentName;
    private String courseName;
    private Integer price;
    private Date subscriptionDate;

    public PurchaseList(String studentName, String courseName) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.purchaseKey = new PurchaseKey(studentName, courseName);
    }

    public PurchaseList() {}

    @Column(name = "student_name", insertable = false, updatable = false)
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Column(name = "course_name", insertable = false, updatable = false)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Column(name = "subscription_date")
    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    @EmbeddedId
    public PurchaseKey getPurchaseKey() {
        return purchaseKey;
    }

    public void setPurchaseKey(PurchaseKey purchaseKey) {
        this.purchaseKey = purchaseKey;
    }

}
