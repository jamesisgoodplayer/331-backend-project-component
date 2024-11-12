package se331.lab.rest.service.organizerservice;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.aboutorganizer.OrganizerDao;
import se331.lab.rest.entity.Organizer;


@Service
@RequiredArgsConstructor
public class OrganizerServiceImpl implements OrganizerService {
    final OrganizerDao OrganizerDao;
    @Override
    public Integer getOrganizerSize(){
        return OrganizerDao.getOrganizerSize();
    }
    @Override
    public Page<Organizer> getOrganizers(Integer pageSize, Integer page){
        return  OrganizerDao.getOrganizers(pageSize,page);
    }
    @Override
    public  Organizer getOrganizer(Long id){
        return OrganizerDao.getOrganizer(id);
    }
    @Override
    public  Organizer save(Organizer organizer){
        return OrganizerDao.save(organizer);
    }
}
