package app.datatransfertobjects;


import java.util.List;

import javax.persistence.Column;

import app.dataobjects.ItemAttribute;


public class ItemDTO {

	private Long id;
	@Column(unique = true, nullable = false)
	private String itemCode;
	private String name;
	private String type;
	private String origin;
	private List<ItemAttribute> attributes;
	private List<ItemDTO> relatedItems;

	public Long getId() {
		return id;
	}

	public List<ItemAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<ItemAttribute> attributes) {
		this.attributes = attributes;
	}

	public List<ItemDTO> getRelatedItems() {
		return relatedItems;
	}

	public void setRelatedItems(List<ItemDTO> relatedItems) {
		this.relatedItems = relatedItems;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
}

