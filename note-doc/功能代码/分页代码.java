/**************---Dao---***********************/
	
	//��ҳ��ѯ����
	public List<Msg> getMsgPaging(int startRow,int endRow) throws SQLException{
		List<Msg> msgs=new ArrayList<Msg>();
		db.connection(this.conn);
		String sql="SELECT * FROM (  " +
				"SELECT A.*, ROWNUM RN  FROM (SELECT * FROM mymessage order by time desc) A   " +
				"WHERE ROWNUM <=?) WHERE RN >=? ";
		Object obj[]={endRow,startRow};
		ResultSet rSet=db.executeQuery(sql, obj);
		while (rSet.next()) {
			Msg msg=new Msg();
			msg.setId(rSet.getInt("id"));
			msg.setName(rSet.getString("name"));
			msg.setContext(rSet.getString("context"));
			msg.setTime(rSet.getString("time"));
			msg.setTitle(rSet.getString("title"));
			msgs.add(msg);
		}
		
		return msgs;
	}


/*****************---service����---**************************/
	//��ҳ��ѯ
	public List<Msg> getMsgPaging(int pageNow){
		List<Msg> msgs=new ArrayList<Msg>();
	
		try {
			 int pageSize=page.pageSize;
			//�жϻ�õ�ҳ���Ƿ�����ҳ��С
			this.conn=db.connection();
			MsgDao md=new  MsgDao(this.conn);
			int startRow=pageSize*(pageNow-1)+1;
			int endRow=pageSize*pageNow;
			System.out.println("startRow:"+startRow);
			System.out.println("endRow:"+endRow);
			msgs=md.getMsgPaging(startRow, endRow);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (db!=null) {
				try {
					db.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return msgs;
	}

	//��ʾ��ҳ��
	public Page showPageNum(int  pageNow){
		//��ҳ����ʾ��ҳ����
		int showPageNum=7;
		page.setPageSize(8);
		page.setShowPageNum(showPageNum);
		page.setPageCount(this.getPageCount());
		if (pageNow<=1) {
			page.setPageNow(1);
		}else if (pageNow>=page.getPageCount()) {
			page.setPageNow(page.getPageCount());
		}else {
			page.setPageNow(pageNow);
		}
		System.out.println("page.getPageCount()="+page.getPageCount());
		if (page.getPageCount()>page.getShowPageNum()&&page.getPageNow()<page.getPageCount()-page.getShowPageNum()/2) {
			if (page.getPageNow()<=page.getShowPageNum()/2) {
				page.setStart(1);
				page.setEnd(page.getShowPageNum());
			}else {
				page.setStart(page.getPageNow()-page.getShowPageNum()/2);
				page.setEnd(page.getPageNow()+page.getShowPageNum()/2);
			}
			//����ͷ����
		}else if (page.getPageCount()<=page.getShowPageNum()) {
			page.setStart(1);
			page.setEnd(page.getPageCount());
			System.out.println("--------2-----------");
			//����β����
		}else if (page.getPageCount()>=page.getPageNow()-page.getShowPageNum()/2) {
			page.setStart(page.getPageCount()-page.getShowPageNum());
			page.setEnd(page.getPageCount());
			System.out.println("--------3-----------");
		}
		return page;
	}

/************************----servlet����----*********************/
		int pageNow=1;
		String sPageNum=request.getParameter("pageNow");
		
		//��δ�ж��Ƿ��зǷ��ַ�
		if (sPageNum!=null) {
			pageNow=Integer.parseInt(sPageNum);
		}
		Page page=ms.showPageNum(pageNow);
		request.setAttribute("page", page);
		//request.setAttribute("pageNow", pageNow);
		//request.setAttribute("pageCount", pageCount);
		List<Msg> lists=new ArrayList<Msg>();
		lists.clear();
		lists=ms.getMsgPaging(page.getPageNow());
		request.setAttribute("lists", lists);
		request.getRequestDispatcher("../getMsg.jsp").forward(request, response);

/********************---tools---***************************/
public class Page
{
	public  int pageSize=10;//����ÿҳ��ʾ��������¼
	private int start=1;	//��ʾҳ��Ŀ�ʼҳ��
	private int end=1;		//��ʾҳ��Ľ���ҳ��
	private int pageCount;//��¼����ҳ��
	private int showPageNum;//��Ҫ��ʾ��ҳ����
	private int pageNow;	//��ǰҳ
}

/******************----ҳ����ʾ---*************************/
   <div class="pagination"> 
	<%
		Page p=(Page)request.getAttribute("page");
		if(p.getPageNow()<=1){
			out.print("<li class='disablepage'>��ҳ&nbsp;</li> ");
			out.print("<li class='disablepage'>��һҳ&nbsp;</li> ");
		}else{
			out.print("<a href='servlet/MsgServlet?method=find&pageNow=1'>��ҳ</a>&nbsp; ");
			out.print("<a href='servlet/MsgServlet?method=find&pageNow="+(p.getPageNow()-1)+"'>��һҳ </a>&nbsp;");
		}
		
		for(int i=p.getStart();i<=p.getEnd();i++){
			if(p.getPageNow()==i){
				out.print("<li class='currentpage'>"+i+"</li>&nbsp;");
			}else{
				out.print("<a href='servlet/MsgServlet?method=find&pageNow="+i+"'>"+i+"</a>&nbsp;");
			}
		}
		if(p.getPageNow()>=p.getPageCount()){
			out.print("<li class='disablepage'>��һҳ </li>&nbsp; ");
			out.print("<li class='disablepage'>βҳ</li>&nbsp;");
		}else{
			out.print("<a href='servlet/MsgServlet?method=find&pageNow="+(p.getPageNow()+1)+"'>��һҳ</a>&nbsp;");
			out.print("<a href='servlet/MsgServlet?method=find&pageNow="+p.getPageCount()+"'>βҳ</a>&nbsp;");
		}
		
	%>
   </div><br/> 	
	
	