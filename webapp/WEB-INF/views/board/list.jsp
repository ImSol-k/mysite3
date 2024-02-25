<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="com.javaex.vo.BoardVo"%>
<%@ page import="com.javaex.vo.UserVo"%>

<%
List<BoardVo> boardList = (List<BoardVo>) request.getAttribute("boardList");
UserVo authUser = (UserVo) session.getAttribute("authUser");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/mysite3/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="/mysite3/assets/css/board.css" rel="stylesheet" type="text/css">

</head>


<body>
	<div id="wrap">

		<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
		<!-- //nav -->

		<div id="container" class="clearfix">

			<jsp:include page="/WEB-INF/views/includes/board.jsp"></jsp:include>
			<!-- //aside -->

			<div id="content">

				<div id="content-head">
					<h3>일반게시판</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>게시판</li>
							<li class="last">일반게시판</li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<!-- //content-head -->

				<div id="board">
					<div id="list">
						<form action="" method="">
							<div class="form-group text-right">
								<input type="text">
								<button type="submit" id=btn_search>검색</button>
							</div>
						</form>
						<form action="readForm">
							<table>
								<thead>
									<tr>
										<th>번호</th>
										<th>제목</th>
										<th>글쓴이</th>
										<th>조회수</th>
										<th>작성일</th>
										<th>관리</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items='${requestScope.boardList }' var='boardList'>
										<tr>
											<td>${boardList.no }</td>
											<td class="text-left"><a
												href="/mysite3/board?action=readForm&title=${boardList.title }">${boardList.title }</a></td>
											<td>${boardList.name }</td>
											<td>${boardList.hit }</td>
											<td>${boardList.date }</td>
											<c:choose>
												<c:when test="${!(empty authUser) && (boardList.no.equals(authUser.no))}">
													<td><a href="/mysite3/board?action=delete">[삭제]</a></td>
												</c:when>
												<c:otherwise>
													<td>[]</td>
												</c:otherwise>
											</c:choose>
										</tr>
									</c:forEach>

								</tbody>
							</table>
						</form>

						<div id="paging">
							<ul>
								<li><a href="">◀</a></li>
								<li><a href="">1</a></li>
								<li><a href="">2</a></li>
								<li><a href="">3</a></li>
								<li><a href="">4</a></li>
								<li class="active"><a href="">5</a></li>
								<li><a href="">6</a></li>
								<li><a href="">7</a></li>
								<li><a href="">8</a></li>
								<li><a href="">9</a></li>
								<li><a href="">10</a></li>
								<li><a href="">▶</a></li>
							</ul>


							<div class="clear"></div>
						</div>
						<a id="btn_write" href="/mysite3/board?action=writeForm">글쓰기</a>

					</div>
					<!-- //list -->
				</div>
				<!-- //board -->
			</div>
			<!-- //content  -->

		</div>
		<!-- //container  -->


		<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>
		<!-- //footer -->
	</div>
	<!-- //wrap -->

</body>

</html>
