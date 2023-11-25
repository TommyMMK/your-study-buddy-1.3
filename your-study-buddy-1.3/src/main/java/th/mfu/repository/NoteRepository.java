package th.mfu.repository;

import org.springframework.data.repository.CrudRepository;

import th.mfu.domain.Note;

public interface NoteRepository extends CrudRepository<Note, Long> {

}
