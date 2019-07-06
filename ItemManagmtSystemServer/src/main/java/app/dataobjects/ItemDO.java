package app.dataobjects;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "dcpc_item")
public class ItemDO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true, nullable = false)
	private String itemCode;
	private String name;
	private String type;
	private String origin;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Transient
	private List<ItemAttribute> attributes;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Transient
	private List<ItemDO> relatedItems;
	

	public Long getId() {
		return id;
	}

	public List<ItemAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<ItemAttribute> attributes) {
		this.attributes = attributes;
	}

	public List<ItemDO> getRelatedItems() {
		return relatedItems;
	}

	public void setRelatedItems(List<ItemDO> relatedItems) {
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
