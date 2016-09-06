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

public class PaymentMethod extends JSONObject {

    public PaymentMethod(JSONObject paymentMethod) {
        String expMonth = paymentMethod.get("expMonth") != null ? paymentMethod.get("expMonth").isString().stringValue() : null;
        String expYear = paymentMethod.get("expYear") != null ? paymentMethod.get("expYear").isString().stringValue() : null;
        String cardType = paymentMethod.get("cardType") != null ? paymentMethod.get("cardType").isString().stringValue() : null;
        String cardNum = paymentMethod.get("cardNum") != null ? paymentMethod.get("cardNum").isString().stringValue() : null;
        setExpYear(expYear);
        setExpMonth(expMonth);
        setCardNum(cardNum);
        setCardType(cardType);
    }

    public String getExpMonth() {
        return get("expMonth") != null ? get("expMonth").isString().stringValue() : null;
    }

    public void setExpMonth(String expMonth) {
        put("expMonth", new JSONString(expMonth));
    }

    public String getExpYear() {
        return get("expYear") != null ? get("expYear").isString().stringValue() : null;
    }

    public void setExpYear(String expYear) {
        put("expYear", new JSONString(expYear));
    }

    public String getCardType() {
        return get("cardType") != null ? get("cardType").isString().stringValue() : null;
    }

    public void setCardType(String cardType) {
        put("cardType", new JSONString(cardType));
    }

    public String getCardNum() {
        return get("getCardNum") != null ? get("getCardNum").isString().stringValue() : null;
    }

    public void setCardNum(String cardNum) {
        put("cardNum", new JSONString(cardNum));
    }
}
