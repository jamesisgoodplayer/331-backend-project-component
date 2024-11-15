package se331.lab.rest.service.participantservice;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.aboutparticipant.ParticipantDao;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.entity.Participant;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {
    final ParticipantDao participantDao;
    @Override
    public List<Participant> getAllparticipants() {
        return participantDao.getParticipant(Pageable.unpaged()).getContent();
    }
    public Page<Participant> getParticipant(Integer page, Integer pageSize) {
        return participantDao.getParticipant(PageRequest.of(page,pageSize));
    }
}
