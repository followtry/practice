1.ͨ��GET��ʽ���Σ�ͨ��new String(request.getParameter("").getBytes("ISO-8859-1"),"UTF-8"); �ķ�ʽת��Ϊ��Ҫ�ı��룬��UTF-8�ȡ�
response.setCharacterEncoding("UTF-8")
 
2.ͨ��POST��ʽ���Σ�ͨ������request.setCharacterEncoding("UTF-8");�ķ�ʽ�������������������