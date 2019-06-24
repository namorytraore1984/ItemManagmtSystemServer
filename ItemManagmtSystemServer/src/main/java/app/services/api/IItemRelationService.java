package app.services.api;

import java.util.List;

import app.dataobjects.Item;

public interface IItemRelationService {

	public List<Item> getRelatedItems(String itemCode);
}
