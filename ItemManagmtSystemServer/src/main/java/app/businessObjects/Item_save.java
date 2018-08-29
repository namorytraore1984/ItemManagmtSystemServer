package app.businessObjects;

import app.models.Item;
import app.models.ItemRelation;

import java.util.List;

import app.models.ItemAttribute;

public class Item_save {
	private Item item;
	private List<ItemAttribute> attributes;
	private List<ItemRelation> relatedItems;
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public List<ItemAttribute> getAttributes() {
		return attributes;
	}
	public void setAttributes(List<ItemAttribute> attributes) {
		this.attributes = attributes;
	}
	public List<ItemRelation> getRelatedItems() {
		return relatedItems;
	}
	public void setRelatedItems(List<ItemRelation> relatedItems) {
		this.relatedItems = relatedItems;
	}
}
