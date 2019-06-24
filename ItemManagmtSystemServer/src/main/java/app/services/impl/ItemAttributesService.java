package app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dataobjects.ItemAttribute;
import app.repository.ItemAttributeRepository;
import app.services.api.IItemAttributesService;

@Service
public class ItemAttributesService implements IItemAttributesService {

	@Autowired
	private ItemAttributeRepository itemAttrRepo;
	
	@Override
	public Iterable<ItemAttribute> getItemsAttributes(){
		return itemAttrRepo.findAll();
	}
	
	@Override
	public Iterable<ItemAttribute> getItemAttributes(String itemCode){
		//return itemAttrRepo.findItemsAttributesByItemCode(itemCode);
		return null;
	}
}
