package dk.fito.infinitescrollexample.service;

import dk.fito.infinitescrollexample.service.responses.GetSyllabusesResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SyllabusService {
    @GET("syllabuses")
    Call<GetSyllabusesResponse> getSallybusses(@Query("limit") int limit, @Query("page") int page);
}
