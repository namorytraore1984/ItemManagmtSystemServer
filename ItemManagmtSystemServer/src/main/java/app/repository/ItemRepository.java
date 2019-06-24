package app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.dataobjects.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

	Optional<Item> findByItemCode(String itemCode);
}
