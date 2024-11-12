package se331.lab.rest.controlller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.service.organizerservice.OrganizerService;

@Controller
@RequiredArgsConstructor
public class OrganizerController {
    final OrganizerService OrganizerService;
    @GetMapping("organizers")
    public ResponseEntity<?> getOrganizerLists(@RequestParam(value = "_limit",
            required = false)Integer perPage
            , @RequestParam(value = "_page",required = false)Integer page) {
        Page<Organizer> pageOutput = OrganizerService.getOrganizers(perPage, page);
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count",
                String.valueOf(pageOutput.getTotalElements()));
        return new
                ResponseEntity<>(pageOutput.getContent(), responseHeader, HttpStatus.OK);

    }
    @GetMapping("organizers/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id) {
        Organizer output = OrganizerService.getOrganizer(id);
        if (output != null) {
            return ResponseEntity.ok(output);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The give id is not fount");
        }
    }
    @PostMapping("/organizers")
    public ResponseEntity<?> addEvent(@RequestBody Organizer organizer) {
        Organizer output = OrganizerService.save(organizer);
        return  ResponseEntity.ok(output);
    }
}


