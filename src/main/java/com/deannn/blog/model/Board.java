package com.deannn.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob                            // 대용량 데이터
    private String content;         // 섬머노트 라이브러리. <html> 태그가 섞여 디자인됨.

    @ColumnDefault("0")
    private int count;      // 조회수

    @ManyToOne(fetch = FetchType.EAGER)// 다대일. Many: Board, One: User
    @JoinColumn(name = "userId")
    private User user;               // DB는 오브젝트를 저장할 수 없어 FK 사용. 자바는 오브젝트를 저장할 수 있다.

    @OneToMany(mappedBy = "board")
    private List<Reply> reply;

    @CreationTimestamp
    private Timestamp createDate;

}
