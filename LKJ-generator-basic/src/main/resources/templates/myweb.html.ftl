<!DOCTYPE html>
<html>
<head>
    <title>demo示例</title>
</head>
<body>
<h1>欢迎使用freemaker</h1>
<ul>
    <#-- 循环导航 -->
    <#list menuItems as item>
        <li><a href="${item.url}">${item.lable}</a></li>
    </#list>
</ul>
<footer>
    ${currentYear} demo 官网，hell
</footer>
</body>
</html>