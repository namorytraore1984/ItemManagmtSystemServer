package app.services.api;

import app.dataobjects.ItemAttribute;

public interface IItemAttributesService {
	
	public Iterable<ItemAttribute> getItemsAttributes();
	
	public Iterable<ItemAttribute> getItemAttributes(String itemCode);

}
