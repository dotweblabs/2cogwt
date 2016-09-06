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

import com.dotweblabs.gwt.client.callback.TCOResponse;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 *
 * Unit tests of {@link TCOTest}
 */
public class TCOTest extends GWTTestCase {

    TestResources resources;

    @Override
    public String getModuleName() {
        return "com.dotweblabs.gwt.2co";
    }

    public void gwtSetUp() {
        resources = GWT.create(TestResources.class);
    }

    public void testCreateToken() {
        delayTestFinish(20000);
        ScriptInjector.fromString(resources.tcoJs().getText())
                .setWindow(ScriptInjector.TOP_WINDOW)
                .inject();
        log("Test Started");
        TCO.loadPubKey("sandbox", new AsyncCallback<Void>() {
            @Override
            public void onFailure(Throwable throwable) {
                log("Test Failed: " + throwable.getMessage());
            }
            @Override
            public void onSuccess(Void aVoid) {
                log("Public Key ready");
                TokenRequest args = new TokenRequest();
                args.setSellerId(TestData.SELLER_ID);
                args.setPublishableKey(TestData.PUBLISHABLE_KEY);
                args.setCcNo(TestData.SUCCESS_CCNO);
                args.setCvv(TestData.CCV);
                args.setExpMonth(TestData.EXP_MONTH);
                args.setExpYear(TestData.EXP_YEAR);
                TCO.requestToken(args, new AsyncCallback<TCOResponse>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        log("Test Failed: " + caught.getMessage());
                        fail();
                        finishTest();
                    }
                    @Override
                    public void onSuccess(TCOResponse response) {
                        finishTest();
                        log("Response: " + response.getResponse());
                        log("Test Complete: " + response.getResponse().getToken().getToken());
                    }
                });
            }
        });
    }
    public static void log(String s){
        System.out.println(s);
    }
}
