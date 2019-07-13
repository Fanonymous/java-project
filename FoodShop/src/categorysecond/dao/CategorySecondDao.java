package categorysecond.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import shop.utils.PageHibernateCallback;
import categorysecond.vo.CategorySecond;

/**
 * ���������Dao��Ĵ��� 
 */
public class CategorySecondDao extends HibernateDaoSupport {

	// DAO�е�ͳ�ƶ�����������ķ���
	public int findCount() {
		String hql = "select count(*) from CategorySecond";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	// DAO�з�ҳ��ѯ�ķ���
	public List<CategorySecond> findByPage(int begin, int limit) {
		String hql = "from CategorySecond order by csid desc";
		List<CategorySecond> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<CategorySecond>(hql, null, begin,
						limit));
		return list;
	}

	// DAO�еı����������ķ���
	public void save(CategorySecond categorySecond) {
		this.getHibernateTemplate().save(categorySecond);
	}

	// DAO�е�ɾ����������ķ���
	public void delete(CategorySecond categorySecond) {
		this.getHibernateTemplate().delete(categorySecond);
	}

	// DAO�и���id��ѯ��������ķ���
	public CategorySecond findByCsid(Integer csid) {
		return this.getHibernateTemplate().get(CategorySecond.class, csid);
	}

	// DAO�е��޸Ķ�������ķ���
	public void update(CategorySecond categorySecond) {
		this.getHibernateTemplate().update(categorySecond);
	}

	// DAO�еĲ�ѯ���ж�������ķ���
	public List<CategorySecond> findAll() {
		String hql = "from CategorySecond";
		return this.getHibernateTemplate().find(hql);
	}

}
