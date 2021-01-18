<%@page import="in.co.rays.project_4.util.DataUtility"%>
<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.project_4.model.TimeTableModel"%>
<%@page import="in.co.rays.project_4.bean.TimeTableBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="in.co.rays.project_4.controller.TimeTableListCtl"%>
<%@page import="in.co.rays.project_4.util.HTMLUtility"%>
<%@page import="in.co.rays.project_4.util.ServletUtility"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Result System</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<center>
		<h1>TimeTable List</h1>
		<jsp:useBean id="bean" class="in.co.rays.project_4.bean.TimeTableBean"
			scope="request"></jsp:useBean>
		<%
		List slist=(List)request.getAttribute("subjectList");
        List clist=(List)request.getAttribute("courseList");
		%>
		<form action="<%=ORSView.TIME_TABLE_LIST_CTL%>" method="post">
		<tr>
		<%
					int pageNo = ServletUtility.getPageNo(request);
					int pageSize = ServletUtility.getPageSize(request);
					int index = ((pageNo - 1) * pageSize) + 1;

					List list = ServletUtility.getList(request);
					Iterator<TimeTableBean> it=list.iterator();
					

				%>
		 <% if(list.size()!=0){%>
					<td colspan="8"><font color="red"><%=ServletUtility.getErrorMessage(request)%></font></td>
				</tr>
				<tr>
					<td colspan="8"><font color="green"><%=ServletUtility.getSuccessMessage(request)%></font></td>
				</tr>

			 <table width="100%">
            <tr>
                 <td align="center"><label>Course Name</label>
                 <%=HTMLUtility.getList("courseId", String.valueOf(bean.getCourseId()), clist) %>&emsp;
                 <label>Subject Name</label>
                 <%=HTMLUtility.getList("subjectId", String.valueOf(bean.getSubjectId()), slist) %>&emsp;
                 <label>Semester</label>
                 <%
					HashMap map= new HashMap();
					 map.put("1semester", "1semester");
					 map.put("2semester", "2semester");
					 map.put("3semester", "3semester");
					 map.put("4semester", "4semester");
					 map.put("5semester", "5semester");
					 map.put("6semester", "6semester");
					 map.put("7semester", "7semester");
					 map.put("8semester", "8semester");
					 
					 String semester = HTMLUtility.getList("semester", bean.getSemester(), map);
					
					 
					%>
					<%=semester%>
                 
                 
                 <input type="submit" name="operation" value="<%=TimeTableListCtl.OP_SEARCH%>">
                 
                  <input type="submit" name="operation" value="<%=TimeTableListCtl.OP_RESET%>">
                 
                 </td>
            
            </tr>
          
          
          </table>			<br>

			<table border="1" width="100%">
				<tr>
                    <th><input type="checkbox" id="select_all" name="select">Select All</th>
                    <th>S No.</th>
                    <th>Course Name</th>
                    <th>Subject Name</th>
                    <th>Semester</th>
                    <th>Exam Date</th>
                    <th>Exam Time</th>
                    <th>Edit</th>
          </tr>

				

				<%
					

				TimeTableModel model=new TimeTableModel();
		          while(it.hasNext()){
		        	  bean=it.next();
		        	  
				%>
				 <tr align="center">
        <td align="center"><input type="checkbox" class="checkbox" name="ids" value="<%=bean.getId()%>"></td>
				<td><%=index++%></td>
				<td><%=bean.getCourseName()%></td>  
				<td><%=bean.getSubjectName()%></td>
				<td><%=bean.getSemester()%></td>
				<td><%=bean.getExamDate()%></td>
				<td><%=bean.getExamTime()%></td>
				<td><a href="TimeTableCtl?id=<%=bean.getId()%>"><font >Edit</font></a></td>
          </tr>
				<%
					}
				%>
			</table>
			
			<table width="100%">
				<tr>
				
				<%if(pageNo==1){ %>
					<td><input type="submit" name="operation" disabled="disabled"
						value="<%=TimeTableListCtl.OP_PREVIOUS%>"></td>
						<%} else{ %>
						<td><input type="submit" name="operation"
						value="<%=TimeTableListCtl.OP_PREVIOUS%>"></td>
						<%} %>
						<td><input type="submit" name="operation"
						value="<%=TimeTableListCtl.OP_NEW%>"></td>
					<td><input type="submit" name="operation"
						value="<%=TimeTableListCtl.OP_DELETE%>"></td>
						<%if((model.nextPk()-1)==bean.getId() || list.size()<pageSize){ %>
						
					<td align="right"><input type="submit" name="operation" disabled="disabled"
						value="<%=TimeTableListCtl.OP_NEXT%>"></td>
						<%} else{ %>
						<td align="right"><input type="submit" name="operation"
						value="<%=TimeTableListCtl.OP_NEXT%>"></td>
						<%} %>
						 </tr>
            </table>
            <%} if(list.size()==0) { %>
            <table>
            <tr>
            <td colspan="8"><font color="red"><%=ServletUtility.getErrorMessage(request)%></font></td>
				</tr>
				<tr>
					<td colspan="8"><font color="green"><%=ServletUtility.getSuccessMessage(request)%></font></td>
				</tr>
				
            <tr>
            <td align="center">
            <input type="submit" name="operation" value="<%=TimeTableListCtl.OP_BACK %>">
            </td>
            </tr>
            </table>
            
            <%} %>
				</tr>
			</table>
			<input type="hidden" name="pageNo" value="<%=pageNo%>"> <input
				type="hidden" name="pageSize" value="<%=pageSize%>">
		</form>
	</center>
	<%@include file="Footer.jsp"%>
</body>
</html>