package google.com.dynamicjson.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class WebServiceCaller {

    private static ApiInterface apiInterface;

    public static ApiInterface getClient() {
        if (apiInterface == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient okclient = new OkHttpClient();
            Gson gson = new GsonBuilder().setLenient().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(WebUtility.BASE_URL)
                    .client(okclient.newBuilder()
                            .connectTimeout(100, TimeUnit.SECONDS)
                            .readTimeout(100, TimeUnit.SECONDS)
                            .writeTimeout(100, TimeUnit.SECONDS)
                            .addInterceptor(logging).build())
                    .addConverterFactory(GsonConverterFactory.create(gson)).build();

            apiInterface = client.create(ApiInterface.class);
        }
        return apiInterface;
    }

    public interface ApiInterface {

        @GET(WebUtility.END_URL)
        Call<ResponseBody> getUrls();

    }
}