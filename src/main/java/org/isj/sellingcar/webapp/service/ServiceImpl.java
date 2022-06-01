package org.isj.sellingcar.webapp.service;


import org.isj.sellingcar.webapp.mapper.VehiculeMapper;
import org.isj.sellingcar.webapp.model.dto.VehiculeDTO;
import org.isj.sellingcar.webapp.model.entities.Vehicule;
import org.isj.sellingcar.webapp.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceImpl implements IService {

    @Autowired
    private VehiculeRepository vehiculeRepository;
    @Autowired
    private VehiculeMapper vehiculeMapper;





    @Override
    public int enregistrerVehicule(VehiculeDTO vehiculeDTO) {
        return vehiculeRepository.save(vehiculeMapper.toEntity(vehiculeDTO)).getId().intValue();
    }

    @Override
    public List<VehiculeDTO> listVehiculesDTO() {
        List<Vehicule> Vehicules= vehiculeRepository.findAll();
        return Vehicules.stream().map(vehicule -> vehiculeMapper.toDto(vehicule)).collect(Collectors.toList());
    }

    @Override
    public int deleteVehicule(String immatriculation) {
        vehiculeRepository.deleteByImmatriculation(vehiculeRepository.findVehiculeByImmatriculation(immatriculation).get().getImmatriculation());
        return 1;
    }

    @Override
    public VehiculeDTO searchVehiculeByImmatriculation(String immatriculation) {

        return vehiculeMapper.toDto(vehiculeRepository.findVehiculeByImmatriculation(immatriculation).get());

    }

    @Override
    public List<VehiculeDTO> searchVehiculeByKeyword(String keyword) {
        return vehiculeRepository.findVehiculeByImmatriculationOrMarque(keyword,keyword).get().stream()
                //.map(vehicule ->VehiculeMapper.toDto(vehicule))
                .map(vehiculeMapper::toDto)
                .collect(Collectors.toList());

    }

    @Override
    public VehiculeDTO updateVehicule(VehiculeDTO vehiculeDTO) {
        System.out.println(vehiculeDTO.getImmatriculation());
        Vehicule vehicule=vehiculeRepository.findVehiculeByImmatriculation(vehiculeDTO.getImmatriculation()).get();
        vehiculeMapper.copy(vehiculeDTO,vehicule);

        return vehiculeMapper.toDto(vehiculeRepository.save(vehicule));
    }


}
