package app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import app.datatransfertobjects.ItemDTO;
import app.services.api.IItemService;


@CrossOrigin
@RestController
public class ItemController {
	
	@Autowired
	private IItemService itemService;
	
	
	@PostMapping(value = "/items", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemDTO> addItem(@RequestBody ItemDTO item) throws Exception {
		
		//ResponseEntity<Void> response = new ResponseEntity<>(status);
		ItemDTO itemCreated = itemService.addItem(item);
		//ResponseEntity.status(1).content
		return null;
	}
	
	@GetMapping(value = "/items/{itemCode}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ItemDTO getItemByCode(@PathVariable String itemCode) {
		ItemDTO item = itemService.getItemByCode(itemCode);
		return item;
	}
	
	@GetMapping(value = "/items", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ItemDTO> getItems() {
		List<ItemDTO> items = itemService.getItems();
		return items;
	}
	
	@PutMapping(value = "/items")
	public void updateItem(@RequestBody ItemDTO item) throws Exception
	{
		itemService.updateItem(item);
	}
	
	@PatchMapping(value = "/items/{itemCode}")
	public void patchItem(@PathVariable String itemCode) throws Exception
	{
		itemService.patchItem(itemCode);
	}
	
	@DeleteMapping(value = "/items/{itemCode}")
	public void deleteItem(@PathVariable String itemCode) throws Exception
	{
		itemService.deleteItemByItemCode(itemCode);
	}
	
	@DeleteMapping(value = "/items")
	public void deleteItems()
	{
		itemService.deleteItems();
	}
}
