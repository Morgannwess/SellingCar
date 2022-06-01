package org.isj.sellingcar.webapp.presentation.api;


import org.isj.sellingcar.webapp.model.dto.VehiculeDTO;
import org.isj.sellingcar.webapp.model.entities.Vehicule;
import org.isj.sellingcar.webapp.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Selling-Car/api")
public class VehiculeControlerRest {

    @Autowired
    private IService iService;


    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public int enregistrerVehicule(@RequestBody Vehicule vehicule) {

        return iService.enregistrerVehicule(new VehiculeDTO());
    }

    @RequestMapping(value="/vehicules", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VehiculeDTO> listVehicules() {
        return iService.listVehiculesDTO();
    }

    @RequestMapping(value = "/vehicule/{immatriculation}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public VehiculeDTO rechercherVehicule(@PathVariable String immatriculation) {

        return iService.searchVehiculeByImmatriculation(immatriculation);
    }

    @GetMapping("/all")
    public ResponseEntity<List<VehiculeDTO>> getAllVehicules() {
        return ResponseEntity.ok(iService.listVehiculesDTO());
    }

    @GetMapping("/{immatriculation}/delete")
    public void deleteVehicule(@PathVariable String immatriculation) {
        iService.deleteVehicule(immatriculation);
    }


}
