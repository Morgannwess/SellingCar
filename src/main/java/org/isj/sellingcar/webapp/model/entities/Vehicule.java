package org.isj.sellingcar.webapp.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    private String immatriculation;
    private String marque;
    private boolean isNew;
    private String BoiteVitesse;
    private String Année;
    private String Prix;
    private String Places;
    private String Carburant;


}
