/*
 * Copyright 2017-2019 SgrAlpha
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.sgr.telegram.bot.api.utils;

import static io.sgr.telegram.bot.api.utils.TelegramUtils.parseBotIDFromToken;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * @author SgrAlpha
 */
public class TelegramUtilsTest {

    @Test
    public void testParseBotIdFromToken() {
        try {
            parseBotIDFromToken(null);
            fail();
        } catch (IllegalArgumentException e) {
            // expected
        }
        try {
            parseBotIDFromToken("\n");
            fail();
        } catch (IllegalArgumentException e) {
            // expected
        }
        try {
            parseBotIDFromToken(":");
            fail();
        } catch (IllegalArgumentException e) {
            // expected
        }
        try {
            parseBotIDFromToken(":aa");
            fail();
        } catch (IllegalArgumentException e) {
            // expected
        }
        try {
            parseBotIDFromToken("aa:");
            fail();
        } catch (IllegalArgumentException e) {
            // expected
        }
        try {
            parseBotIDFromToken("aa:bb");
            fail();
        } catch (IllegalArgumentException e) {
            // expected
        }
        try {
            parseBotIDFromToken("aa: bb");
            fail();
        } catch (IllegalArgumentException e) {
            // expected
        }
        try {
            parseBotIDFromToken("aa :bb");
            fail();
        } catch (IllegalArgumentException e) {
            // expected
        }
        try {
            parseBotIDFromToken("aa::bb");
            fail();
        } catch (IllegalArgumentException e) {
            // expected
        }
        assertEquals("000", parseBotIDFromToken("000:bb"));
    }

}
