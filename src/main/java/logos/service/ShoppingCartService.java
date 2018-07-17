package logos.service;

import logos.entity.ItemsModel;

import java.math.BigDecimal;
import java.util.Map;

public interface ShoppingCartService {

    void addProduct(ItemsModel product);

    void removeProduct(ItemsModel product);

    Map<ItemsModel, Integer> getProductsInCart();

    void checkout() ;

    BigDecimal getTotal();
}
