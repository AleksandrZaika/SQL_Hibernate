package TablesData;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Courses")
public class Course implements Serializable {

    private Integer id;
    private String name;
    private Integer duration;
    private CourseType type;
    private String description;
    private Teacher teacher;
    private Integer studentsCount;
    private Integer price;
    private Float pricePerHour;
    private List<Student> students;
    private List<Subscription> subscriptions;
    private List<LinkedPurchaseList> linkedPurchaseList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, insertable=false, updatable=false)
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getDuration() {
        return duration;
    }

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    public CourseType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Teacher getTeacher() {
        return teacher;
    }

    @Column(name = "students_count")
    public Integer getStudentsCount() {
        return studentsCount;
    }

    public Integer getPrice() {
        return price;
    }

    @Column(name = "price_per_hour")
    public Float getPricePerHour() {
        return pricePerHour;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setType(CourseType type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTeacherId(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setStudentsCount(Integer studentsCount) {
        this.studentsCount = studentsCount;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setPricePerHour(Float pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Subscriptions",
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")})
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @OneToMany(mappedBy = "course")
    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @OneToMany(mappedBy = "course")
    public List<LinkedPurchaseList> getLinkedPurchaseList() {
        return linkedPurchaseList;
    }

    public void setLinkedPurchaseList(List<LinkedPurchaseList> linkedPurchaseList) {
        this.linkedPurchaseList = linkedPurchaseList;
    }
}
