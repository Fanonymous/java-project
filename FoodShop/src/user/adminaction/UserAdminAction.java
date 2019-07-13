package user.adminaction;

import shop.utils.PageBean;
import user.service.UserService;
import user.vo.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * ��̨�û������Action��
 */
public class UserAdminAction extends ActionSupport implements ModelDriven<User>{
	// ģ������ʹ�õ���
	private User user = new User();

	public User getModel() {
		return user;
	}
	
	// ע���û���Service
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// ����page����
	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}

	// ��̨��ѯ�����û��ķ�������ҳ:
	public String findAll(){
		PageBean<User> pageBean = userService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	// ��̨�û���ɾ��
	public String delete(){
		User existUser = userService.findByUid(user.getUid());
		userService.delete(existUser);
		return "deleteSuccess";
	}
	
	// ��̨�û��ı༭
	public String edit(){
		user = userService.findByUid(user.getUid());
		return "editSuccess";
	}
	
	// ��̨�û����޸�:
	public String update(){
		userService.update(user);
		return "updateSuccess";
	}
}
