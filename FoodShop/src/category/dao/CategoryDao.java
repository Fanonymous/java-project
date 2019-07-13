package category.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import category.vo.Category;

/**
 * һ������ĳ־ò����
 * @author 
 *
 */
public class CategoryDao extends HibernateDaoSupport{

	//DAO��Ĳ�ѯ����һ������ķ���
	public List<Category> findAll() {
		String hql = "from Category";
		List<Category> list = this.getHibernateTemplate().find(hql);
		return list;
	}

	// Dao�еı���һ������ķ���
	public void save(Category category) {
		this.getHibernateTemplate().save(category);
	}

	// Dao�и���һ������id��ѯһ������
	public Category findByCid(Integer cid) {
		return this.getHibernateTemplate().get(Category.class, cid);
	}

	// DAO��ɾ��һ������
	public void delete(Category category) {
		this.getHibernateTemplate().delete(category);
	}

	// Dao���޸�һ������
	public void update(Category category) {
		this.getHibernateTemplate().update(category);
	}
	
}
