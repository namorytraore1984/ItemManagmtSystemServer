package app.datatransfertobjects;

import lombok.Data;

@Data
public class ItemDTO {

	private Long id;
	private String itemCode;
	private String name;
	private String type;
	private String origin;
}
