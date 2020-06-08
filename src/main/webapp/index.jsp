<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!-- isELIgnored="false"可以使得el语句得以使用 -->
<html>
<head>
    <title>SpringMVCdemo</title>
</head>
<body>
    <h2>入门程序1</h2>
    <!-- /hello 相当于一个绝对路径，会访问到错误页面 -->
    <a href="hello">hello</a>
    <form action="save">
        <!-- 以下页面代码实现了bean的自组装，spring会根据反射，
        根据byname和bytype的方式将各种bean按照已匹配上的方式组装起来 -->
        姓名：<input name="name" type="text"/><br/>
        密码：<input name="password" type="text"/><br/>
        金额：<input name="money" type="text"/><br/>
        组装user：<input name="user.name" type="text"/><br/>
        组装user：<input name="user.age" type="text"/><br/>
        组装list：<input name="list[0].name" type="text"/><br/>
        组装list：<input name="list[0].age" type="text"/><br/>
        组装map：<input name="map['one'].name" type="text"/><br/>
        组装map：<input name="map['one'].age" type="text"/><br/>
        组装时间戳：<input name="time" type="date"/><br/>
        <!-- 会根据控制类中的注解requestparam的属性字段去差异化匹配 -->
        <input name="myname" type="text"/><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
