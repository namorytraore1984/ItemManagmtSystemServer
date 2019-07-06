package app.services.api;

import java.util.List;

import app.dataobjects.ItemDO;

public interface IItemRelationService {

	public List<ItemDO> getRelatedItems(String itemCode);
}
