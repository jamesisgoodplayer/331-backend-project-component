package se331.lab.rest.controlller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se331.lab.rest.service.participantservice.ParticipantService;
import se331.lab.rest.util.LabMapper;

@RestController
@RequiredArgsConstructor
public class ParticipantContorller {
    final ParticipantService participantService;
    @GetMapping("/participants")
    ResponseEntity<?> getParticipants(){
        return ResponseEntity.ok(LabMapper.INSTANCE.getParticipantDTO(participantService.getAllparticipants())
        );
    }
}
