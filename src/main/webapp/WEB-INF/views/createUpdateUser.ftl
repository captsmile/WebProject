<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<#if user??>
<form name="user" action="/updateUser" method="post">
    Name
    <input title=name name="name" type="text" value="${user.name}">
    Email
    <input title=email name="email" type="text" value="${user.email}">
    Age
    <input title=age name="age" type="text" value="${user.age}">
    <input type="submit" value="OK">
</form>
<#else>
<form name="user" action="/addUser" method="post">
    Name
    <input title=name name="name" type="text">
    Email
    <input title=email name="email" type="text">
    Age
    <input title=age name="age" type="text">
    <input type="submit" value="OK">
</form></#if>
</body>
</html>