package app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import app.models.Item;
import app.services.ItemAttributesService;
import app.services.ItemService;

@CrossOrigin
@RestController
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	ItemAttributesService itemAttributesService;
	
	
	@RequestMapping(value = "/items", method = RequestMethod.POST)
	public void addItem(@RequestBody Item item) throws Exception {
		itemService.addItem(item);
	}
	
	
	@RequestMapping(value = "/items", method = RequestMethod.GET)
	public List<Item> getItems() {
		List<Item> items = itemService.getItems();
		return items;
	}
	
	@RequestMapping(value = "items/{itemCode}", method = RequestMethod.GET)
	public Item getItem(@PathVariable String itemCode) {
		Item item = itemService.getItem(itemCode);
		return item;
	}
	
}
