package categorysecond.adminaction;

import java.util.List;

import shop.utils.PageBean;
import category.service.CategoryService;
import category.vo.Category;
import categorysecond.service.CategorySecondService;
import categorysecond.vo.CategorySecond;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ��̨��������Ĺ����Action. 
 */
public class AdminCategorySecondAction extends ActionSupport implements
		ModelDriven<CategorySecond> {

	// ģ������ʹ�õĶ���
	private CategorySecond categorySecond = new CategorySecond();
	// ����page����:
	private Integer page;
	// ע�����Service
	private CategorySecondService categorySecondService;
	// ע��һ�������Service
	private CategoryService categoryService;

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setCategorySecondService(
			CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public CategorySecond getModel() {
		return categorySecond;
	}

	// ���з�ҳ�Ĳ�ѯ���ж�������Ĳ���:
	public String findAll() {
		// ����Service���в�ѯ.
		PageBean<CategorySecond> pageBean = categorySecondService
				.findByPage(page);
		// ��pageBean�����ݴ��뵽ֵջ��.
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}

	// ��ת�����ҳ��ķ���:
	public String addPage() {
		// ��ѯ����һ������.
		List<Category> cList = categoryService.findAll();
		// �����ϴ��뵽ֵջ��.
		ActionContext.getContext().getValueStack().set("cList", cList);
		// ҳ����ת:
		return "addPage";
	}

	// ��Ӷ�������ķ���:
	public String save() {
		categorySecondService.save(categorySecond);
		return "saveSuccess";
	}

	// ɾ����������ķ���:
	public String delete() {
		categorySecondService.delete(categorySecond);
		return "deleteSuccess";
	}

	// �༭��������ķ���:
	public String edit() {
		// ����id��ѯ��������:
		categorySecond = categorySecondService.findByCsid(categorySecond
				.getCsid());
		// ��ѯ����һ������:
		List<Category> cList = categoryService.findAll();
		// �����ϴ��뵽ֵջ��.
		ActionContext.getContext().getValueStack().set("cList", cList);
		// ҳ����ת:
		return "editSuccess";
	}
	
	// �޸Ķ�������ķ���:
	public String update(){
		categorySecondService.update(categorySecond);
		return "updateSuccess";
	}
}
