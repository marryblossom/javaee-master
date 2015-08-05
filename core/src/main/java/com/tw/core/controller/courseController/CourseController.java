package com.tw.core.controller.courseController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tw.core.bean.Course;
import com.tw.core.bean.Schema;
import com.tw.core.service.courseService.CourseService;
import com.tw.core.service.schemaService.SchemaService;
import com.tw.core.util.HibernateProxyTypeAdapter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by marry on 7/19/15.
 */
@RestController
@RequestMapping("/courseOperate")
public class CourseController {
    private static final Log log = LogFactory.getLog(CourseController.class);
    private Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation() //不导出实体中没有用@Expose注解的属性
            .enableComplexMapKeySerialization() //支持Map的key为复杂对象的形式
            .serializeNulls().setDateFormat("yyyy-MM-dd")//时间转化为特定格式
//                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)//会把字段首字母大写,注:对于实体上使用了@SerializedName注解的不会生效.
            .setPrettyPrinting() //对json结果格式化.
            .setVersion(1.0)    //有的字段不是一开始就有的,会随着版本的升级添加进来,那么在进行序列化和返序列化的时候就会根据版本号来选择是否要序列化.
                    //@Since(版本号)能完美地实现这个功能.还的字段可能,随着版本的升级而删除,那么
                    //@Until(版本号)也能实现这个功能,GsonBuilder.setVersion(double)方法需要调用.
            .registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY)
            .create();
    @Autowired
    private CourseService courseService;
    @Autowired
    private SchemaService schemaService;
    @RequestMapping("/courseShow")
    public @ResponseBody String courseShow() {
        List<Course> courses = courseService.getCourses();
        return gson.toJson(courses);

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
//    @RequestMapping("/updateCourse")
//    public ModelAndView update(@RequestParam("courseId")String courseId,
//                                @RequestParam("courseName")String courseName,
//                               @RequestParam("introduction")String introduction) {
//        Course course = courseService.getCourseById(courseId);
//        course.setIntroduction(introduction);
//        course.setName(courseName);
//        courseService.updateCourse(course);
//        return new ModelAndView("redirect:/courseOperate/courseShow");
//    }
//    @RequestMapping("/goToCourseUpdate")
//    public ModelAndView goToCourseUpdate(@RequestParam("courseId")String courseId) {
//        Course course = courseService.getCourseById(courseId);
//        data.put("course", course);
//        return new ModelAndView("courseUpdate", data);
//    }
    @RequestMapping(value = "/unlockCourse/{courseId}", method = RequestMethod.GET)
    public void unlockCourse(@PathVariable String courseId){
        Course course = courseService.getCourseById(courseId);
        course.setState("active");
        courseService.updateCourse(course);
    }

}
