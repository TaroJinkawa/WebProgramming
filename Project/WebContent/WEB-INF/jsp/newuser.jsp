<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>ユーザ新規登録</title>
  <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="css/origin/common.css">
</head>

<body>
  <!--header---------------------->
  <header>
    <div class="wrapper">
      <div class="main">
        <div align="right"　><font color="white"><h5>ユーザ名さん</h5></font></div>
      </div>
      <div class="side">
        <div align="right"><a href="LoginServlet"><u><font color="red">ログアウト</font></u></a></div>
      </div>
    </div>
  </header>
<!--header---------------------->
<!--title---------------------->
  <div>
    <br>
    <h2><center>

      <font style="vertical-align: inherit;"><font style="vertical-align: inherit;">ユーザ新規登録</font></font>
    </center></h2>
  </div>
<!--title---------------------->
<c:if test="${errMsg != null}" >
	    <div class="alert alert-danger" role="alert">
		  ${errMsg}
		</div>
	</c:if>
<form class="form-signin" action="NewUserServlet" method="post">
<!--idbox---------------------->
  <div class="newuser-area">
    <div class="form-inline">
      <label class="col-sm-5">ログインID</label>
      <input type="id" name="loginId" class="form-control col-sm-7" placeholder="ログインID" required="" autofocus="" >
    </div>
  </div>
<!--idbox---------------------->
<!--passbox ---------------------->
  <div class="newuser-area">
    <div class="form-inline">
      <label class="col-sm-5">パスワード</label>
      <input type="password" name="password" class="form-control col-sm-7" placeholder="パスワード" required="" autofocus="" >
    </div>
  </div>
<!--passbox ---------------------->
<!--pass2box---------------------->
  <div class="newuser-area">
    <div class="form-inline">
      <label class="col-sm-5">パスワード(確認)</label>
      <input type="password" name="password2" class="form-control col-sm-7" placeholder="パスワード(確認)" required="" autofocus="" >
    </div>
  </div>
<!--pass2box ---------------------->

<!--namebox ---------------------->
  <div class="newuser-area">
    <div class="form-inline">
      <label class="col-sm-5">ユーザ名</label>
      <input type="id" name="name" class="form-control col-sm-7" placeholder="ユーザ名" required="" autofocus="" >
    </div>
  </div>
<!--namebox ---------------------->
<!--birthdaybox ---------------------->
  <div class="newuser-area">
    <div class="form-inline">
      <label class="col-sm-5">生年月日</label>
      <input type="date" name=birthDate class="form-control col-sm-7"required="" autofocus="" >
    </div>
  </div>
<!--birthdaybox ---------------------->
<br>
<!--Registrationbuttan---------------------->
  <div class="newuser-area">
    <div action="NewUserServlet">
      <p><div align="right"><center>
        <button type="submit" class="btn btn-primary  form-control col-sm-4" value="送信する">登録</button>
      </center></div></p>
    </div>
  </div>
<!--Registrationbuttan---------------------->
</form>
<!--return---------------------->
  <div style="margin-left:20px;" ><a href="ListServlet"><u><font color="red">戻る</font></u></a></div>
<!--return---------------------->

</body>

</html>
