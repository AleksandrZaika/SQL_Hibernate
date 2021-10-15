package TablesData;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchaseList implements Serializable {

    private Course course;
    private Student student;
    private Date subscriptionDate;

    public  LinkedPurchaseList () {}

    public LinkedPurchaseList(Student student, Course course) {
        this.student = student;
        this.course = course;

    }

    @Id
    @Column(name = "student_id", columnDefinition = "int(10) unsigned", nullable = false)
    public Integer getStudentId() {
        return student.getId();
    }

    public void setStudentId(Integer id) {
        student.setId(id);
    }

    @Id
    @Column(name = "course_id", columnDefinition = "int(10) unsigned", nullable = false)
    public Integer getCourseId() {
        return course.getId();
    }

    public void setCourseId(Integer id) {
        course.setId(id);
    }

    @Column(name = "price", columnDefinition = "int(10) unsigned", nullable = false)
    public Integer getPrice() {
        return course.getPrice();
    }

    public void setPrice(Integer price) {
        course.setPrice(price);
    }

    @Column(name = "date", columnDefinition = "datetime", nullable = false)
    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    @ManyToOne
    @MapsId("courseId")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @ManyToOne
    @MapsId("studentId")
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
