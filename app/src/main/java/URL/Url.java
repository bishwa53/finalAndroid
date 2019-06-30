package URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Url {

    public static final String BASE_URL = "http://10.0.2.2:3000/";
    public static String Cookie="";

//    public static int shoesId ;
//    public static int storeId ;
//
//    public static int userId;
//    public static String user;


    public static Retrofit getInstance(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Url.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
