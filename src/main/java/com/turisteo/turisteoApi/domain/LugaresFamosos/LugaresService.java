package com.turisteo.turisteoApi.domain.LugaresFamosos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LugaresService {

    @Autowired
    private LugaresRepository lugaresRepository;

    public List<LugaresFamososEntity> guardarLista(List<LugaresFamososDtoP> lugaresFamososDtoPList) {
        List<LugaresFamososEntity> lugaresFamososEntityList = lugaresFamososDtoPList.stream()
                .map(LugaresFamososDtoP::toEntity)
                .collect(Collectors.toList());

        return lugaresRepository.saveAll(lugaresFamososEntityList);
    }


}
