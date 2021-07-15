package com.deannn.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.ValueGenerationType;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@DynamicInsert
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)        // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
    private int id;                 // 시퀀스, auto_increment

    @Column(nullable = false, length = 30)
    private String username;        // ID

    @Column(nullable = false, length = 100)                     // 해쉬로 암호화 해야 하기 때문에 넉넉히
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

//    @ColumnDefault("'user'")
    @Enumerated(EnumType.STRING)
    private RoleType role;          // ADMIN, USER

    @CreationTimestamp
    private Timestamp createDate;

}
