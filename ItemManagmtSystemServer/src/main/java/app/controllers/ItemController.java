package app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.dataobjects.Item;
import app.services.api.IItemService;


@CrossOrigin
@RestController
public class ItemController {
	
	@Autowired
	private IItemService itemService;
	
	
	@PostMapping(value = "/items", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addItem(@RequestBody Item item) throws Exception {
		itemService.addItem(item);
	}
	
	@GetMapping(value = "/items/{itemCode}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Item getItemByCode(@PathVariable String itemCode) {
		Item item = itemService.getItemByCode(itemCode);
		return item;
	}
	
	@GetMapping(value = "/items", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Item> getItems() {
		List<Item> items = itemService.getItems();
		return items;
	}
	
	@PutMapping(value = "/items/{itemCode}")
	public void updateItem(@PathVariable String itemCode)
	{
		itemService.updateItem(itemCode);
	}
	
	@PatchMapping(value = "/items/{itemCode}")
	public void patchItem(@PathVariable String itemCode)
	{
		itemService.patchItem(itemCode);
	}
	
	@DeleteMapping(value = "/items/{itemCode}")
	public void deleteItem(@PathVariable String itemCode)
	{
		itemService.deleteItem(itemCode);
	}
	
	@DeleteMapping(value = "/items")
	public void deleteItems()
	{
		itemService.deleteItems();
	}
}
