package com.grec.install.referer;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "InstallReferer")
public class InstallRefererPlugin extends Plugin {

    InstallReferrerClient  referrerClient;
    String refrer = "";

    @Override
    public void load() {
        referrerClient = InstallReferrerClient.newBuilder(this.getContext()).build();
    }

    @PluginMethod
    public void getReferrer(PluginCall call) {
        //String value = call.getString("value");

        // on below line we are starting its connection.
        referrerClient.startConnection(new InstallReferrerStateListener() {
            @Override
            public void onInstallReferrerSetupFinished(int responseCode) {
                // this method is called when install referer setup is finished.
                switch (responseCode) {
                    // we are using switch case to check the response.
                    case InstallReferrerClient.InstallReferrerResponse.OK:
                        // this case is called when the status is OK and
                        ReferrerDetails response = null;
                        try {
                            // on below line we are getting referrer details
                            // by calling get install referrer.
                            JSObject result = new JSObject();

                            response = referrerClient.getInstallReferrer();

                            // on below line we are getting referrer url.
                            String referrerUrl = response.getInstallReferrer();

                            // on below line we are getting referrer click time.
                            long referrerClickTime = response.getReferrerClickTimestampSeconds();

                            // on below line we are getting app install time
                            long appInstallTime = response.getInstallBeginTimestampSeconds();

                            // on below line we are getting our time when
                            // user has used our apps instant experience.
                            boolean instantExperienceLaunched = response.getGooglePlayInstantParam();

                            // on below line we are getting our
                            // apps install referrer.
                            //refrer = response.getInstallReferrer();

                            result.put("referrer", referrerUrl);
                            result.put("clickTimestamp", referrerClickTime);
                            result.put("installBeginTimestamp", appInstallTime);

                            call.resolve(result);

                            referrerClient.endConnection();

                            // on below line we are setting all detail to our text view.
                            //refrerTV.setText("Referrer is : \n" + referrerUrl + "\n" + "Referrer Click Time is : " + referrerClickTime + "\nApp Install Time : " + appInstallTime);
                        } catch (RemoteException e) {
                            // handling error case.
                            JSObject result = new JSObject();
                            result.put("status",404);
                            result.put("Message",e.getMessage());
                            call.resolve(result);
                            //e.printStackTrace();
                        }
                        break;
                    case InstallReferrerClient.InstallReferrerResponse.FEATURE_NOT_SUPPORTED:
                        // API not available on the current Play Store app.
                       // Toast.makeText(getContext(), "Feature not supported..", Toast.LENGTH_SHORT).show();
                        break;
                    case InstallReferrerClient.InstallReferrerResponse.SERVICE_UNAVAILABLE:
                        // Connection couldn't be established.
                       // Toast.makeText(getContext(), "Fail to establish connection", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        call.reject("Unexpected value");
                        //throw new IllegalStateException("Unexpected value: " + responseCode);
                }
            }

            @Override
            public void onInstallReferrerServiceDisconnected() {
                // Try to restart the connection on the next request to
                // Google Play by calling the startConnection() method.
               // Toast.makeText(getContext(), "Service disconnected..", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
