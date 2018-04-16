<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
<!--loginbox------------------------------------------>
      <div class="login-area">

        <form class="form-inline">

          <label class="col-sm-4">ログインID</label>
          <div class="col-sm-8">
            <input type="id" class="form-control input-sm" placeholder="ログインID" required="" autofocus="" >
          </div>
        </form>
      </div>
<!--loginbox------------------------------------------>
<!--passbox------------------------------------------>
      <div class="login-area">
        <form class="form-inline">

          <label class="col-sm-4">パスワード</label>
          <div class="col-sm-8">
            <input type="password" class="form-control input-sm" placeholder="password" required="" autofocus="" >
          </div>
        </form>
      </div>
<!--passbox------------------------------------------>
<!--button------------------------------------------>
      <form action="list.html">
        <p>
          <button type="submit" class="btn btn-primary btn-lg" value="送信する">ログイン</button>
        </p>
      </form>
<!--button------------------------------------------>

    </center>



</body>

</html>
