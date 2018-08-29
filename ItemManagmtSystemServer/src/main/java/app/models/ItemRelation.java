package app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties("itemCode")
@Table(name = "dcpc_item_relation")
public class ItemRelation {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String itemCode;
	private String relatedItemCode;
	private String relationType;
	private String relationCode;
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
	public String getRelatedItemCode() {
		return relatedItemCode;
	}
	public void setRelatedItemCode(String relatedItemCode) {
		this.relatedItemCode = relatedItemCode;
	}
	public String getRelationType() {
		return relationType;
	}
	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}
	public String getRelationCode() {
		return relationCode;
	}
	public void setRelationCode(String relationCode) {
		this.relationCode = relationCode;
	}
	
}
