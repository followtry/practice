<%
    	int count=0;
    	if(application.getAttribute("count")==null||
    		application.getAttribute("count")==""||
    		"".equals(application.getAttribute("count"))){
    		count=1;
    	}else{
    		
    		count=Integer.parseInt(application.getAttribute("count")+"");
    		count=count+1;
    	}
    	
    	application.setAttribute("count",count);
    
     %>
     <h1><font color="#eab">��ǰ������:<%=application.getAttribute("count") %></font></h1>
  