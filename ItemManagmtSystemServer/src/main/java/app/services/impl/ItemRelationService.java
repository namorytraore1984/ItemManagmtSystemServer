package app.services.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import app.dataobjects.Item;
import app.services.api.IItemRelationService;

@Service
public class ItemRelationService implements IItemRelationService {
	
	@Override
	public List<Item> getRelatedItems(String itemCode){
		////List<Item> relatedItems = relatedItemRepo.getByItemCode(itemCode);
		return null;
	}

}
