package com.tw.core.service.courseService.CourseServiceImpl;

import com.tw.core.bean.Course;
import com.tw.core.service.baseService.impl.BaseServiceImpl;
import com.tw.core.service.courseService.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by marry on 7/16/15.
 */
@Service
public class CourseServiceImpl extends BaseServiceImpl implements CourseService {
    @Override
    public void insertCourse(Course course) {
        this.save(course);
    }

    @Override
    public void delelteCourse(String id) {
        this.deleteById(Course.class, id);
    }

    @Override
    public List<Course> getCourses() {
        List<Course> courses = this.queryAll(Course.class);
        return courses;
    }

    @Override
    public Course getCourseById(String id) {
        Course course = findById(Course.class, id);
        return course;
    }

    @Override
    public void updateCourse(Course course) {
        this.update(course);
    }
    @Override
    public void changeCourseState(String courseId){
        Course course = getCourseById(courseId);
        course.setState("block");
        updateCourse(course);
    }
}