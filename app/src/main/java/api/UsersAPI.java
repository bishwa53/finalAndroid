package api;

import bodies.ResBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UsersAPI {

    @FormUrlEncoded
    @POST("api/login/users/{loginType}")
    Call<ResBody> login(
            @Path("loginType") String loginType,
            @Field("username") String username,
            @Field("password") String password
    );

}
