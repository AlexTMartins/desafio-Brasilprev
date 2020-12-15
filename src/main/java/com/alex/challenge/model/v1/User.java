package com.alex.challenge.model.v1;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String document;
    
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY,
           cascade = CascadeType.ALL)
    private Address address;

    @Override
    public String toString() {
        return "User{" +
        				"name='" + name + '\'' +
        				", document='" + document + '\'' +
        			'}';
    }
}