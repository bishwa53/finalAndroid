package api;


import java.util.List;

import model.Teacher;
import retrofit2.Call;
import retrofit2.http.GET;

public interface AttendanceAPI {

    @GET("api/shoes")
    Call<List<Teacher>> getTeacher();
}
