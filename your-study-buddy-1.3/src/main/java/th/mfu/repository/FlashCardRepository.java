package th.mfu.repository;

import org.springframework.data.repository.CrudRepository;

import th.mfu.domain.FlashCard;

public interface FlashCardRepository extends CrudRepository<FlashCard, Long>{
    FlashCard findByName(String name);
}
