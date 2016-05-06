package id.arieridwan.kafedoo;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import id.arieridwan.kafedoo.adapter.KafeAdapter;
import id.arieridwan.kafedoo.api.KafeAPI;
import id.arieridwan.kafedoo.model.KafeModel;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    private RecyclerView mRecyclerView;
    SwipeRefreshLayout mSwipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
       LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.activity_main_swipe_refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
                fetch();
            }
        });

    }

    private void fetch() {
        mSwipeRefreshLayout.setRefreshing(true);
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://dev.gits.co.id")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        KafeAPI service = restAdapter.create(KafeAPI.class);
        service.getKafe(new Callback<KafeModel>() {
            @Override
            public void success(KafeModel kafeResult, Response response) {
                final KafeAdapter mAdapter = new KafeAdapter(getApplicationContext(), kafeResult.getDATA());
                mRecyclerView.setAdapter(mAdapter);
                mSwipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
            }
        });
    }


    @Override
    public void onRefresh() {
        fetch();
    }
}
