package th.mfu.repository;

import org.springframework.data.repository.CrudRepository;

import th.mfu.domain.StudyRoom;

public interface StudyRoomRepository extends CrudRepository<StudyRoom, Long>{
    
}
