package com.bbva.postulanteuni.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name ="postulante")
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class PostulantEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellido")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "estado")
    private String status;

    @Column(name = "carrera")
    private String profession;
}
