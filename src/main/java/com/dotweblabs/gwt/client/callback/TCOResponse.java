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
package com.dotweblabs.gwt.client.callback;

import com.dotweblabs.gwt.client.Response;
import com.google.gwt.json.client.JSONObject;

public class TCOResponse extends JSONObject {

    private Response response;

    public TCOResponse(JSONObject tcoResponse) {
        JSONObject validationErrors = tcoResponse.get("validationErrors") != null ? tcoResponse.get("validationErrors").isObject() : null;
        JSONObject response = tcoResponse.get("response") != null ? tcoResponse.get("response").isObject() : null;
        setResponse(new Response(response));
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
