package se331.lab.rest.service.participantservice;

import org.springframework.data.domain.Page;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.entity.Participant;

import java.util.List;

public interface ParticipantService {
    List<Participant> getAllparticipants();
    Page<Participant> getParticipant(Integer page, Integer pageSize);
}
