package com.muratArslan.postgresqlrestapi.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "user_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name", length = 100)
    private String name;
    @Column(name="surname", length = 100)
    private String surname;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="user_address_id")
    private List<Address> addressList;
}
