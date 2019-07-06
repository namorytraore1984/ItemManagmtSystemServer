package app.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import app.dataobjects.ItemDO;
import app.dataobjects.ItemAttribute;
import app.dataobjects.ItemRelation;
import app.datatransfertobjects.ItemDTO;
import app.repository.ItemAttributeRepository;
import app.repository.ItemRelationRepository;
import app.repository.ItemRepository;
import app.services.api.IItemService;
import app.services.mappers.ItemMapper;

@Service
public class ItemService implements IItemService {
	
	private ItemRepository itemRepository;
	private ItemRelationRepository relatedItemsRepo;
	private ItemAttributeRepository itemAttributeRepo;
	

	private ItemMapper itemMapper = Mappers.getMapper(ItemMapper.class);
	
	public ItemService(ItemRepository itemRepository, ItemRelationRepository relatedItemsRepo, ItemAttributeRepository itemAttributeRepo) {
		this.itemRepository = itemRepository;
		this.relatedItemsRepo = relatedItemsRepo;
		this.itemAttributeRepo = itemAttributeRepo;
	}
	
	@Override
	public ItemDTO addItem(ItemDTO itemDTO) throws Exception
	{
		if ( itemDTO == null ) {
			throw new Exception("L'objet recu est null");
		};
		Optional<ItemDO> existingItemOpt = itemRepository.findByItemCode(itemDTO.getItemCode());
		if ( existingItemOpt.isPresent() ) {
			// throw exception : cet element existe deja
			throw new Exception("cet element existe deja");
		}
		//save item instance
		ItemDO itemSaved = itemRepository.save(itemMapper.mapItemDTOToItemDO(itemDTO));
		itemDTO.setId(itemSaved.getId());
		//save item attribute
		addItemAttributes(itemDTO);
		return itemDTO;
	}
	
	@Override
	public ItemDTO getItemByCode(String itemCode) 
	{
		Optional<ItemDO> itemOpt = itemRepository.findByItemCode(itemCode);
		if ( !itemOpt.isPresent() ) return null;
		ItemDO item = itemOpt.get();
		//set item attribute
		List<ItemAttribute> itemAttributes = findItemAttributes(itemCode);
		item.setAttributes(itemAttributes);
		List<ItemDO> relatedItems = findRelatedItems(itemCode);
		item.setRelatedItems(relatedItems);	
		return itemMapper.mapItemDOToItemDTO(item);
	}
	
	@Override
	public List<ItemDTO> getItems()
	{
		List<ItemDTO> items = new ArrayList<>();
		List<ItemAttribute> itemAttributes;
		List<ItemDO> relatedItems;
		Iterable<ItemDO> itemsFromRepo =  itemRepository.findAll();
		
		for(ItemDO item : itemsFromRepo) {
			
			if ( item == null ) continue;
			String itemCode = item.getItemCode();
			itemAttributes = findItemAttributes(itemCode);
			item.setAttributes(itemAttributes);
			//set related items
			relatedItems = findRelatedItems(itemCode);
			item.setRelatedItems(relatedItems);			
			items.add(itemMapper.mapItemDOToItemDTO(item));
		}
		
		return items;
	}
	
	@Override
	public ItemDTO getItem(Long id)
	{
		Optional<ItemDO> itemDoOpt = itemRepository.findById(id);
		if (itemDoOpt.isPresent()) {
			return itemMapper.mapItemDOToItemDTO(itemDoOpt.get());
		}
		return null;
	}
	
	@Override
	public List<ItemAttribute> findItemAttributes(String itemCode)
	{
		List<ItemAttribute> iterItemAttributes = itemAttributeRepo.findByItemCode(itemCode);
		if ( iterItemAttributes == null || iterItemAttributes.size() == 0 ) return null;
		return iterItemAttributes;
	}
	
	@Override
	public List<ItemDO> findRelatedItems(String itemCode)
	{
		List<ItemRelation> itemRelations = relatedItemsRepo.getByItemCode(itemCode);
		if ( itemRelations == null || itemRelations.size() == 0 ) return null;
		List<ItemDO> relatedItems = new ArrayList<>();
		for ( ItemRelation ir : itemRelations ) {
			if ( ir == null ) continue;
			String relatedItemCode = ir.getRelatedItemCode();
			Optional<ItemDO> relatedItemOpt = itemRepository.findByItemCode(relatedItemCode);
			if ( relatedItemOpt.isPresent() )
			{
				ItemDO relatedItem = relatedItemOpt.get();
				List<ItemAttribute> relatedItemAttributes = findItemAttributes(relatedItemCode);
				relatedItem.setAttributes(relatedItemAttributes);
				relatedItems.add(relatedItem);
			}
		}
		return relatedItems;
	}

	@Override
	public void deleteItemByItemCode(String itemCode) throws Exception
	{
		Optional<ItemDO> itemDOOpt = itemRepository.findByItemCode(itemCode);
		if (!itemDOOpt.isPresent()) {
			throw new Exception("Cet item n'existe pas");
		}
		itemRepository.delete(itemDOOpt.get());
	}
	
	@Override
	public void deleteItems() 
	{
		itemRepository.deleteAll();	
	}

	@Override
	public void updateItem(ItemDTO item) throws Exception {
		
		if ( item != null ) {
			Optional<ItemDO> itemToUpdateOpt = itemRepository.findByItemCode(item.getItemCode());		
			if ( !itemToUpdateOpt.isPresent() ) {
				// Throw exception : cet element n'existe pas
				throw new Exception("cet element n'existe pas");
			}
			
			ItemDO itemDO = itemMapper.mapItemDTOToItemDO(item);
			itemDO.setId(itemToUpdateOpt.get().getId());
			itemRepository.save(itemDO);			
		}
	}

	@Override
	public void patchItem(String itemCode) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void addItemAttributes(ItemDTO itemDTO) {

		if (itemDTO != null) {
			String itemCode = itemDTO.getItemCode();
			List<ItemAttribute> itemAttributes = itemDTO.getAttributes();
			if (itemAttributes != null) {				
				itemAttributes.stream().forEach(itemAttribute -> {
					itemAttribute.setItemCode(itemCode);
					itemAttributeRepo.save(itemAttribute);
				});
			}
		}
	}
}
