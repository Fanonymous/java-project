package com.gzmu.interManSys.web;
//���������servlet���൱���޸�ά�޼�¼��״̬
import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.gzmu.interManSys.dao.TaskReceiveDao;
import com.gzmu.interManSys.model.Task;
import com.gzmu.interManSys.util.DbUtil;
import com.gzmu.interManSys.util.ResponseUtil;
import com.gzmu.interManSys.util.StringUtil;

public class TaskReceiveSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DbUtil dbUitl=new DbUtil();
	TaskReceiveDao taskReceiveDao=new TaskReceiveDao();
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
		//��ǰ̨��ȡ��Ϣ,����ʱ��㣬�����ߣ�״̬��״̬Ϊά����
		String repairTime=request.getParameter("repairTime");
		//String repairer=request.getParameter("repairer");
		String taskId=request.getParameter("taskId");
		
		//ְԱ��������ʱ��״̬�ǲ���ǰ̨��д���д���������Servlet���д���ɡ�ά���С��������ݿ��н����޸�
		String state = "ά����";
		//ͬ��,ְԱ��дά�ޱ�ʱ��ά����ѡ�ͨ��ǰ̨��д������ͨ��session�еĵ�¼�û�����д�����ݿ�
		//���Դ�session��ȡ��myName
		HttpSession session=request.getSession();
		String repairer = (String) session.getAttribute("myName");

		System.out.println("�û���"+repairer);
		
		Task task=new Task(null,null,null,null,null,repairer,repairTime,null,null,state);
		//���ǰ̨������ID��Ϊ�գ���IDתΪint��������
		if(StringUtil.isNotEmpty(taskId)){
			task.setTaskId(Integer.parseInt(taskId));
		}
		Connection con=null;
		try {
			con=dbUitl.getCon();
			JSONObject result=new JSONObject();
			int saveNums=0;
			//���������¼�
			saveNums=taskReceiveDao.taskReceive(con, task);
			//�������ӻ���ɾ�����ص��������㣬��˵�����ձ�������ĳɹ�
			if(saveNums>0){
				result.put("success", "true");
			}
			else{
				result.put("success", "true");
				result.put("errorMsg", "����ʧ��!");
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
