package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
// @Table(name = "MBR") // MBR이라는 table에 매핑
public class Member {
    @Id
    private Long id;
    private String name;
    private int age;

    // JPA는 생성자를 작성할 경우 항상 함께 기본 생성자를 작성할 것
    public Member(){ };

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
