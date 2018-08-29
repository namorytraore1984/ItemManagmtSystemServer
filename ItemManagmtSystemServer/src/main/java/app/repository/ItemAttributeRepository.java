package app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import app.models.ItemAttribute;

public interface ItemAttributeRepository extends CrudRepository<ItemAttribute, Long> {

	List<ItemAttribute> findByItemCode(String itemCode);
}
