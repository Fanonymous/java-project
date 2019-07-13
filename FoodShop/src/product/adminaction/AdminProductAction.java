package product.adminaction;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import product.service.ProductService;
import product.vo.Product;
import shop.utils.PageBean;
import categorysecond.service.CategorySecondService;
import categorysecond.vo.CategorySecond;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ��̨��Ʒ�����Action
 * 
 * @author 
 * 
 */
public class AdminProductAction extends ActionSupport implements
		ModelDriven<Product> {
	// ģ������ʹ�õĶ���
	private Product product = new Product();

	public Product getModel() {
		return product;
	}

	// ����page����
	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}

	// ע��ProductService
	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	// ע��CategorySecondService
	private CategorySecondService categorySecondService;

	public void setCategorySecondService(
			CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	// �ļ��ϴ���Ҫ����������:
	private File upload;
	private String uploadFileName;
	private String uploadContentType;

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	// ��ѯ���е���Ʒ:
	public String findAll() {
		PageBean<Product> pageBean = productService.findByPage(page);
		// ��PageBean���ݴ��뵽ֵջ��.
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		// ҳ����ת
		return "findAll";
	}

	// ��ת�����ҳ��ķ���:
	public String addPage() {
		// ��ѯ���еĶ�������:
		List<CategorySecond> csList = categorySecondService.findAll();
		// �����������������ʾ��ҳ����
		ActionContext.getContext().getValueStack().set("csList", csList);
		// ҳ����ת
		return "addPageSuccess";
	}

	// ������Ʒ�ķ���:
	public String save() throws IOException {
		// ���ύ��������ӵ����ݿ���.
		product.setPdate(new Date());
		// product.setImage(image);
		if(upload != null){
			// ����ƷͼƬ�ϴ�����������.
			// ����ϴ�ͼƬ�ķ�������·��.
			String path = ServletActionContext.getServletContext().getRealPath(
					"/products");
			// �����ļ����Ͷ���:
			File diskFile = new File(path + "//" + uploadFileName);
			// �ļ��ϴ�:
			FileUtils.copyFile(upload, diskFile);
	
			product.setImage("products/" + uploadFileName);
		}
		productService.save(product);
		return "saveSuccess";
	}

	// ɾ����Ʒ�ķ���:
	public String delete() {
		// ����id��ѯ��Ʒ��Ϣ
		product = productService.findByPid(product.getPid());
		// ɾ����Ʒ��ͼƬ:
		String path = ServletActionContext.getServletContext().getRealPath(
				"/" + product.getImage());
		File file = new File(path);
		file.delete();
		// ɾ�����ݿ�����Ʒ��¼:
		productService.delete(product);
		// ҳ����ת
		return "deleteSuccess";
	}

	// �༭��Ʒ�ķ���
	public String edit() {
		// ������Ʒid��ѯ��Ʒ��Ϣ
		product = productService.findByPid(product.getPid());
		// ��ѯ���ж�������
		List<CategorySecond> csList = categorySecondService.findAll();
		ActionContext.getContext().getValueStack().set("csList", csList);
		// ҳ����ת���༭ҳ��:
		return "editSuccess";
	}

	// �޸���Ʒ�ķ���
	public String update() throws IOException {
		// ����Ϣ�޸ĵ����ݿ�
		product.setPdate(new Date());
		
		// �ϴ�:
		if(upload != null ){
			String delPath = ServletActionContext.getServletContext().getRealPath(
					"/" + product.getImage());
			File file = new File(delPath);
			file.delete();
			// ����ϴ�ͼƬ�ķ�������·��.
			String path = ServletActionContext.getServletContext().getRealPath(
					"/products");
			// �����ļ����Ͷ���:
			File diskFile = new File(path + "//" + uploadFileName);
			// �ļ��ϴ�:
			FileUtils.copyFile(upload, diskFile);

			product.setImage("products/" + uploadFileName);
		}
		productService.update(product);
		// ҳ����ת
		return "updateSuccess";
	}
}
