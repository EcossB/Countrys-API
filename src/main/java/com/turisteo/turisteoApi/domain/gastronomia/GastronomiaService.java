package com.turisteo.turisteoApi.domain.gastronomia;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GastronomiaService {

    @Autowired
    private GastronomiaRepository repository;

    public List<GastronomiaEntity> guardarLista(List<GastronomiaDtoP> gastronomiaDtoPS){
        List<GastronomiaEntity> gastronomiaEntities = gastronomiaDtoPS.stream()
                .map(GastronomiaDtoP::toEntity)
                .collect(Collectors.toList());

        return repository.saveAll(gastronomiaEntities);
    }
}
