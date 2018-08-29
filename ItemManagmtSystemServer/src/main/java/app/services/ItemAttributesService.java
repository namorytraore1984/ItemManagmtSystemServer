package app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.models.ItemAttribute;
import app.repository.ItemAttributeRepository;

@Service
public class ItemAttributesService {

	@Autowired
	private ItemAttributeRepository itemAttrRepo;
	
	public Iterable<ItemAttribute> getItemsAttributes(){
		return itemAttrRepo.findAll();
	}
	
	public Iterable<ItemAttribute> getItemAttributes(String itemCode){
		//return itemAttrRepo.findItemsAttributesByItemCode(itemCode);
		return null;
	}
}
