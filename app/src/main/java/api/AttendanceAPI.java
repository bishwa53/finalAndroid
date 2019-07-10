package api;


import java.util.List;

import model.Attendance;
import model.Teacher;
import model.student;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AttendanceAPI {

    @GET("api/teacher")
    Call<List<Teacher>> getTeacher();


    @GET("api/student")
    Call<List<student>> getStudent();


    @GET("api/attendance")
    Call<List<Attendance>> getAttendace();


    @POST("api/teacher")
    Call<Void> addTeacher(@Body  Teacher teacher);

    @POST("api/student")
    Call<Void> addStudent(@Body  student student);

    @POST("api/attendance")
    Call<Void> addAttendance(@Body  Attendance attendance);






}
