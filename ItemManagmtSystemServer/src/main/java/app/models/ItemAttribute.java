package app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "dcpc_item_attribute")
//@JsonIgnoreProperties("itemCode")
public class ItemAttribute {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String itemCode;
	private String itemAttributeCode;
	private String defaultValue;
	private int sequence;

	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public Long getId() {
		return id;
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
	public String getItemAttributeCode() {
		return itemAttributeCode;
	}
	public void setItemAttributeCode(String itemAttributeCode) {
		this.itemAttributeCode = itemAttributeCode;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
}
