package google.com.dynamicjson;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import google.com.dynamicjson.model.ExampleDynamic;
import google.com.dynamicjson.model.Exmple;
import google.com.dynamicjson.retrofit.WebServiceCaller;
import google.com.dynamicjson.util.Utility;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ProgressDialog progressDialog;
    private List<ExampleDynamic.Options> exampleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getNondynamc();
    }

    private void getNondynamc() {
        try {
            if (!Utility.isNetworkAvailable(this)) {
                Toast.makeText(this, R.string.no_internet_connection, Toast.LENGTH_SHORT).show();
            } else {
                progressDialog = new ProgressDialog(this);
                progressDialog.setMessage(getString(R.string.please_wait));
                progressDialog.setCancelable(false);
                progressDialog.show();
                WebServiceCaller.ApiInterface service = WebServiceCaller.getClient();
                Call<ResponseBody> call = service.getUrls(); //TODO need to pass USER_ID.
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            progressDialog.dismiss();
                            try {
                                String jsonDATA = response.body().string();
                                JSONObject jsonObject = new JSONObject(jsonDATA);
                                JSONObject jsonData = jsonObject.getJSONObject("***");
                                if (jsonData != null) {
                                    Iterator<String> it = jsonData.keys();
                                    while (it.hasNext()) {
                                        String key = it.next();
                                        try {
                                            if (jsonData.get(key) instanceof JSONObject) {
                                                JSONObject dynamicObjectKey = jsonData.getJSONObject(key);
                                                Gson gson = new Gson();
                                                Exmple exmple = gson.fromJson(dynamicObjectKey.toString(), Exmple.class);
                                                Log.i(TAG, "onResponse: NON" + exmple);

                                                getDynamic();

                                            } else {
                                                System.out.println(key + ":" + jsonData.getString(key));
                                            }
                                        } catch (Throwable e) {
                                            try {
                                                System.out.println(key + ":" + jsonData.getString(key));
                                            } catch (Exception ee) {
                                            }
                                            e.printStackTrace();

                                        }
                                    }
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        t.printStackTrace();
                        progressDialog.dismiss();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getDynamic() {
        try {
            if (!Utility.isNetworkAvailable(this)) {
                Toast.makeText(this, R.string.no_internet_connection, Toast.LENGTH_SHORT).show();
            } else {
                progressDialog = new ProgressDialog(this);
                progressDialog.setMessage(getString(R.string.please_wait));
                progressDialog.setCancelable(false);
                progressDialog.show();
                WebServiceCaller.ApiInterface service = WebServiceCaller.getClient();
                Call<ResponseBody> call = service.getUrls(); //TODO need to pass USER_ID.
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            progressDialog.dismiss();
                            try {
                                String jsonDATA = response.body().string();
                                JSONObject jsonObject = new JSONObject(jsonDATA);
                                JSONObject jsonData = jsonObject.getJSONObject("***");
                                if (jsonData != null) {
                                    Iterator<String> it = jsonData.keys();
                                    while (it.hasNext()) {
                                        String key = it.next();
                                        try {
                                            if (jsonData.get(key) instanceof JSONObject) {
                                                JSONObject dynamicObjectKey = jsonData.getJSONObject(key);

                                                ExampleDynamic exampleDynamic = new ExampleDynamic();
                                                exampleDynamic.setOptionCount(dynamicObjectKey.getInt("***"));
                                                exampleDynamic.setOptionGroupId(dynamicObjectKey.getString("***"));
                                                exampleDynamic.setOptionGroupName(dynamicObjectKey.getString("***"));

                                                JSONArray jsonArrayOptions = dynamicObjectKey.getJSONArray("***");
                                                for (int i = 0; i < jsonArrayOptions.length(); i++) {
                                                    JSONObject jsonObject1 = jsonArrayOptions.getJSONObject(i);
                                                    ExampleDynamic.Options nestedObject = new ExampleDynamic.Options();
                                                    nestedObject.setOptionGroupId(jsonObject1.getString("***"));
                                                    nestedObject.setOptionGroupName(jsonObject1.getString("***"));
                                                    nestedObject.setProductId(jsonObject1.getString("***"));
                                                    nestedObject.setOptionId(jsonObject1.getString("***"));
                                                    nestedObject.setOptionName(jsonObject1.getString("***"));
                                                    nestedObject.setOptionPrice(jsonObject1.getString("***"));
                                                    nestedObject.setIsActive(jsonObject1.getString("***"));
                                                    exampleList.add(nestedObject);
                                                }
                                                exampleDynamic.setOptionsList(exampleList);

                                                Log.i(TAG, "onResponse: Dynamic" + exampleDynamic);

                                            } else {
                                                System.out.println(key + ":" + jsonData.getString(key));
                                            }
                                        } catch (Throwable e) {
                                            try {
                                                System.out.println(key + ":" + jsonData.getString(key));
                                            } catch (Exception ee) {
                                            }
                                            e.printStackTrace();

                                        }
                                    }
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        t.printStackTrace();
                        progressDialog.dismiss();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
