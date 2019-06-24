package app.services.api;

import java.util.List;

import app.dataobjects.Item;
import app.dataobjects.ItemAttribute;

public interface IItemService {
	
	public void addItem(Item item) throws Exception;	
	public Item getItemByCode(String itemCode);
	
	public List<Item> getItems();
	
	public Item getItem(Long id);

	public String createItem(String itemCode, String itemType, String itemcreationType);
	
	public List<ItemAttribute> findItemAttributes(String itemCode);
	
	public List<Item> findRelatedItems(String itemCode);
	
	public void addItemAttributes(Item item);

	public void deleteItem(String itemCode);
	
	public void deleteItems();

	public void updateItem(String itemCode);

	public void patchItem(String itemCode);

}
