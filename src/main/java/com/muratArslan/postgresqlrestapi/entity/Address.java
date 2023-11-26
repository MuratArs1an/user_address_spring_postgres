package com.muratArslan.postgresqlrestapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name="user_address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"id"})
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "address")
    String address;
    @Enumerated
    AddressType addressType;
    @Column(name = "is_active")
    private Boolean isActive;
    @ManyToOne
    @JoinColumn(name = "user_address_id")
    private User user;

    public enum AddressType{
        HOME_ADDRESS,
        WORK_ADDRESS,
        OTHER
    }

}
