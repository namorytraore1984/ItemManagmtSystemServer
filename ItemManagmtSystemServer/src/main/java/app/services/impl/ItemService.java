package app.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dataobjects.Item;
import app.dataobjects.ItemAttribute;
import app.dataobjects.ItemRelation;
import app.repository.ItemAttributeRepository;
import app.repository.ItemRelationRepository;
import app.repository.ItemRepository;
import app.services.api.IItemService;

@Service
public class ItemService implements IItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private ItemRelationRepository relatedItemsRepo;
	@Autowired
	private ItemAttributeRepository itemAttributeRepo;
	
	@Override
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
	
	@Override
	public Item getItemByCode(String itemCode) 
	{
		
		//Item item = itemRepository.findByItemCode(itemCode);
		Optional<Item> itemOpt = itemRepository.findByItemCode(itemCode);
		if ( !itemOpt.isPresent() ) return null;
		Item item = itemOpt.get();
		//set item attribute
		List<ItemAttribute> itemAttributes = findItemAttributes(itemCode);
		item.setAttributes(itemAttributes);
		List<Item> relatedItems = findRelatedItems(itemCode);
		item.setRelatedItems(relatedItems);	
		return item;
	}
	
	@Override
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
	
	@Override
	public Item getItem(Long id)
	{
		Item item = new Item();
		return item;
	}

	@Override
	public String createItem(String itemCode, String itemType, String itemcreationType)
	{
		Item item = new Item();
		item.setItemCode(itemCode);
		item.setType(itemType);
		item.setOrigin(itemcreationType);
		
		itemRepository.save(item);
		return "saved";
	}
	
	@Override
	public List<ItemAttribute> findItemAttributes(String itemCode)
	{
		List<ItemAttribute> iterItemAttributes = itemAttributeRepo.findByItemCode(itemCode);
		if ( iterItemAttributes == null || iterItemAttributes.size() == 0 ) return null;
		return iterItemAttributes;
	}
	
	@Override
	public List<Item> findRelatedItems(String itemCode)
	{
		List<ItemRelation> itemRelations = relatedItemsRepo.getByItemCode(itemCode);
		if ( itemRelations == null || itemRelations.size() == 0 ) return null;
		List<Item> relatedItems = new ArrayList<Item>();
		for ( ItemRelation ir : itemRelations ) {
			if ( ir == null ) continue;
			String relatedItemCode = ir.getRelatedItemCode();
			Optional<Item> relatedItemOpt = itemRepository.findByItemCode(relatedItemCode);
			if ( relatedItemOpt.isPresent() )
			{
				Item relatedItem = relatedItemOpt.get();
				List<ItemAttribute> relatedItemAttributes = findItemAttributes(relatedItemCode);
				relatedItem.setAttributes(relatedItemAttributes);
				relatedItems.add(relatedItem);
			}
		}
		return relatedItems;
	}
	
	@Override
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

	@Override
	public void deleteItem(String itemCode) 
	{
		//itemRepository.delete(itemCode);
	}
	
	@Override
	public void deleteItems() 
	{
		itemRepository.deleteAll();	
	}

	@Override
	public void updateItem(String itemCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void patchItem(String itemCode) {
		// TODO Auto-generated method stub
		
	}
}
