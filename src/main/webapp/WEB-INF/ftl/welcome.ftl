<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type"
          content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>

<br/>
年龄：${userInfo.age}
<br/>
登录时间：${userInfo.signinTime?string("yyyy-MM-dd HH:mm:ss")}
<br/>
QQ：${userInfo.QQ}
<br/>
地址：${userInfo.address}
<hr/>
我的书籍：
<#list userInfo.books as book>
${book}&nbsp;
</#list>
</body>
</html>