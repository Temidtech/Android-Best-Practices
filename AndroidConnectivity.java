//This code snippet tests network connectivity for Wi-Fi and mobile.
//It determines whether these network interfaces are available 
//(that is, whether network connectivity is possible) and/or 
//connected (that is, whether network connectivity exists and
//if it is possible to establish sockets and pass data):

private static final String DEBUG_TAG = "NetworkStatusExample";
...
ConnectivityManager connMgr = (ConnectivityManager)
        getSystemService(Context.CONNECTIVITY_SERVICE);
NetworkInfo networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
boolean isWifiConn = networkInfo.isConnected();
networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
boolean isMobileConn = networkInfo.isConnected();
Log.d(DEBUG_TAG, "Wifi connected: " + isWifiConn);
Log.d(DEBUG_TAG, "Mobile connected: " + isMobileConn);



//A more concise way of checking whether a network interface is available is as follows. 
//The method getActiveNetworkInfo() returns a NetworkInfo instance representing the first
//connected network interface it can find, or null if none of the interfaces is connected 
//(meaning that an internet connection is not available):

public boolean isOnline() {
    ConnectivityManager connMgr = (ConnectivityManager)
            getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
    return (networkInfo != null && networkInfo.isConnected());
}  



