package timerTask;

import dao.daoService.CourseDao;
import dao.daoService.StudCourseDao;
import dao.daoService.StudentDao;
import model.Course;
import model.StudCourState;
import model.StudCourse;
import model.Student;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by ZhangYF on 2017/3/11.
 */
@Stateless(name = "TimerTaskEJB")
public class TimerTaskBean {
    private int count = 0;

    @EJB(name = "CourseDaoBean")
    private CourseDao courseDao;

    @EJB(name = "StudCourseDaoBean")
    private StudCourseDao studCourseDao;

    @EJB(name = "StudentDaoBean")
    private StudentDao studentDao;

    public TimerTaskBean() {
    }

    /**
     * 更新选课信息
     */
    @Schedule(second = "*/10", minute="*",hour="*")
    public void courseHandle(){

        Date today = getToday();
        List<StudCourse> studCourseList = studCourseDao.getAllCourses();

        for(StudCourse studCourse: studCourseList){
            Course course = studCourse.getCourse();
            Date start = course.getStartTime();
            Date end = course.getEndTime();

            if(end.before(today)){
                if(studCourse.getState() == StudCourState.STUDY){
                    studCourse.setState(StudCourState.ENDSTUDY);
                    studCourseDao.updateStudCourse(studCourse);
                }
            }else if(start.before(today)){
                if(studCourse.getState() == StudCourState.REVERSE){
                    studCourse.setState(StudCourState.STUDY);
                    studCourseDao.updateStudCourse(studCourse);
                }
            }
        }

        List<Course> courseList = courseDao.getAllCourses();
        for(Course course:courseList){
            if(course.getApproveState() == 1){
                Date end = course.getEndTime();
                if(end.before(today)){
                    course.setApproveState(2);
                    courseDao.updata(course);
                }
            }
        }
    }

    /**
     * 更新vip状态
     */
    @Schedule(second = "10", minute="30",hour="2")
    public void vipHandle(){
        List<Student> studentList = studentDao.getAllStudent();
        for(Student student:studentList){

            if(student.getVip()>0){//当前是vip
                if(student.getAccount().getMoney()<=0){//当前余额不足
                    int days = student.getVipdays();
                    if(days > 365){
                        student.setVip(0-student.getVip());
                        student.setVipdays(1);
                    }else{
                        days++;
                        student.setVipdays(days);
                    }
                    studentDao.update(student);
                }else{
                    int endCourseNum = studCourseDao.getCoursesByState(student.getStudentid(),StudCourState.ENDSTUDY).size();
                    student.setVip(endCourseNum/10+1);
                    studentDao.update(student);
                }
            }else if(student.getVip()<0){//当前状态是vip暂停状态
                if(student.getAccount().getMoney()<=0){//当前余额不足
                    int days = student.getVipdays();
                    if(days > 365){
                        student.setVip(0);
                        student.setVipdays(0);
                    }else{
                        days++;
                        student.setVipdays(days);
                    }
                    studentDao.update(student);
                }
            }
        }
        System.out.println("vip:"+count);
    }

    private Date getToday(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date today = Date.valueOf(df.format(new java.util.Date()));
        return today;
    }

}
