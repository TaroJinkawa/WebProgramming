<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>ユーザ情報更新</title>
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
        <div align="right"><a href="login.html"><u><font color="red">ログアウト</font></u></a></div>
      </div>
    </div>
  </header>
<!--header---------------------->
<!--title---------------------->
  <div>
    <br>
    <h2><center>

      <font style="vertical-align: inherit;"><font style="vertical-align: inherit;">ユーザ情報更新</font></font>
    </center></h2>
  </div>
<!--title---------------------->
<!--idbox---------------------->
  <div class="newuser-area">
    <form class="form-inline">
      <label class="col-sm-5">ログインID</label>
      <label class="col-sm-7">id00◯◯</label>
    </form>
  </div>
<!--idbox---------------------->
<!--passbox---------------------->
  <div class="newuser-area">
    <form class="form-inline">
      <label class="col-sm-5">パスワード</label>
      <input type="password" class="form-control col-sm-7" placeholder="パスワード" required="" autofocus="" >
    </form>
  </div>
<!--passbox---------------------->
<!--pass2box---------------------->
  <div class="newuser-area">
    <form class="form-inline">
      <label class="col-sm-5">パスワード(確認)</label>
      <input type="password" class="form-control col-sm-7" placeholder="パスワード(確認)" required="" autofocus="" >
    </form>
  </div>
<!--pass2box---------------------->
<!--namebox---------------------->
  <div class="newuser-area">
    <form class="form-inline">
      <label class="col-sm-5">ユーザ名</label>
      <input type="text" class="form-control col-sm-7" value="◯◯◯◯"  required="" autofocus="" >
    </form>
  </div>
<!--namebox---------------------->
<!--birthdaybox---------------------->
  <div class="newuser-area">
    <form class="form-inline">
      <label class="col-sm-5">生年月日</label>
      <input type="date" class="form-control col-sm-7"  required="" autofocus="" >
    </form>
  </div>
<!--birthdaybox---------------------->
<br>
<!--updatebuttan---------------------->
<div class="newuser-area">
<form action="list.html">
  <p><div align="right"><center>
    <button type="submit" class="btn btn-primary  form-control col-sm-4" value="送信する">更新</button>
  </center></div></p>
</form>
</div>
<!--updatebuttan---------------------->
<!--return---------------------->
  <div style="margin-left:20px;" ><a href="list.html"><u><font color="red">戻る</font></u></a></div>
<!--return---------------------->

</body>

</html>
