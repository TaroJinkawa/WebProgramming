<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>ユーザ情報詳細参照</title>
  <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="css/origin/common.css">
</head>

<body>
  <!--header---------------------->
  <header>
    <div class="wrapper">
      <div class="main">
        <div align="right"　><font color="white"><h5>${userInfo.name} さん</h5></font></div>
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

      <font style="vertical-align: inherit;"><font style="vertical-align: inherit;">ユーザ情報詳細参照</font></font>
    </center></h2>
  </div>
<!--title---------------------->
<!--idbox---------------------->
  <div class="newuser-area">
    <form class="form-inline" name=id >
      <label class="col-sm-5">ログインID</label>
      <label class="col-sm-7" >${userData.loginId}</label>
    </form>
  </div>
<!--idbox---------------------->
<!--namebox---------------------->
  <div class="newuser-area">
    <form class="form-inline">
      <label class="col-sm-5">ユーザ名</label>
      <label class="col-sm-7">${userData.name}</label>
    </form>
  </div>
<!--namebox---------------------->
<!--birthdaybox---------------------->
  <div class="newuser-area">
    <form class="form-inline">
      <label class="col-sm-5">生年月日</label>
      <label class="col-sm-7">${userData.birthDate}</label>
    </form>
  </div>
<!--birthdaybox---------------------->
<!--Registrationbox---------------------->
  <div class="newuser-area">
    <form class="form-inline">
      <label class="col-sm-5">登録日時</label>
      <label class="col-sm-7">${userData.createDate}</label>
    </form>
  </div>
<!--Registrationbox---------------------->
<!--updatebox---------------------->
  <div class="newuser-area">
    <form class="form-inline">
      <label class="col-sm-5">更新日時</label>
      <label class="col-sm-7">${userData.updateDate}</label>
    </form>
  </div>
<!--updatebox---------------------->
<br>
<!--return---------------------->
  <div style="margin-left:20px;" ><a href="ListServlet"><u><font color="red">戻る</font></u></a></div>
<!--return---------------------->

</body>

</html>
