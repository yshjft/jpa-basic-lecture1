package hellojpa;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq", initialValue = 1, allocationSize = 50)
// @Table(name = "MBR") // MBR이라는 table에 매핑
// @TableGenerator(name = "MEMBER_SEQ_GENERATOR", table = "MY_SEQUENCES", pkColumnValue = "MEMBER_SEQ", allocationSize = 1) // table을 이요한 기본키 매핑
public class Member {
    // 직접 ID 할당 : @Id
    // ID 자동 할당 : @ID + @GeneratedValue(strategy = GenerationType.?????)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
             generator = "member_seq_generator"
            // generator = "MEMBER_SEQ_GENERATOR"
    )
    private Long id;

    @Column(name="name", nullable = false)
    private String username;

    @Column
    private BigDecimal age;

    // enum 타입을 필드로 설정한 경우
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    // DATE: 날짜
    // TIME: 시간
    // TIMESTAMP: 날짜 + 시간
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    // DATE type
    private LocalDate testLocalDate;

    // TIMESTAMP type
    private LocalDateTime testLocalDateTime;

    // varchar를 넘어서는 경우 @Lob을 사용
    // @Lob + String = clob
    @Lob
    private String description;

    // JPA는 생성자를 작성할 경우 항상 함께 기본 생성자를 작성할 것
    public Member(){ };

    public void setUsername(String username) {
        this.username = username;
    }
}
