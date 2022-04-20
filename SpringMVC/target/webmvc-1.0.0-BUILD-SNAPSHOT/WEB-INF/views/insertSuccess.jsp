<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<html><body><center>	
<h1>새글이 등록되었습니다 </h1><p>

<TABLE BORDER=2 CELLPADDING = 2>
 		<TR>
			
				<TH WIDTH=300>NAME</TH><TD width=300 align=center>${b.name }</TD> 
		
		<TR>
					<TH WIDTH=200>TITLE</TH>
					<TD COLSPAN=3>${b.title }</TD>
		</TR>
		<TR>
			<TH WIDTH=200>CONTENT</TH>
			<TD COLSPAN=3><textarea readonly cols=120 rows=20>${b.content }</textarea></TD>
		</TR> 		
	</TABLE><br>
	<br>

	<a href="list.bod">전체화면</a>&nbsp;&nbsp;&nbsp;	
	</center></body></html>






