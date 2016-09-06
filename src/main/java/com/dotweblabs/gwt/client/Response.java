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

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;

public class Response extends JSONObject {

    public Response(JSONObject response) {
        String type = response.get("type") != null ? response.get("type").isString().stringValue() : null;
        JSONObject token = response.get("token") != null ? response.get("token").isObject() : null;
        JSONObject paymentMethod = response.get("paymentMethod") != null ? response.get("paymentMethod").isObject() : null;
        JSONObject errors = response.get("errors") != null ? response.get("errors").isObject() : null; // TODO: Add this
        setType(type);
        setToken(new Token(token));
        setPaymentMethod(new PaymentMethod(paymentMethod));
    }

    public String getType() {
        return get("type").isString() != null ? get("type").isString().stringValue() : null;
    }

    public void setType(String type) {
        put("type", new JSONString(type));
    }

    public Token getToken() {
        JSONObject token = get("token").isObject();
        return new Token(token);
    }

    public void setToken(Token token) {
        put("token", token);
    }

    public PaymentMethod getPaymentMethod() {
        JSONObject paymentMethod = get("paymentMethod").isObject();
        return new PaymentMethod(paymentMethod);
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        put("paymentMethod", paymentMethod);
    }
}
