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

import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;

public class Token extends JSONObject {

    public Token(JSONObject token) {
        Double dateCreated = token.get("dateCreated") != null ? token.get("dateCreated").isNumber().doubleValue() : null;
        String tokenToken = token.get("token") != null ? token.get("token").isString().stringValue() : null;
        setDateCreated(dateCreated);
        setToken(tokenToken);
    }

    public Double getDateCreated() {
        return get("dateCreated") != null ? get("dateCreated").isNumber().doubleValue() : null;
    }

    public void setDateCreated(Double dateCreated) {
        put("dateCreated", new JSONNumber(dateCreated));
    }

    public String getToken() {
        return get("token") != null ? get("token").isString().stringValue() : null;
    }

    public void setToken(String token) {
        put("token", new JSONString(token));
    }
}
