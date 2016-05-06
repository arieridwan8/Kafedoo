package id.arieridwan.kafedoo.api;

import id.arieridwan.kafedoo.model.DetailModel;
import id.arieridwan.kafedoo.model.KafeModel;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by root on 01/05/16.
 */
public interface KafeAPI {
  @GET("/apicafe/public/list")
  void getKafe(Callback<KafeModel> cb);
  @GET("/apicafe/public/list/{id}")
  public void getDetail(@Path("id") String id,Callback<DetailModel> response);
}
