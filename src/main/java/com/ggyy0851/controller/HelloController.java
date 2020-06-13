package com.ggyy0851.controller;

import com.ggyy0851.pojo.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 控制器类
 * @author GeYao
 * @create 2020-06-02 - 13:42
 */
@Controller
public class HelloController {

    @RequestMapping(path = "/hello")
    public String sayHello(HttpServletRequest r, HttpSession s){
        r.setAttribute("key","request");
        s.setAttribute("key","session");
        System.out.println("Hello String MVC");
        return "success";
    }
    @RequestMapping("/save")
    /**
     * 这里自组装传入的类比如account，必须有相应的get/set方法，否则会报错提示组装失败
     * 如果有必要，可以直接在方法参数中加入HttpServletRequest和HttpServletResponse来直接获取原生servlet的相应api
     * 可以使用的原生api有：
     * httpservletrequest
     * httpservletresponse
     * httpsession
     * 以上为常用api
     * principal:安全相关的东西
     * locale：国际化相关
     * inputstream：通过request.getinputstream获取到
     * outputstream：通过respones.getoutputstream获取到
     * reader：通过request.getreader获取到
     * writer：通过response.getwriter获取到
     * 默认是不需要写的
     * 在参数上设置的@requestparam注解的name属性可以使得部分可能重名的参数得以进行区分，即以参数名为A的状态传入但是实际注入到参数名为B的参数上
     * 另外@requestparam的requerd属性使得某个参数是必须的，如果该值设为false则可以是非必须的
     * 在参数上设置的@requestbody注解可以使得一个String类型的实参被注入传入方法的body信息，即通过post方法传入的表单参数，可直接
     * 拿到整个body的全部字段，一般用于做异步处理时获取json等信息
     * 注解@PathVariable可使得restful风格的变成成为可能，当@requestMapping中设置了占位符如：@RequestMapping("/save/{id}")时
     * 可通过注解@PathVariable(name="id")来获取到相应的值，并将该值注入到被注解的形参中，注意此方式不同于用?连接参数的形式，而是用/连接
     * url一般表示为类似 hello/save/120,其中120即为占位符的id的值
     * 使用注解@requestheader可获得传入的url的header信息，通过@RequestHeader(value="Accept")的方式将header的accept头部信息注入
     * 指定的形参之中
     * 注解@CookieValue(value="JSESAIONID"),可以将指定的cookie获取并注入到形参之中。value为具体某个cookie文件的名字
     * requestparams,requestheader,cookievalue三个注解都有required属性,值为true和false，表示是否必须，都有defaultvalue表示默认值为xx
     *
     *
     *
     * 注解@sessionattributes(value="attr"),作用于类名上，即把attr这个参数添加到session域中，可在jsp页面中使用el语句取到相应的值
     * 经常用于在方法之间传递参数
     * modle可用于获取底层数据，可获取request和session里的信息，用map,model,modelmap
     * 其中map是jdk中的接口，model是spring中的接口，modelmap是spring中的类
     * 最终实现的类是bindingawaremodelmap，他继承了modelmap并实现了model接口，而modelmap继承了map
     * 使用map.put，model.addAttribute，modelmap.addattribute方法将信息传入request域中
     * 也可以使用modelandview传出，只是返回值不能是String，只能是modelandview对象了
     * 注解@ModuleAttributes()可被注解在方法和形参上
     * 被注解在方法上可使得被注解的方法必定先于本controller类的其他方法执行，可作为预处理数据方法使用，比如对数据进行简单查询
     * 对数据进行预处理。被注解的方法可以返回值，也可以不返回值。返回值可在接下来执行的@RequestMapping注解的方法中取得（可直接引用）。
     * 如果没有返回值，被@ModuleAttributes注解的方法中可以使用map.put(key,value)的方式将预处理的数据存入map中
     * 之后再下一个requestmapping的方法之中，使用@ModuleAttributes(value="key")的方式将value取出并注入到某个形参当中进行使用
     * (不建议使用注解，建议使用原生api)如果使用@sessionattribute来注解某个类，那么这个类中所有对model等参数传递的数据均往session域中传一份
     * 该注解的value可以指定那些key可以放入session域中,TYPE可以指定哪些类被放入时会放到session中
     *
     * @ModelAttribute 该注解会使得方法在所有其他方法之前进行运行，一般用于需要对数据进行预处理的情况，比如对数据库中某表进行更新操作时
     * 需要先将模型new出来并注入数据库中的数据，如果不这么做可能会导致其他方法里new出来的数据在保存时会和数据库中原本的数据不一致。
     * 注解在方法上会使得方法优先于其他方法运行，并且每次其他方法执行时都执行它
     * 注解在参数上时会从request中获取到相应形参名字的key（也可用value指定）并注入到传入的实参中，此时的实参不会通过ioc去new出来
     * 只会通过request中已存在的值中去取得
     *
     */

    public String save(Account account, HttpServletRequest request, HttpServletResponse response, @RequestParam(name = "myname",required = false) String name, Model model, ModelMap modelMap){
        System.out.println("进入了save方法");
        System.out.println(account.toString());
        System.out.println(request+":"+response);
        //model是作用于底层的类，作用类似request，可用于传入参数，获取参数
        model.addAttribute("attr","value");
        String attr = (String)modelMap.getAttribute("attr");
        System.out.println(attr);
        //return "/WEB-INFO/pages/success.jsp";如果没有配置视图解析器的话可以这样做
        //return "forward:/WEB-INF/pages/success.jsp"转发可以直接使用forward:关键字进行处理
        //forward:/则是绝对路径，不加/就是相对路径，forward也可以跟url，比如forward:/test来进行其他方法的转发
        //redirect:是重定向的关键字，原生的servlet重定向由于是发送给浏览器的，所以使用起来比较麻烦
        //spring的重定向相对方便,直接redirect:/index.jsp可以直接重定向到项目目录下的页面,无需手动写项目名
        return "success";
    }

    /**
     *使用通配符？可匹配上text1,text2之类的访问请求，也可使用*来匹配任意长度字符，优先级按照最精确的全局匹配、单个模糊匹配和
     *多个模糊匹配的顺序来执行，可以匹配多个层级的访问请求，比如a/※/test则可以匹配到a/sdf/test的请求，一个/划分一个层级
     * @return
     */
    @RequestMapping(value="/test?")

    public String Text1(){
        System.out.println("text01");
        return "success";
    }
    @RequestMapping(value="/view")
    public String V(Model model){
        List<String> h = new ArrayList<String >();
        h.add("http://www.baidu.com");
        h.add("http://www.steampowered.com/");
        h.add("https://www.epicgames.com/");
        model.addAttribute("href",h);

        return "gyview:";
    }

    /**
     * 使用@responseBody注解将返回的对象放在response响应体中，jackson会自动将返回对象转换成json格式进行返回
     * 将请求时传入的json转换成对象，也可使用@requestbody注解实现，将对象转换成指定类型传入
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/getajax")
    public Account getAByAjax(@RequestBody Account account){
        Account a = new Account();
        a.setName("ggyy");
        a.setPassword("13232");
        a.setMoney(2222.22);
        return a;
    }
}
