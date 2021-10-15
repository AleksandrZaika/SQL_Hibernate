package TablesData;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Subscriptions")
public class Subscription implements Serializable {

    private SubscriptionKey subscriptionKey;
    private Course course;
    private Student student;
    private Date subscriptionDate;

    public Subscription() {}

    public Subscription(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.subscriptionKey = new SubscriptionKey(student.getId(), course.getId());
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("studentId")
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("courseId")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Column(name = "subscription_date")
    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    @EmbeddedId
    public SubscriptionKey getSubscriptionKey() {
        return subscriptionKey;
    }

    public void setSubscriptionKey(SubscriptionKey subscriptionKey) {
        this.subscriptionKey = subscriptionKey;
    }
}
