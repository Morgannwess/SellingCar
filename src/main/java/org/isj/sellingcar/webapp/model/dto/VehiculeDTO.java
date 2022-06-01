package org.isj.sellingcar.webapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculeDTO {

    private String marque;
    private String immatriculation;
    private boolean isNew;
    private String boiteVitesse;
    private String année;
    private String prix;
    private String places;
    private String carburant;

}
