package se331.lab.rest.service.eventservice;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.aboutevent.EventDao;
import se331.lab.rest.dao.aboutorganizer.OrganizerDao;
import se331.lab.rest.dao.aboutparticipant.ParticipantDao;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.entity.Participant;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    final EventDao eventDao;
    final OrganizerDao organizerDao;
    final ParticipantDao participantDao;
    @Override
    public Integer getEventSize(){
        return eventDao.getEventSize();
    }
    @Override
    public Page<Event> getEvents(Integer pageSize, Integer page){
        return eventDao.getEvents(pageSize,page);
    }
    @Override

    public  Event getEvent(Long id){
        return  eventDao.getEvent(id);
    }
    @Override
    @Transactional
    public Event save(Event event){
        Organizer organizer =
        organizerDao.findById(event.getOrganizer().getId()).orElse(null);
        event.setOrganizer(organizer);
        if (organizer != null) {
        organizer.getOwnEvents().add(event);
        }
        List<Participant> validParticipants = new ArrayList<>();
        for(Participant participant : event.getParticipants()) {
            Participant foundParticipant = participantDao.findById(participant.getId()).orElse(null);
            if (foundParticipant != null) {
                validParticipants.add(foundParticipant);
                foundParticipant.getEventHistory().add(event);
            }
            event.setParticipants(validParticipants);
        }
        return eventDao.save(event);
    }
    @Override
    public Page<Event> getEvents(String title, Pageable pageable){
        return eventDao.getEvents(title,pageable);
    }
}
