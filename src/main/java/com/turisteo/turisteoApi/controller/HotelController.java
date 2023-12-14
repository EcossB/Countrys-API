package com.turisteo.turisteoApi.controller;

import com.turisteo.turisteoApi.domain.hotel.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotel")
@SecurityRequirement(name = "bearer-key")
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private HotelService service;

    @PostMapping
    public ResponseEntity<HotelDtoG> guardarHoteles(@RequestBody @Valid HotelDtoP hotelDtoP , UriComponentsBuilder builder){
        System.out.println("El post fue correcto");

        HotelEntity hotel = hotelRepository.save(new HotelEntity(hotelDtoP));

        HotelDtoG hotelDtoG = new HotelDtoG(hotel.getId(), hotel.getNombre_hotel(), hotel.getValoracion(), hotel.getImagen_hotel(),
                hotel.getPaisEntity());

        URI url = builder.path("/hotel/{id}").buildAndExpand(hotel.getId()).toUri();

        return ResponseEntity.created(url).body(hotelDtoG);
    }


    @GetMapping
    public ResponseEntity<Page<HotelDtoG>> listadeHoteles(@PageableDefault(size = 10)Pageable pageable){

        return ResponseEntity.ok(hotelRepository.findAll(pageable).map(HotelDtoG::new));

    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarHoteles(@RequestBody @Valid HotelDtoPut actualizarHoteles){

        HotelEntity hotel = hotelRepository.getReferenceById(actualizarHoteles.id());

        hotel.actualizarHoteles(actualizarHoteles);

        return ResponseEntity.ok(new HotelDtoG(hotel.getId(), hotel.getNombre_hotel(), hotel.getValoracion(), hotel.getImagen_hotel(),
                hotel.getPaisEntity()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarHotel(@PathVariable Long id){
        Optional<HotelEntity> optionalHotel = hotelRepository.findById(id);

        if (optionalHotel.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        hotelRepository.deleteById(id);

        return ResponseEntity.noContent().build();

    }

    @PostMapping(path = "/guardar")
    public ResponseEntity<List<HotelEntity>> guardarListaHoteles(@RequestBody @Valid List<HotelDtoP> hotelDtoPList, UriComponentsBuilder builder){
        System.out.println("Post con listas de hoteles correcto");
        List<HotelEntity> hotelEntities = service.guardarLista(hotelDtoPList);

        URI url = builder.path("hotel/guardar/{id}").buildAndExpand(hotelEntities.get(0)).toUri();

        return ResponseEntity.created(url).body(hotelEntities);
    }

}
