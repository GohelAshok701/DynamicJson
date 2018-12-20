package google.com.dynamicjson.util;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;

public class Utility {

    public static boolean isNetworkAvailable(Activity activity)
    {

        ConnectivityManager connectivityManager =  (ConnectivityManager)activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();
    }
}