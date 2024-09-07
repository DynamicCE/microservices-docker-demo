package com.erkan.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "addresses")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"}) // idler birbirine eşitse bu nesneler aynıdır
@ToString
public
class Address implements Serializable {
    @Id
    @SequenceGenerator ( name = "seq_person_address",allocationSize = 1)
    @GeneratedValue(generator = "seq_person_address",strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "address",length = 500)
    private String address;

    @Enumerated
    private AddressType addressType;

    @Column(name = "is_active")
    private Boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    public enum AddressType{
        HOME_ADDRESS,
        WORK_ADDRESS,
        OTHER
    }
}
