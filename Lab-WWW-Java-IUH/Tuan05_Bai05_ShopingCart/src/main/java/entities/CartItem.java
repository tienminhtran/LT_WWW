package entities;
/*
 * @description:
 * @author: TienMinhTran
 * @date: 9/11/2025
 *//*
 * @description:
 * @author: TienMinhTran
 * @date: 9/11/2025
 */
public class CartItem {
	private Product product;

	private int quantity;

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public CartItem(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double calcTotal() {
		return product.getPrice() * this.quantity;
	}

	@Override
	public String toString() {
		return "CartItem [product=" + product + ", quantity=" + quantity + "]";
	}

}
