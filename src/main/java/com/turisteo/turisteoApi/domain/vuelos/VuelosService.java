package com.turisteo.turisteoApi.domain.vuelos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VuelosService {

    @Autowired
    private VuelosRepository vuelosRepository;

    public List<VuelosEntity> guardarLista(List<VuelosDtoP>vuelosDtoPS){
        List<VuelosEntity> vuelosEntities = vuelosDtoPS.stream()
                .map(VuelosDtoP::toEntity)
                .collect(Collectors.toList());

        return vuelosRepository.saveAll(vuelosEntities);
    }


}
