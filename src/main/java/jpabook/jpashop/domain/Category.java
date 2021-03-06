package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
public class Category extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    // 셀프 매핑 가능
    @ManyToOne(fetch = LAZY) // 자식 입장에서 한 개
    @JoinColumn(name = "PARENT_ID")
    private Category parent; // 상위 카테고리

    @OneToMany
    private List<Category> child = new ArrayList<>(); // 자식 카테고리

    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM",
            joinColumns = @JoinColumn(name = "CATEGORY_ID" ), // 나의 조인
            inverseJoinColumns = @JoinColumn (name = "ITEM_ID")) // 반대쪽의 조인
    private List<Item> items = new ArrayList<>();
}
