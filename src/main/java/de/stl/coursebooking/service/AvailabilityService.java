package de.stl.coursebooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import de.stl.coursebooking.dto.AvailabilityDto;
import de.stl.coursebooking.model.Availability;
import de.stl.coursebooking.repository.AvailabilityRepository;
/*
 * @author Ajini, Alghazi, Al_Mahamed
 *
 */
@Service
public class AvailabilityService implements IAvailabilityService {
    @Autowired
    private AvailabilityRepository availabilityRepository;

    @Override
    public List<Availability> findByLecturer(String email) {
        return availabilityRepository.findByLecturer(email);
    }

    @Override
    public void save(AvailabilityDto availabilityDto) {
        Availability availability = new Availability(availabilityDto.getLecturer(), availabilityDto.getWeekday(), availabilityDto.getStartsAt(), availabilityDto.getEndsAt());
        try {
            availabilityRepository.save(availability);
        } catch(DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Availability exists already");
        }
    }

    @Override
    public boolean exists(AvailabilityDto availabilityDto) {
        Availability avails = availabilityRepository.findAvailabilityByLecturerAndWeekdayAndEndsAtAndStartsAt(availabilityDto.getLecturer(), availabilityDto.getWeekday(), availabilityDto.getEndsAt(), availabilityDto.getStartsAt());
        return avails != null;
    }

    @Override
    public List<Availability> findAll() {
        return availabilityRepository.findAll();
    }

    @Override
    public void deleteAvail(Long id) {
        availabilityRepository.deleteAvailabilityById(id);
    }
}
