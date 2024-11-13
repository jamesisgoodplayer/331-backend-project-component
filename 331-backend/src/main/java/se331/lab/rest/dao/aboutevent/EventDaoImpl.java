package se331.lab.rest.dao.aboutevent;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Event;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("manual")
public class EventDaoImpl implements EventDao {
    List<Event> eventList;

    @PostConstruct
    public void init(){
        eventList = new ArrayList<>();
        eventList.add(Event.builder()
                .id(123L)
               .category("animal welfare")
               .title("Cat Adoption Day")
               .description("Find your new feline friend at this event.")
               .location("Meow Town")
               .date("January 28, 2022")
               .time("12:00")
               .petAllowed(true)
               .build());
        eventList.add(Event.builder()
                .id(456L)
                .category("food")
                .title("Community Gardening")
                .description("Join us as we tend to the community edible plants.")
                .location("Flora City")
                .date("March 14, 2022")
                .time("10:00")
                .petAllowed(true)
                .build());
        eventList.add(Event.builder()
                .id(789L)
                .category("art")
                .title("Art Exhibition")
                .description("View the latest collection of contemporary art.")
                .location("Gallery Modern")
                .date("May 15, 2022")
                .time("14:00")
                .petAllowed(true)
                .build());

        eventList.add(Event.builder()
                .id(101L)
                .category("sports")
                .title("Community Soccer Game")
                .description("Join our local soccer team for a friendly match.")
                .location("Field Park")
                .date("June 30, 2022")
                .time("18:00")
                .petAllowed(false)
                .build());

        eventList.add(Event.builder()
                .id(222L)
                .category("education")
                .title("Science Workshop")
                .description("Learn about the latest scientific discoveries.")
                .location("Knowledge Center")
                .date("July 10, 2022")
                .time("10:00")
                .petAllowed(true)
                .build());

        eventList.add(Event.builder()
                .id(555L)
                .category("charity")
                .title("Charity Run")
                .description("Participate in a charity run to support a good cause.")
                .location("Running Park")
                .date("August 5, 2022")
                .time("09:00")
                .petAllowed(false)
                .build());
    }
    @Override
    public Integer getEventSize() {
             return eventList.size();
         }
    @Override
    public Page<Event> getEvents(Integer pageSize, Integer page) {
            pageSize = pageSize == null ? eventList.size() : pageSize;
            int firstIndex = (page - 1) * pageSize;
        return new
                PageImpl<Event>(eventList.subList(firstIndex, firstIndex + pageSize), PageRequest.of(page,
                pageSize),eventList.size());
    }
   @Override
    public Event getEvent(Long id) {
       return eventList.stream().filter(event ->
               event.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
     public Event save(Event event){
        event.setId(eventList.get(eventList.size()-1).getId()+1);
        eventList.add(event);
        return event;
    }

}

