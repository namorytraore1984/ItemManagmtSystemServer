package app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.dataobjects.ItemDO;

@Repository
public interface ItemRepository extends CrudRepository<ItemDO, Long> {

	Optional<ItemDO> findByItemCode(String itemCode);
}
