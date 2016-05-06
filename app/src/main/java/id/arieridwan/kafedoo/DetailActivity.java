package id.arieridwan.kafedoo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import id.arieridwan.kafedoo.adapter.FasilitasAdapter;
import id.arieridwan.kafedoo.api.KafeAPI;
import id.arieridwan.kafedoo.model.DATum;
import id.arieridwan.kafedoo.model.DetailFasilitas;
import id.arieridwan.kafedoo.model.DetailModel;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class DetailActivity extends AppCompatActivity {

    private GoogleMap googleMap;
    public static final String EXTRA_KAFE = "kafe";
    private DATum mKafe;
    private List<DetailFasilitas> mDetailList;
    ListView lv;
    TextView nama,alamat,des;
    ImageView foto;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (getIntent().hasExtra(EXTRA_KAFE)) {
            mKafe = getIntent().getParcelableExtra(EXTRA_KAFE);
        } else {
            throw new IllegalArgumentException("Detail not found");
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nama = (TextView)findViewById(R.id.nama);
        alamat = (TextView)findViewById(R.id.alamat);
        des = (TextView)findViewById(R.id.tvDes);
        foto = (ImageView)findViewById(R.id.foto);
        lv=(ListView) findViewById(R.id.listView);
       Picasso.with(getApplicationContext()).load(mKafe.getUrl_foto()).centerCrop().resize(600, 400).into(foto);
        nama.setText(mKafe.getNama());
        alamat.setText(mKafe.getAlamat());
        getSupportActionBar().setTitle("");
        id = mKafe.getId();
        fetch();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {

            NavUtils.navigateUpTo(this, new Intent(this, MainActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void fetch(){
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://dev.gits.co.id")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        KafeAPI service = restAdapter.create(KafeAPI.class);
        service.getDetail(id, new Callback<DetailModel>() {
            @Override
            public void success(DetailModel detailModel, Response response) {
                des.setText(detailModel.getDATA().getDeskripsi());
                List<String> latList = detailModel.getDATA().getLocation().getLatitude();
                List<String> lngList = detailModel.getDATA().getLocation().getLongitude();
                Double lat = Double.parseDouble(latList.get(0));
                Double lng = Double.parseDouble(lngList.get(0));
                LatLng locations = new LatLng(lat,lng);
                try {
                    if (googleMap == null) {
                        googleMap = ((MapFragment) getFragmentManager().
                                findFragmentById(R.id.map)).getMap();
                    }
                    googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    Marker local = googleMap.addMarker(new MarkerOptions().position(locations)
                            .title(mKafe.getNama()));
                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(locations, 15));
                    googleMap.animateCamera(CameraUpdateFactory.zoomTo(13), 2000, null);


                }
                catch (Exception e) {
                    e.printStackTrace();
                }

                mDetailList  = new ArrayList<>();
                mDetailList.addAll(detailModel.getDATA().getFasilitas());
                FasilitasAdapter adapt = new FasilitasAdapter(getApplicationContext(),R.layout.fasilitas, (ArrayList<DetailFasilitas>) mDetailList);
                lv.setAdapter(adapt);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });


    }

}
