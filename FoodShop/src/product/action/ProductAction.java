package product.action;

import product.service.ProductService;
import product.vo.Product;
import shop.utils.PageBean;
import category.service.CategoryService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ��Ʒ��Action����
 * 
 * @author 
 * 
 */
public class ProductAction extends ActionSupport implements
		ModelDriven<Product> {
	// ���ڽ������ݵ�ģ������.
	private Product product = new Product();
	// ע����Ʒ��Service
	private ProductService productService;
	// ���շ���cid
	private Integer cid;
	// ���ն�������id
	private Integer csid;

	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	// ע��һ�������Service
	private CategoryService categoryService;
	// ���յ�ǰҳ��:
	private int page;

	public void setPage(int page) {
		this.page = page;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getCid() {
		return cid;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public Product getModel() {
		return product;
	}

	// ������Ʒ��ID���в�ѯ��Ʒ:ִ�з���:
	public String findByPid() {
		// ����Service�ķ�����ɲ�ѯ.
		product = productService.findByPid(product.getPid());
		return "findByPid";
	}

	// ���ݷ����id��ѯ��Ʒ:
	public String findByCid() {
		// List<Category> cList = categoryService.findAll();
		PageBean<Product> pageBean = productService.findByPageCid(cid, page);// ����һ�������ѯ��Ʒ,����ҳ��ѯ
		// ��PageBean���뵽ֵջ��:
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCid";
	}

	// ���ݶ�������id��ѯ��Ʒ:
	public String findByCsid() {
		// ���ݶ��������ѯ��Ʒ
		PageBean<Product> pageBean = productService.findByPageCsid(csid, page);
		// ��PageBean���뵽ֵջ��:
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCsid";
	}
}
