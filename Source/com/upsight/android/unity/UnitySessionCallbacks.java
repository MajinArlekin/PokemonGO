package com.upsight.android.unity;

import android.util.Log;
import com.upsight.android.UpsightContext;
import com.upsight.android.analytics.session.UpsightSessionCallbacks;
import com.upsight.android.managedvariables.experience.UpsightUserExperience;
import com.upsight.android.managedvariables.experience.UpsightUserExperience.Handler;
import java.util.List;
import org.json.JSONArray;

public class UnitySessionCallbacks implements UpsightSessionCallbacks {
    protected static final String TAG = "UnitySessionCallbacks";

    /* renamed from: com.upsight.android.unity.UnitySessionCallbacks.1 */
    class C09741 implements Handler {
        C09741() {
        }

        public boolean onReceive() {
            return UpsightPlugin.instance().getShouldSynchronizeManagedVariables();
        }

        public void onSynchronize(List<String> tags) {
            Log.i(UnitySessionCallbacks.TAG, "onSynchronize");
            JSONArray json = new JSONArray();
            for (String t : tags) {
                json.put(t);
            }
            UpsightPlugin.instance().UnitySendMessage("managedVariablesDidSynchronize", json.toString());
        }
    }

    public void onStart(UpsightContext upsight) {
        UpsightUserExperience.registerHandler(upsight, new C09741());
    }
}
