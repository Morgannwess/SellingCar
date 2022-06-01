package org.isj.sellingcar.webapp.presentation.controller;

import java.util.ArrayList;
import java.util.List;


import org.isj.sellingcar.webapp.model.dto.VehiculeDTO;
import org.isj.sellingcar.webapp.model.entities.Vehicule;
import org.isj.sellingcar.webapp.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import com.google.common.collect.Lists;


@Controller
public class VehiculeController {

	@Autowired
	private IService iService;

	@GetMapping("/listevehicule")
	public String listVehicules(Model model) {

		//recuperation de la liste des vehicules

		final List<VehiculeDTO> vehicules = iService.listVehiculesDTO();

 		 List<VehiculeDTO> dtos= new  ArrayList<VehiculeDTO>() ;

		for (VehiculeDTO vehicule:vehicules) {

			VehiculeDTO vehiculeDTO = new VehiculeDTO();
			vehiculeDTO.setMarque(vehicule.getMarque());
			vehiculeDTO.setImmatriculation(vehicule.getImmatriculation());

			dtos.add(vehiculeDTO);

		}

		model.addAttribute("listVehicules", dtos);

		return "liste";
	}

	// Traitemement des valeurs saisies dans le formulaire
	@PostMapping("/enregistrervehiculeForm")
	public String enregistrerVehicule(@ModelAttribute VehiculeDTO vehiculeDto,
			Model model) {


		final Vehicule vehicule = new Vehicule();
		vehicule.setMarque(vehiculeDto.getMarque());
		vehicule.setImmatriculation(vehiculeDto.getImmatriculation());


		// appel de la couche service injectée pour enregistrer un vehicule
		iService.enregistrerVehicule(vehiculeDto);

		return "redirect:listevehicule";

		//return "liste" ;

	}

	//Afficharge du formulaire ou initialisation du formulaire
	@GetMapping("/admin/vehicule")
	public String pageEngregistrerVehicule(Model model) {

		model.addAttribute("vehiculeDto", new VehiculeDTO());

		return "enregistrer";
	}

	//affichage du formulaire
	@GetMapping("/enregistrervehiculeform")
	public String enregistrerActeForm(Model model){
		VehiculeDTO vehiculeDTO=new VehiculeDTO();
		vehiculeDTO.setImmatriculation("");
		model.addAttribute("vehiculeDTO",vehiculeDTO);
		return "enregistrer";
	}

	//affichage du formulaire d'edition d'un acte

	@GetMapping("/editerform")
	public String editerActeForm(@RequestParam(name="immatriculation")String immatriculation , Model model) {
		VehiculeDTO vehiculeDTO = iService.searchVehiculeByImmatriculation(immatriculation);

		model.addAttribute("vehiculeDTO", vehiculeDTO);
		return "editer";
	}






}
