package app.services.api;

import java.util.List;


import app.dataobjects.ItemAttribute;
import app.dataobjects.ItemDO;
import app.datatransfertobjects.ItemDTO;

public interface IItemService {
	
	public ItemDTO addItem(ItemDTO item) throws Exception;
	
	public ItemDTO getItemByCode(String itemCode);
	
	public List<ItemDTO> getItems();
	
	public ItemDTO getItem(Long id);
	
	public List<ItemAttribute> findItemAttributes(String itemCode);
	
	public List<ItemDO> findRelatedItems(String itemCode);
	
	public void addItemAttributes(ItemDTO item);

	public void deleteItemByItemCode(String itemCode) throws Exception;
	
	public void deleteItems();

	public void updateItem(ItemDTO item) throws Exception;

	public void patchItem(String itemCode) throws Exception;

}
