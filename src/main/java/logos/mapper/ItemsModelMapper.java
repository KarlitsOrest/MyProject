package logos.mapper;


import logos.domain.CreateItemsRequest;
import logos.domain.EditItemsRequest;
import logos.entity.ItemsModel;

public interface ItemsModelMapper {

	public static ItemsModel addRequestToItemsModel(CreateItemsRequest request) {
		
		ItemsModel items = new ItemsModel();
	//	items.setModel(request.getModel());
		items.setPrice(request.getPrice());
		items.setYear(request.getYear());
	//	items.setOptions(request.getOptions());
	//	items.setDescriptions(request.getDescriptions());
	//	items.setColor(request.getColor());
	//	items.setProduct(request.getProduct());
		items.setBodyType(request.getBodyType());
	//	items.setItemsMake(request.getItemsMake());
		items.setMemory(request.getMemory());
		items.setImage(request.getImage());
		return items;
	}
	
	public  static CreateItemsRequest entityToItemsCreateRequest(ItemsModel itemsModel) {
		
		CreateItemsRequest request = new CreateItemsRequest();
		
	//	request.setModel(itemsModel.getModel());
		request.setPrice(itemsModel.getPrice());
		request.setYear(itemsModel.getYear());
	//	request.setOptions(itemsModel.getOptions());
	//	request.setDescriptions(request.getDescriptions());
	//	request.setColor(itemsModel.getColor());
	//	request.setProduct(itemsModel.getProduct());
		request.setBodyType(itemsModel.getBodyType());
	//	request.setItemsMake(itemsModel.getItemsMake());
		request.setMemory(itemsModel.getMemory());
		//request.setCarImage(carModel.getImage());
		//request.setImage(carModel.getImage());
		return request;
		
		
	}
	
	
	 public static ItemsModel editItemsToEntity1(EditItemsRequest request) {
		 ItemsModel model = new ItemsModel();
		model.setId(request.getId());
	//	model.setModel(request.getModel());
		model.setYear(request.getYear());
	//	model.setOptions(request.getOptions());
	//	model.setDescriptions(request.getDescriptions());
		model.setPrice(request.getPrice());
	//	model.setColor(request.getColor());
	//	model.setProduct(request.getProduct());
		model.setBodyType(request.getBodyType());
	//	model.setItemsMake(request.getItemsMake());
		//model.setId(request.getId());
		return model;
	}
	 public static EditItemsRequest itemsToRequest1(ItemsModel model) {
		 
		 EditItemsRequest request = new EditItemsRequest();
		 request.setId(model.getId());
	//	 request.setModel(model.getModel());
	//	 request.setOptions(model.getOptions());
		 request.setYear(request.getYear());
	//	 request.setDescriptions(model.getDescriptions());
		 request.setPrice(model.getPrice());
	//	 request.setColor(model.getColor());
	//	 request.setProduct(model.getProduct());
		 request.setBodyType(model.getBodyType());
	//	 request.setItemsMake(model.getItemsMake());
		 
		 return request;
	 }

	public static EditItemsRequest itemsToRequest(ItemsModel itemsModel) {
		// TODO Auto-generated method stub
		return null;
	}

	public static ItemsModel editItemsToEntity(EditItemsRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
}
