package com.gzmu.interManSys.web;
//�Ͻ����񱣴��servlet���൱���޸�ά�޼�¼��״̬
import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.gzmu.interManSys.dao.TaskHandInDao;
import com.gzmu.interManSys.model.Task;
import com.gzmu.interManSys.util.DbUtil;
import com.gzmu.interManSys.util.ResponseUtil;
import com.gzmu.interManSys.util.StringUtil;

public class TaskHandInSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DbUtil dbUitl=new DbUtil();
	TaskHandInDao taskHandInDao=new TaskHandInDao();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		//�첽�ύ������������
		request.setCharacterEncoding("UTF-8");
		
		
		//��ǰ̨��ȡ��Ϣ
		String finishTime=request.getParameter("finishTime");
		String dealWay=request.getParameter("dealWay");
		String taskId=request.getParameter("taskId");
		
		//״̬��ͨ��ǰ̨����������Servlet���Զ����Ͻ������״̬����Ϊ����ά�ޡ�
		String state = "��ά��";
		
		Task task=new Task(null,null,null,null,null,null,null,finishTime,dealWay,state);
		
		//���ǰ̨������ID��Ϊ�գ���IDתΪint��������
		if(StringUtil.isNotEmpty(taskId)){
			task.setTaskId(Integer.parseInt(taskId));
		}
		Connection con=null;
		try {
			con=dbUitl.getCon();
			JSONObject result=new JSONObject();
			int saveNums=0;
			//�Ͻ������¼�
			saveNums=taskHandInDao.taskHandIn(con, task);
			//�Ͻ������¼����ص�ֵ�����㣬�Ͻ��ɹ�
			if(saveNums>0){
				result.put("success", "true");
			}
			else{
				result.put("success", "true");
				result.put("errorMsg", "�Ͻ�ʧ��!");
			}
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				dbUitl.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
