package com.turisteo.turisteoApi.domain.hotel;

import com.turisteo.turisteoApi.domain.LugaresFamosos.LugaresFamososEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<HotelEntity> guardarLista(List<HotelDtoP> hotelDtoPS){
        List<HotelEntity> hotelEntities = hotelDtoPS.stream()
                .map(HotelDtoP::toEntity)
                .collect(Collectors.toList());

        return hotelRepository.saveAll(hotelEntities);
    }
}
