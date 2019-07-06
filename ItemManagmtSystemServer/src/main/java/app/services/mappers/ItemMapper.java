package app.services.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import app.dataobjects.ItemDO;
import app.datatransfertobjects.ItemDTO;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ItemMapper {
	ItemDO mapItemDTOToItemDO(ItemDTO itemSource);
	ItemDTO mapItemDOToItemDTO(ItemDO itemSource);
}
