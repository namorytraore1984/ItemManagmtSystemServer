package app.repository;

import org.springframework.data.repository.CrudRepository;

import app.models.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {
	Item findByItemCode(String itemCode);
}
