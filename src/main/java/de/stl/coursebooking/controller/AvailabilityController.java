package de.stl.coursebooking.controller;

import de.stl.coursebooking.dto.AvailabilityDto;
import de.stl.coursebooking.model.Availability;
import de.stl.coursebooking.service.IAvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
 * @author Alissa, Zahra
 *
 */
@Controller
public class AvailabilityController {

    @Autowired
    private IAvailabilityService availabilityService;

    @GetMapping("/manage-availability")
    public String createAvailView() {
        return "manageAvail";
    }

    @RequestMapping(value="/availabilities/{lecturer}", method = RequestMethod.GET)
    @ResponseBody
    public List<Availability> getAvailabilities(@PathVariable("lecturer") String lecturer) {
        return availabilityService.findByLecturer(lecturer);
    }

    @PostMapping("/availabilities")
    @ResponseBody
    public void createAvails(@RequestBody AvailabilityDto availabilityDto) {
        availabilityService.save(availabilityDto);
    }

    @GetMapping("/availabilities")
    @ResponseBody
    public List<Availability> getAllAvails() {
        return availabilityService.findAll();
    }

    @DeleteMapping("/availabilities/{id}")
    @ResponseBody
    public void deleteAvail(@PathVariable("id") String id) {
        availabilityService.deleteAvail(Long.parseLong(id));
    }
}