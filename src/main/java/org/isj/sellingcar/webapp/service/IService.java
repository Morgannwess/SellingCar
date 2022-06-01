package org.isj.sellingcar.webapp.service;



import org.isj.sellingcar.webapp.model.dto.VehiculeDTO;
import org.isj.sellingcar.webapp.model.entities.Vehicule;

import java.util.List;



public interface IService {

	 int enregistrerVehicule(VehiculeDTO vehiculeDTO);

	 List<VehiculeDTO> listVehiculesDTO();

	int deleteVehicule(String immatriculation);

	VehiculeDTO searchVehiculeByImmatriculation(String immatriculation);

	List<VehiculeDTO> searchVehiculeByKeyword(String keyword);

	VehiculeDTO updateVehicule (VehiculeDTO vehiculeDTO);
}
