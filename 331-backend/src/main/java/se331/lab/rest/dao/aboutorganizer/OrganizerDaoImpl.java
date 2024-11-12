package se331.lab.rest.dao.aboutorganizer;


import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Organizer;
import java.util.ArrayList;
import java.util.List;


@Repository
@Profile("organizerDao")
public class OrganizerDaoImpl implements OrganizerDao {
    List<Organizer> organizerList;
    @PostConstruct
    public void init(){
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(123L)
                .name("Kat Laydee")
                .address("China")
                .build());
        organizerList.add(Organizer.builder()
                .id(456L)
                .name("Sarah Williams")
                .address("CMU")
                .build());
        organizerList.add(Organizer.builder()
                .id(789L)
                .name("Emily Johnson")
                .address("USA")
                .build());
        organizerList.add(Organizer.builder()
                .id(111L)
                .name("John Smith")
                .address("USB")
                .build());

    }
    @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }
    @Override
    public Page<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizerList.size() : pageSize;
        int firstIndex = (page - 1) * pageSize;
        return new
                PageImpl<Organizer>(organizerList.subList(firstIndex,firstIndex + pageSize), PageRequest.of(page,
                pageSize),organizerList.size());
    }
    @Override
    public Organizer getOrganizer(Long id) {
        return organizerList.stream().filter(event ->
                event.getId().equals(id)).findFirst().orElse(null);
    }
    @Override
    public Organizer save(Organizer organizer) {
        organizer.setId(organizerList.get(organizerList.size()-1).getId()+1);
        organizerList.add(organizer);
        return organizer;
    }
}
