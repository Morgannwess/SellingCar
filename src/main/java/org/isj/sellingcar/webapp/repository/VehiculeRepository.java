/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.isj.sellingcar.webapp.repository;


import org.isj.sellingcar.webapp.model.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author nice
 */
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {

    Optional<Vehicule> findVehiculeByImmatriculation(String String);
    Optional<List<Vehicule>>findVehiculeByImmatriculationOrMarque(String motcle1, String motcle2);

    void deleteByImmatriculation(String immatriculation);

    Optional<List<Vehicule>>findVehiculeByisNew(boolean b);

    boolean existsByNumeroIgnoreCase(String immatriculation);

}
