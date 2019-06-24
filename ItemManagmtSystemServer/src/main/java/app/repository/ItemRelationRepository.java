package app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import app.dataobjects.ItemRelation;

public interface ItemRelationRepository extends CrudRepository<ItemRelation, Long> {
	public List<ItemRelation> getByItemCode(String itemCode);
}
