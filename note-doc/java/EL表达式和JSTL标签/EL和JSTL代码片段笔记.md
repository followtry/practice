### EL表达式格式化日期
	1 在页面上导入   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
    2 格式化日期<fmt:formatDate value="${XXX.date}" pattern="yyyy-MM-dd"/> 
     	 Value ：EL表达式取的日期值； 
     	 Pattern：输出的日期格式；