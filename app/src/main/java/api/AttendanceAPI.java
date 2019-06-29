package api;


import java.util.List;

import model.Teacher;
import model.student;
import retrofit2.Call;
import retrofit2.http.GET;

public interface AttendanceAPI {

    @GET("api/Attendance")
    Call<List<Teacher>> getTeacher();

    Call<List<student>> getStudent();
}
