package com.muratArslan.postgresqlrestapi.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "Address Entity ")
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Address id")
    private Long id;
    @Column(name = "address")
    @ApiModelProperty(value = "Address Description")
    String address;
    @Enumerated
    @ApiModelProperty(value = "Address Type Enum")
    AddressType addressType;
    @Column(name = "is_active")
    @ApiModelProperty(value = "Address Activation Statue")
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
