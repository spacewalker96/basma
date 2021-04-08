package com.store.basma.enity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "roles")
public class Role implements Serializable {


                @Id
                @Column(name = "role_id")
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                private Long id;
                private String name;

    public Role() {

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
