package com.ycz.controller;

import com.github.pagehelper.PageInfo;
import com.ycz.pojo.Claz;
import com.ycz.pojo.User;
import com.ycz.service.ClazService;
import com.ycz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 该类用来描述与班级相关的操作
 */
@Controller
@RequestMapping("/claz")
public class ClazController {

    @Autowired
    private ClazService clazService;
    @Autowired
    private UserService userService;

    /**
     * 查找所有的班级
     */
    @GetMapping("/queryAll")
    public String queryAll(Model model){//用来存放素有班级的信息用以展示
        List<Claz> clazs = clazService.queryAll();
        model.addAttribute("clazs", clazs);
        return "claz";
    }

    /**
     * 查询该班级所有学生
     */
    @GetMapping("/queryStu")
    public String queryStu(Integer id, Model model, Integer pageNum, HttpServletRequest request){//接收url中传递过来的参数

        if (pageNum==null){
            pageNum=0;
        }

        PageInfo<User> userPageInfo=clazService.queryStudentByClazId(id,pageNum,5);
        model.addAttribute("stus", userPageInfo);
        request.getSession().setAttribute("id", id);

        return "student";
    }

    /**
     * 到增加班级页面
     */
    @GetMapping("/addClaz")
    public String addClaz(){
        return "addClaz";
    }

    /**
     * 添加班级
     */
    @PostMapping("/addClaz")
    public String addClass(Claz claz){
        claz.setCreateTime(new Date());
        clazService.addClaz(claz);
        return "redirect:/claz/queryAll";
    }

    /**
     * 添加学生界面
     */
    @GetMapping("/addStu")
    public String addStu(Integer id, Model model, HttpServletRequest request){
        List<Claz> clazs = clazService.queryAll();

        List<User> users = userService.queryAllNoClaz();

        model.addAttribute("stus", users);
        model.addAttribute("clazs", clazs);
        request.getSession().setAttribute("id", id);
        return "addStu";
    }

    /**
     * 添加学生
     */
    @GetMapping("/addStudent")
    public String addStudent(Integer stuId, Integer clazid, Model model, HttpServletRequest request){

        Integer id = (Integer) request.getSession().getAttribute("id");

        userService.updateUser(stuId,id);

        queryStu(clazid, model, 0, request);

        return null;
    }

}
