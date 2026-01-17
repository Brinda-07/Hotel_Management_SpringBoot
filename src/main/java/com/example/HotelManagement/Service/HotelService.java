package com.example.HotelManagement.Service;

import com.example.HotelManagement.DTO.HotelDTO;
import com.example.HotelManagement.DTO.UpdateHotelAddDTO;
import com.example.HotelManagement.Entity.Hotel;
import com.example.HotelManagement.Repository.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {
    @Autowired
    HotelRepo hotelRepo;
    public Hotel saveHotel(HotelDTO hotelDTO) {
        Hotel hotel=new Hotel();
        hotel.setName(hotelDTO.getName());
        hotel.setAddress(hotelDTO.getAddress());
        hotel.setCity(hotelDTO.getCity());
        hotel.setPostalCode(hotelDTO.getPostalCode());
        hotel.setAvailable(hotelDTO.isAvailable());
        hotel.setRating(hotelDTO.getRating());
        hotelRepo.save(hotel);
        return hotel;

    }

    public List<Hotel> getAllHotels() {
       return hotelRepo.findAll();
    }

    public Hotel getHotelById(Long id) {

        Optional<Hotel> hotelbox= hotelRepo.findById(id);
        if(hotelbox.isPresent())
        {
            return hotelbox.get();
        }
        else
            return null;
    }

    public Hotel updateHotel( HotelDTO hotelDTO,Long id) {
        Hotel hotel=getHotelById((id));
        if(hotel!=null)
        {
            ;
            hotel.setName(hotelDTO.getName());
            hotel.setAddress(hotelDTO.getAddress());
            hotel.setCity(hotelDTO.getCity());
            hotel.setPostalCode(hotelDTO.getPostalCode());
            hotel.setAvailable(hotelDTO.isAvailable());
            hotel.setRating(hotelDTO.getRating());
            hotelRepo.save(hotel);
            return hotel;

        }
        else
            return hotel;
    }

    public void deleteHotel(Long id) {
        Hotel hotel=getHotelById(id);
        if(hotel!=null)
        hotelRepo.deleteById(id);
    }

    public Hotel updateHotelAddress(UpdateHotelAddDTO updateHotelAddDTO, Long id) {
        Hotel hotel=getHotelById(id);
        if(hotel!=null)
        {
            hotel.setAddress(updateHotelAddDTO.getAddress());
            hotel.setCity(updateHotelAddDTO.getCity());
            hotel.setPostalCode(updateHotelAddDTO.getPostalCode());
            hotelRepo.save(hotel);
            return hotel;
        }
        return hotel;

    }
}
