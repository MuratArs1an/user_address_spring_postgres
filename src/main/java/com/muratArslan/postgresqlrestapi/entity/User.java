package com.muratArslan.postgresqlrestapi.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "User Entity")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "User id")
    private int id;
    @Column(name="name", length = 100)
    @ApiModelProperty(value = "User name")
    private String name;
    @Column(name="surname", length = 100)
    @ApiModelProperty(value = "User surname")
    private String surname;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="user_address_id")
    @ApiModelProperty(value = "User addresses List")
    private List<Address> addressList;
}
