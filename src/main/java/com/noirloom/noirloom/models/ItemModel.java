package com.noirloom.noirloom.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="items")
public class ItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="description", nullable = true)
    private String description;

    @Column(name="type", nullable = false)
    private String type;

    @Column(name="sex", nullable = false)
    private String sex;

    @Column(name="costPrice", nullable = false)
    private float costPrice;

    @Column(name="sellPrice", nullable = false)
    private float sellPrice;
}
