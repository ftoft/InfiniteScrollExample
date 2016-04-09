package dk.fito.infinitescrollexample.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import dk.fito.infinitescrollexample.R;
import dk.fito.infinitescrollexample.adapters.SyllabusAdapter;
import dk.fito.infinitescrollexample.service.SyllabusClient;
import dk.fito.infinitescrollexample.service.responses.GetSyllabusesResponse;
import dk.fito.infinitescrollexample.utils.EndlessScrollListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int VISIBLE_THRESHOLD = 15;
    private static final int SIZE_TO_LOAD = 40;

    private SyllabusAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.list_view);

        adapter = new SyllabusAdapter(this);
        listView.setAdapter(adapter);

        LoadDocuments(1);

        listView.setOnScrollListener(new EndlessScrollListener(VISIBLE_THRESHOLD) {
            @Override
            public boolean onLoadMore(int page, int totalItemsCount) {
                LoadDocuments(page);

                //TODO: Need some refactoring to implement this correctly because of async calls.
                return true; // ONLY if more data is actually being loaded; false otherwise.
            }
        });
    }

    private void LoadDocuments(int page) {

        Log.d(TAG, "Page to load: " + page);

        SyllabusClient.getInstance().getService().getSallybusses(SIZE_TO_LOAD, page).enqueue(new Callback<GetSyllabusesResponse>() {
            @Override
            public void onResponse(Call<GetSyllabusesResponse> call, Response<GetSyllabusesResponse> response) {
                List<GetSyllabusesResponse.Document> documentList = response.body().getDocs();
                adapter.addAll(documentList);
            }

            @Override
            public void onFailure(Call<GetSyllabusesResponse> call, Throwable t) {
                Toast.makeText(getBaseContext(), "Failed to load data from web service!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
