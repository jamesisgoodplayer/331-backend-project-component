package se331.lab.rest.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.repository.OrganizerRepository;


@Component
@RequiredArgsConstructor
public class OrganizerInitializer implements ApplicationListener<ApplicationReadyEvent> {
    final OrganizerRepository organizerRepository;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        organizerRepository.save(Organizer.builder()
                           .id(123L)
                           .name("Kat Laydee")
                           .address("China")
                           .build());
        organizerRepository.save(Organizer.builder()
                           .id(456L)
                           .name("Sarah Williams")
                           .address("CMU")
                           .build());
        organizerRepository.save(Organizer.builder()
                           .id(789L)
                           .name("Emily Johnson")
                           .address("USA")
                           .build());
        organizerRepository.save(Organizer.builder()
                           .id(111L)
                           .name("John Smith")
                           .address("USB")
                           .build());
  }
}
