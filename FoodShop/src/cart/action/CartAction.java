package cart.action;

import org.apache.struts2.ServletActionContext;

import product.service.ProductService;
import product.vo.Product;
import cart.vo.Cart;
import cart.vo.CartItem;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ���ﳵAction
 */
public class CartAction extends ActionSupport {
	// ����pid
	private Integer pid;
	// ��������count
	private Integer count;
	// ע����Ʒ��Service
	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	// ����������ӵ����ﳵ:ִ�еķ���
	public String addCart() {
		// ��װһ��CartItem����.
		CartItem cartItem = new CartItem();
		// ��������:
		cartItem.setCount(count);
		// ����pid���в�ѯ��Ʒ:
		Product product = productService.findByPid(pid);
		// ������Ʒ:
		cartItem.setProduct(product);
		// ����������ӵ����ﳵ.
		// ���ﳵӦ�ô���session��.
		Cart cart = getCart();
		cart.addCart(cartItem);

		return "addCart";
	}

	// ��չ��ﳵ��ִ�еķ���:
	public String clearCart(){
		// ��ù��ﳵ����.
		Cart cart = getCart();
		// ���ù��ﳵ����շ���.
		cart.clearCart();
		return "clearCart";
	}
	
	// �ӹ��ﳵ���Ƴ�������ķ���:
	public String removeCart(){
		// ��ù��ﳵ����
		Cart cart = getCart();
		// ���ù��ﳵ���Ƴ��ķ���:
		cart.removeCart(pid);
		// ����ҳ��:
		return "removeCart";
	}
	
	// �ҵĹ��ﳵ:ִ�еķ���
	public String myCart(){
		return "myCart";
	}
	
	/**
	 * ��ù��ﳵ�ķ���:��session�л�ù��ﳵ.
	 * @return
	 */
	private Cart getCart() {
		Cart cart = (Cart) ServletActionContext.getRequest().getSession()
				.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			ServletActionContext.getRequest().getSession()
					.setAttribute("cart", cart);
		}
		return cart;
	}
}
