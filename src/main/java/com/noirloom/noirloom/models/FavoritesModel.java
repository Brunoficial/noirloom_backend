package com.noirloom.noirloom.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="favorites")
public class FavoritesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private UserModel user;

    @ManyToMany
    @JoinTable(
            name = "favoritesList_items",
            joinColumns = @JoinColumn(name = "favorites_list_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<ItemModel> items;
}


