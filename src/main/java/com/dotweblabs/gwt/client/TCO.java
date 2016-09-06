/**
 *
 * Copyright (c) 2016 Dotweblabs Web Technologies and others. All rights reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.dotweblabs.gwt.client;

import com.dotweblabs.gwt.client.callback.TCOException;
import com.dotweblabs.gwt.client.callback.TCOResponse;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class TCO {
    public static native void loadPubKey(String pubKey)/*-{
        $wnd.TCO.loadPubKey(pubKey);
    }-*/;
    public static void requestToken(TokenRequest args, final AsyncCallback<TCOResponse> callback) {
        AsyncCallback<JavaScriptObject> aCallBack = new AsyncCallback<JavaScriptObject>() {
            @Override
            public void onFailure(Throwable throwable) {
                callback.onFailure(throwable);
            }

            @Override
            public void onSuccess(JavaScriptObject javaScriptObject) {
                JSONObject jsonObject = new JSONObject(javaScriptObject);
                callback.onSuccess(new TCOResponse(jsonObject));
            }
        };
        requestToken(args.getSellerId(),
                args.getPublishableKey(),
                args.getCcNo(),
                args.getCvv(),
                args.getExpMonth(),
                args.getExpYear(), aCallBack);
    }
    public static native void requestToken(String sellerId,
                                           String publishableKey,
                                           String ccNo,
                                           String cvv,
                                           String expMonth,
                                           String expYear,
                                           AsyncCallback<JavaScriptObject> callback)/*-{
        var successCallback = function(data) {
            @com.dotweblabs.gwt.client.TCO::callbackSuccess(Lcom/google/gwt/user/client/rpc/AsyncCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback, data);
        }
        var errorCallback = function(data) {
            @com.dotweblabs.gwt.client.TCO::callbackFailure(Lcom/google/gwt/user/client/rpc/AsyncCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback, data);
        }
        // Setup token request arguments
        var args = {
            sellerId: sellerId,
            publishableKey: publishableKey,
            ccNo: ccNo,
            cvv: cvv,
            expMonth: expMonth,
            expYear: expYear
        };

        // Make the token request
        $wnd.TCO.requestToken($entry(successCallback), $entry(errorCallback), args);
    }-*/;

    /**
     * Common success callback method
     *
     * * @param response
     */
    @SuppressWarnings("unused")
    public static void callbackSuccess(AsyncCallback<JavaScriptObject> callback, JavaScriptObject response){
        String s = response.toString();
        callback.onSuccess(response);
    }

    /**
     * Common failure callback method
     *
     * @param response
     */
    @SuppressWarnings("unused")
    public static void callbackFailure(AsyncCallback<JavaScriptObject> callback, JavaScriptObject response){
        String error = new JSONObject(response).toString();
        JSONObject errorObject = new JSONObject(response);
        Double errorCode = errorObject.get("errorCode") != null ? errorObject.get("errorCode").isNumber().doubleValue() : null;
        String errorMsg = errorObject.get("errorMsg") != null ? errorObject.get("errorMsg").isString().stringValue() : null;
        callback.onFailure(new TCOException(errorCode.intValue(), errorMsg));
    }

    public static native void log(String message)/*-{
        $wnd.console.log(message);
    }-*/;

}
