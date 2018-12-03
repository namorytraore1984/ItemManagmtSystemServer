package app.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.models.Item;
import app.models.ItemAttribute;
import app.models.ItemRelation;
import app.repository.ItemAttributeRepository;
import app.repository.ItemRelationRepository;
import app.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	ItemRelationRepository relatedItemsRepo;
	@Autowired
	private ItemAttributeRepository itemAttributeRepo;
	
	
	public void addItem(Item item) throws Exception
	{
		if ( item == null ) {
			throw new Exception();
		};
		//save item instance
		itemRepository.save(item);
		
		//save item attribute
		addItemAttributes(item);
		//save related
	}
	
	public Item getItem(String itemCode) 
	{
		
		Item item = itemRepository.findByItemCode(itemCode);
		if ( item == null ) return null;
		//set item attribute
		List<ItemAttribute> itemAttributes = findItemAttributes(itemCode);
		item.setAttributes(itemAttributes);
		List<Item> relatedItems = findRelatedItems(itemCode);
		item.setRelatedItems(relatedItems);	
		return item;
	}
	
	public List<Item> getItems()
	{
		List<Item> items = new ArrayList<Item>();
		List<ItemAttribute> itemAttributes;
		List<Item> relatedItems;
		Iterable<Item> itemsFromRepo =  itemRepository.findAll();
		
		for(Item item : itemsFromRepo) {
			
			if ( item == null ) continue;
			String itemCode = item.getItemCode();
			itemAttributes = findItemAttributes(itemCode);
			item.setAttributes(itemAttributes);
			//set related items
			relatedItems = findRelatedItems(itemCode);
			item.setRelatedItems(relatedItems);			
			items.add(item);
		}
		
		return items;
	}
	
	public Item getItem(Long id)
	{
		Item item = new Item();
		return item;
	}

	
	public String createItem(String itemCode, String itemType, String itemcreationType)
	{
		Item item = new Item();
		item.setItemCode(itemCode);
		item.setType(itemType);
		item.setOrigin(itemcreationType);
		
		itemRepository.save(item);
		return "saved";
	}
	
	public List<ItemAttribute> findItemAttributes(String itemCode)
	{
		List<ItemAttribute> iterItemAttributes = itemAttributeRepo.findByItemCode(itemCode);
		if ( iterItemAttributes == null || iterItemAttributes.size() == 0 ) return null;
		return iterItemAttributes;
	}
	
	public List<Item> findRelatedItems(String itemCode)
	{
		List<ItemRelation> itemRelations = relatedItemsRepo.getByItemCode(itemCode);
		if ( itemRelations == null || itemRelations.size() == 0 ) return null;
		List<Item> relatedItems = new ArrayList<Item>();
		for ( ItemRelation ir : itemRelations ) {
			if ( ir == null ) continue;
			String relatedItemCode = ir.getRelatedItemCode();
			Item relatedItem = itemRepository.findByItemCode(relatedItemCode);
			List<ItemAttribute> relatedItemAttributes = findItemAttributes(relatedItemCode);
			relatedItem.setAttributes(relatedItemAttributes);
			relatedItems.add(relatedItem);
		}
		return relatedItems;
	}
	
	public void addItemAttributes(Item item) 
	{
		
		if ( item == null ) {
			//throw new Exception();
		}
		String itemCode = item.getItemCode();
		List<ItemAttribute> itemAttributes = item.getAttributes();
		for ( ItemAttribute itemAttribute : itemAttributes ) {
			itemAttribute.setItemCode(itemCode);
			itemAttributeRepo.save(itemAttribute);
		}
	}

	public void deleteItem(String itemCode) 
	{
		//itemRepository.delete(itemCode);
	}
	
	public void deleteItems() 
	{
		itemRepository.deleteAll();	
	}

	public void updateItem(String itemCode) {
		// TODO Auto-generated method stub
		
	}

	public void patchItem(String itemCode) {
		// TODO Auto-generated method stub
		
	}
}
