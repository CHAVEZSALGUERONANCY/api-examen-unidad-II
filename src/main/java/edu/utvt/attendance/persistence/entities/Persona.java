package edu.utvt.attendance.persistence.entities;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "te_personas")
public class Persona {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(nullable = false)
    private int edad;

    @Column(length = 100, nullable = false)
    private String universidad;

    @Column(length = 50, nullable = false)
    private String correo;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date fechaDeNacimiento;

    @OneToMany(mappedBy = "persona")
    private List<edu.utvt.attendance.persistence.entities.Item> items;
}