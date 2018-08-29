package app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.models.Item;
import app.repository.ItemRelationRepository;

@Service
public class ItemRelationService {
	
	@Autowired
	ItemRelationRepository relatedItemRepo;
	
	public List<Item> getRelatedItems(String itemCode){
		
		//List<Item> relatedItems = relatedItemRepo.getByItemCode(itemCode);
		
		return null;
	}

}
