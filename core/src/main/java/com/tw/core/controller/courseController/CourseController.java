package com.tw.core.controller.courseController;

import com.tw.core.bean.Course;
import com.tw.core.bean.Employee;
import com.tw.core.bean.User;
import com.tw.core.service.courseService.CourseService;
import com.tw.core.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by marry on 7/19/15.
 */
@Controller
@RequestMapping("/courseOperate")
public class CourseController {
    @Autowired
    private CourseService courseService;
    Map<String,Object> data = new HashMap<String,Object>();
    @RequestMapping("/courseShow")
    public ModelAndView courseShow() {
        List<Course> courses = courseService.getCourses();
        data.put("courses", courses);
        return new ModelAndView("course", data);

    }

    @RequestMapping("/addCourse")
    public ModelAndView addCourse(@RequestParam("courseName")String courseName,
                                  @RequestParam("introduction")String introduction,
                                  @CookieValue(value="loginId", defaultValue="") String userIdInCookie) {
        UUID courseId = new UUID(6, 6);
        Course course = new Course();
        course.setCourseId(courseId.randomUUID().toString());
        course.setName(courseName);
        course.setIntroduction(introduction);
        course.setState("active");
//        if (!(personIdInCookie.equals(""))) {
        courseService.insertCourse(course);
        return new ModelAndView("redirect:/courseOperate/courseShow");
//        } else {
//            return new ModelAndView("login");
//        }
    }

    @RequestMapping("/deleteCourse")
    // @UserAccessAnnotation(isLogin= ISLOGIN.YES)
    public ModelAndView deleteCourse(@RequestParam("courseId")String courseId,@CookieValue(value="loginId", defaultValue="") String userIdInCookie) {
//        if (!(userIdInCookie.equals(""))){
        courseService.changeCourseState(courseId);
        return new ModelAndView("redirect:/courseOperate/courseShow");
//        }else {
//            return new ModelAndView("login");
//        }
    }
    @RequestMapping("/updateCourse")
    public ModelAndView update(@RequestParam("courseId")String courseId,
                                @RequestParam("courseName")String courseName,
                               @RequestParam("introduction")String introduction,
                               @CookieValue(value="loginId", defaultValue="") String userIdInCookie) {
//        if (!(userIdInCookie.equals(""))){
        Course course = courseService.getCourseById(courseId);
        course.setIntroduction(introduction);
        course.setName(courseName);
        courseService.updateCourse(course);
        return new ModelAndView("redirect:/courseOperate/courseShow");
//        }else{
//            return new ModelAndView("login");
//        }

    }
    @RequestMapping("/goToCourseUpdate")
    public ModelAndView goToCourseUpdate(@RequestParam("courseId")String courseId,
                                   @CookieValue(value="loginId", defaultValue="") String userIdInCookie) {
//        if (!(userIdInCookie.equals(""))){
        Course course = courseService.getCourseById(courseId);
        data.put("course", course);
        return new ModelAndView("courseUpdate", data);
//        }
//        else {
//            return new ModelAndView("login");
//        }
    }

}
