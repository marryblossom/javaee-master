package com.tw.core.service.courseService;

import com.tw.core.DAO.IBaseDao;
import com.tw.core.bean.Course;
import java.util.List;

/**
 * Created by marry on 7/16/15.
 */
public interface CourseService{
    public void insertCourse(Course course);
    public void delelteCourse(String id);
    public List<Course> getCourses();
    public Course getCourseById(String id);
    public void updateCourse(Course course);
    public List<Course> getCoursesOnlyActive();
}
