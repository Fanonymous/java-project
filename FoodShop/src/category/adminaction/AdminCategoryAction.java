package category.adminaction;

import java.util.List;

import category.service.CategoryService;
import category.vo.Category;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ��̨һ���������Action
 * @author 
 *
 */
public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category>{
	// ģ������ʹ�õĶ���.
	private Category category = new Category();
	public Category getModel() {
		return category;
	}
	// ע��һ�������Service
	public CategoryService categoryService;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}



	// ��ѯ����һ������
	public String findAll(){
		// ����Service��ѯ����һ������
		List<Category> cList = categoryService.findAll();
		// ͨ��ֵջ����һ�����༯��:
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "findAll";
	}
	
	// ����һ������ķ���
	public String save(){
		// ����Service��ɱ���һ������
		categoryService.save(category);
		// ����ҳ����ת:
		return "saveSuccess";
	}
	
	// ɾ��һ������ķ���:
	public String delete(){
		// ����Service��� һ�������ɾ��
		// ����ɾ��һ���Ȳ�ѯ��ɾ��:
		category = categoryService.findByCid(category.getCid());
		categoryService.delete(category);
		// ����ҳ��ת��:
		return "deleteSuccess";
	}
	
	// �༭һ������ķ���:
	public String edit(){
		// ����cid:
		// ����cid���в�ѯ:
		category = categoryService.findByCid(category.getCid());
		// ���ҳ��ת��:��һ������������ʾ��ҳ����.
		return "editSuccess";
	}
	
	// �޸�һ������ķ���:
	public String update(){
		// ʹ��ģ����������ǰ̨�ύ����:
		categoryService.update(category);
		// ҳ����ת:
		return "updateSuccess";
	}
}
