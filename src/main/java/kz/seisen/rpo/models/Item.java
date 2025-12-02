package kz.seisen.rpo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int price;



    @ManyToOne(fetch = FetchType.EAGER)
    private Country country;


    @ManyToMany(fetch = FetchType.EAGER)
    private List<Category> categories;



}
