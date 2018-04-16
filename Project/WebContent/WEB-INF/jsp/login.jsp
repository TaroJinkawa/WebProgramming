<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<title>ログイン画面</title>
  <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="css/origin/common.css">
<style>
body {
    background-color: #D7EEFF;
}
</style>

</head>

<body>

  <br></br>

    <center>

<!--title------------------------------------------------------------------------------------>
      <div>
        <h2>

          <font style="vertical-align: inherit;"><font style="vertical-align: inherit;">ログイン画面</font></font>
        </h2>
      </div>
<!--title------------------------------------------------------------------------------------>
<form class="form-signin" action="LoginServlet" method="post">
<!--loginbox------------------------------------------>
      <div class="login-area">

        <div class="form-inline">

          <label class="col-sm-4">ログインID</label>
          <div class="col-sm-8">
            <input type="id" name="loginId" class="form-control input-sm" placeholder="ログインID" required="" autofocus="" >
          </div>
        </div>
      </div>
<!--loginbox------------------------------------------>
<!--passbox------------------------------------------>
      <div class="login-area">
        <div class="form-inline">

          <label class="col-sm-4">パスワード</label>
          <div class="col-sm-8">
            <input type="password" name="password" class="form-control input-sm" placeholder="password" required="" autofocus="" >
          </div>
        </div>
      </div>
<!--passbox------------------------------------------>
<!--button------------------------------------------>

        <p>
          <button class="btn btn-primary btn-lg" type="submit" >ログイン</button>
        </p>

<!--button------------------------------------------>

	</form>
    </center>



</body>

</html>
