package se331.lab.rest.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.entity.Participant;
import se331.lab.rest.repository.EventRepository;
import se331.lab.rest.repository.OrganizerRepository;
import se331.lab.rest.repository.ParticipantRepository;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    EventRepository eventRepository;
    final OrganizerRepository organizerRepository;
    final ParticipantRepository participantRepository;
    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Organizer org1,org2,org3;
        org1 = organizerRepository.save(Organizer.builder()
                .name("CAMT").build());
        org2 = organizerRepository.save(Organizer.builder()
                .name("CMU").build());
        org3 = organizerRepository.save(Organizer.builder()
                .name("ChiangMai").build());

        Participant p1,p2,p3,p4,p5;
        p1 = participantRepository.save(Participant.builder()
                .name("wusiyu")
                .telNo("75832420049")
                .build());
        p2 = participantRepository.save(Participant.builder()
                .name("xieminggang")
                .telNo("13458939500")
                .build());
        p3 = participantRepository.save(Participant.builder()
                .name("zhangqinglin")
                .telNo("13648238872")
                .build());
        p4 = participantRepository.save(Participant.builder()
                .name("liushuang")
                .telNo("12478465293")
                .build());
        p5 = participantRepository.save(Participant.builder()
                .name("wangxiaohong")
                .telNo("29867320595")
                .build());

                Event tempEvent;
                tempEvent=eventRepository.save(Event.builder()
                              .category("Academic")
                              .title("Midterm Exam")
                              .description("A time for taking the exam")
                              .location("CAMT Building")
                              .date("3rd Sept")
                              .time("3.00-4.00 pm.")
                              .petAllowed(false)
                              .build());
                tempEvent.setOrganizer(org1);
                tempEvent.getParticipants().add(p1);
                tempEvent.getParticipants().add(p2);
                tempEvent.getParticipants().add(p3);
                tempEvent.getParticipants().add(p5);
                org1.getOwnEvents().add(tempEvent);
                p1.getEventHistory().add(tempEvent);
                p2.getEventHistory().add(tempEvent);
                p3.getEventHistory().add(tempEvent);
                p5.getEventHistory().add(tempEvent);

                tempEvent = eventRepository.save(Event.builder()
                              .category("Academic")
                              .title("Commencement Day")
                              .description("A time for celebration")
                              .location("CMU Convention hall")
                              .date("21th Jan")
                              .time("8.00am-4.00 pm.")
                              .petAllowed(false)
                              .build());
                tempEvent.setOrganizer(org1);
                tempEvent.getParticipants().add(p1);
                tempEvent.getParticipants().add(p2);
                tempEvent.getParticipants().add(p4);
                org1.getOwnEvents().add(tempEvent);
                p1.getEventHistory().add(tempEvent);
                p2.getEventHistory().add(tempEvent);
                p4.getEventHistory().add(tempEvent);


                tempEvent=eventRepository.save(Event.builder()
                              .category("Cultural")
                              .title("Loy Krathong")
                              .description("A time for Krathong")
                              .location("Ping River")
                              .date("21th Nov")
                              .time("8.00-10.00 pm.")
                              .petAllowed(false)
                              .build());
                tempEvent.setOrganizer(org2);
                tempEvent.getParticipants().add(p3);
                tempEvent.getParticipants().add(p1);
                tempEvent.getParticipants().add(p4);
                tempEvent.getParticipants().add(p5);
                org2.getOwnEvents().add(tempEvent);
                p1.getEventHistory().add(tempEvent);
                p3.getEventHistory().add(tempEvent);
                p4.getEventHistory().add(tempEvent);
                p5.getEventHistory().add(tempEvent);

                tempEvent=eventRepository.save(Event.builder()
                              .category("Cultural")
                              .title("Songkran")
                              .description("Let's Play Water")
                              .location("Chiang Mai Moat")
                              .date("13th April")
                              .time("10.00am - 6.00 pm.")
                              .petAllowed(true)
                              .build());
                tempEvent.setOrganizer(org3);
                tempEvent.getParticipants().add(p2);
                tempEvent.getParticipants().add(p3);
                tempEvent.getParticipants().add(p5);
                tempEvent.getParticipants().add(p4);
                org3.getOwnEvents().add(tempEvent);
                p2.getEventHistory().add(tempEvent);
                p3.getEventHistory().add(tempEvent);
                p5.getEventHistory().add(tempEvent);
                p4.getEventHistory().add(tempEvent);
    }
}