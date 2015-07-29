package com.tw.core.controller.courseController;

import com.tw.core.bean.Course;
import com.tw.core.bean.Employee;
import com.tw.core.bean.Schema;
import com.tw.core.bean.User;
import com.tw.core.service.courseService.CourseService;
import com.tw.core.service.schemaService.SchemaService;
import flexjson.JSONSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by marry on 7/19/15.
 */
@RestController
@RequestMapping("/courseOperate")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private SchemaService schemaService;
    Map<String,Object> data = new HashMap<String,Object>();
    JSONSerializer j = new JSONSerializer();
    @RequestMapping("/courseShow")
    public @ResponseBody String courseShow() {
        List<Course> courses = courseService.getCourses();
        return j.exclude("schemas").serialize(courses);

    }
    @RequestMapping(value = "/addCourse", method = RequestMethod.POST)
    public void addCourse(@RequestParam String courseName, String introduction) {
        UUID uuid = new UUID(6, 6);
        Course course = new Course(uuid.randomUUID().toString(),courseName,introduction,"active","public");
        courseService.insertCourse(course);
    }

    @RequestMapping(value = "/{courseId}", method = RequestMethod.DELETE)
    public void deleteCourse(@PathVariable String courseId) {
        System.out.println("courseId~~~~~"+courseId);
        Course course = courseService.getCourseById(courseId);
        course.setState("locked");
        courseService.updateCourse(course);

        List<Schema> schemas = schemaService.getSchemasByCourse(course);
        schemaService.deleteAllSchemas(schemas);
    }
    @RequestMapping("/updateCourse")
    public ModelAndView update(@RequestParam("courseId")String courseId,
                                @RequestParam("courseName")String courseName,
                               @RequestParam("introduction")String introduction) {
        Course course = courseService.getCourseById(courseId);
        course.setIntroduction(introduction);
        course.setName(courseName);
        courseService.updateCourse(course);
        return new ModelAndView("redirect:/courseOperate/courseShow");
    }
    @RequestMapping("/goToCourseUpdate")
    public ModelAndView goToCourseUpdate(@RequestParam("courseId")String courseId) {
        Course course = courseService.getCourseById(courseId);
        data.put("course", course);
        return new ModelAndView("courseUpdate", data);
    }
    @RequestMapping(value = "/unlockCourse/{courseId}", method = RequestMethod.GET)
    public ModelAndView unlockCourse(@PathVariable String courseId){
        Course course = courseService.getCourseById(courseId);
        course.setState("active");
        courseService.updateCourse(course);
        return new ModelAndView("redirect:/courseOperate/courseShow");
    }

}
