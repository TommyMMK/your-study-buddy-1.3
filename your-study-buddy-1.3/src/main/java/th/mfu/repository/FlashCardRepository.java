package th.mfu.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import th.mfu.domain.FlashCard;

public interface FlashCardRepository extends CrudRepository<FlashCard, Long>{
    FlashCard findByName(String name);
    List<FlashCard> findByNameContainingIgnoreCase(String name);
}
