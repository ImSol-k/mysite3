<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../../assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="../../assets/css/board.css" rel="stylesheet" type="text/css">

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
					<div id="modifyForm">
						<form action="#" method="get">
							<!-- 작성자 -->
							<div class="form-group">
								<span class="form-text">작성자</span>
								<span class="form-value">정우성</span>
							</div>
							
							<!-- 조회수 -->
							<div class="form-group">
								<span class="form-text">조회수</span>
								<span class="form-value">123</span>
							</div>
							
							<!-- 작성일 -->
							<div class="form-group">
								<span class="form-text">작성일</span>
								<span class="form-value">2020-03-02</span>
							</div>
							
							<!-- 제목 -->
							<div class="form-group">
								<label class="form-text" for="txt-title">제목</label>
								<input type="text" id="txt-title" name="" value="여기에는 글제목이 출력됩니다.">
							</div>
						
							
						
							<!-- 내용 -->
							<div class="form-group">
								<textarea id="txt-content">여기에는 본문내용이 출력됩니다.
	여기에는 본문내용이 출력됩니다.
	여기에는 본문내용이 출력됩니다.
	여기에는 본문내용이 출력됩니다.
	여기에는 본문내용이 출력됩니다.
	여기에는 본문내용이 출력됩니다.
	여기에는 본문내용이 출력됩니다.
	여기에는 본문내용이 출력됩니다.</textarea>
							</div>
							
							<a id="btn_cancel" href="">취소</a>
							<button id="btn_modify" type="submit" >수정</button>
							
						</form>
						<!-- //form -->
					</div>
					<!-- //modifyForm -->
				</div>
				<!-- //board -->
			</div>
			<!-- //content  -->

		</div>
		<!-- //container  -->


		<div id="footer">
			Copyright ⓒ 2020 황일영. All right reserved
		</div>
		<!-- //footer -->
	</div>
	<!-- //wrap -->

</body>

</html>