package dao;
/*
 * @description:
 * @author: TienMinhTran
 * @date: 9/11/2025
 */
import java.util.List;

import entities.Product;

public interface ProductDAO {
	public List<Product> getAllProduct();

	public Product getProductById(String id);

	public List<Product> getProductByName(String name);
}
