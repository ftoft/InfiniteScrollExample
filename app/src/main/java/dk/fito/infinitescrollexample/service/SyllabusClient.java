package dk.fito.infinitescrollexample.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SyllabusClient {
    private static final String BASE_URL = "http://courseplanner-lbilde.rhcloud.com/api/";

    private static SyllabusClient instance = new SyllabusClient();
    public static SyllabusClient getInstance() {
        return instance;
    }

    private SyllabusService service;

    public SyllabusService getService() { return service; }

    private SyllabusClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(SyllabusService.class);
    }
}
