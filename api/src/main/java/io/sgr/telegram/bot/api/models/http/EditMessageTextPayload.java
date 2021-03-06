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
package io.sgr.telegram.bot.api.models.http;

import static io.sgr.telegram.bot.api.utils.Preconditions.notEmptyString;
import static io.sgr.telegram.bot.api.utils.Preconditions.notNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.sgr.telegram.bot.api.models.ParseMode;
import io.sgr.telegram.bot.api.models.markups.ReplyMarkup;
import io.sgr.telegram.bot.api.utils.JsonUtil;

/**
 * @author SgrAlpha
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EditMessageTextPayload {

    private final String chatId;
    private final Long messageId;
    private final String inlineMessageId;
    private final String text;
    private final ParseMode parseMode;
    private final Boolean disablePreview;
    private final ReplyMarkup replyMarkup;

    /**
     * @param chatId         Unique identifier for the target chat or username of the target channel (in the
     *                       format @channelusername)
     * @param messageId      Identifier of the sent message.
     * @param text           New text of the message
     * @param parseMode      Optional. Send Markdown or HTML, if you want Telegram apps to show bold, italic,
     *                       fixed-width text or inline URLs in your bot's message.
     * @param disablePreview Optional. Disables link previews for links in this message.
     * @param replyMarkup    A JSON-serialized object for an inline keyboard.
     */
    public EditMessageTextPayload(long chatId, Long messageId, String text, ParseMode parseMode, Boolean disablePreview, ReplyMarkup replyMarkup) {
        this("" + chatId, messageId, text, parseMode, disablePreview, replyMarkup);
    }

    /**
     * @param chatId         Unique identifier for the target chat or username of the target channel (in the
     *                       format @channelusername)
     * @param messageId      Identifier of the sent message.
     * @param text           New text of the message
     * @param parseMode      Optional. Send Markdown or HTML, if you want Telegram apps to show bold, italic,
     *                       fixed-width text or inline URLs in your bot's message.
     * @param disablePreview Optional. Disables link previews for links in this message.
     * @param replyMarkup    Optional. A JSON-serialized object for an inline keyboard.
     */
    public EditMessageTextPayload(String chatId, Long messageId, String text, ParseMode parseMode, Boolean disablePreview, ReplyMarkup replyMarkup) {
        notEmptyString(chatId, "Chat ID should be provided");
        this.chatId = chatId;
        notNull(messageId, "Message ID should be provided");
        this.messageId = messageId;
        this.inlineMessageId = null;
        notEmptyString(text, "New text should be provided");
        this.text = text;
        this.parseMode = parseMode;
        this.disablePreview = disablePreview;
        this.replyMarkup = replyMarkup;
    }

    /**
     * @param inlineMessageId Identifier of the inline message.
     * @param text            New text of the message
     * @param parseMode       Optional. Send Markdown or HTML, if you want Telegram apps to show bold, italic,
     *                        fixed-width text or inline URLs in your bot's message.
     * @param disablePreview  Optional. Disables link previews for links in this message.
     * @param replyMarkup     Optional. A JSON-serialized object for an inline keyboard.
     */
    public EditMessageTextPayload(String inlineMessageId, String text, ParseMode parseMode, Boolean disablePreview, ReplyMarkup replyMarkup) {
        this.chatId = null;
        this.messageId = null;
        notNull(inlineMessageId, "Inline message ID should be provided");
        this.inlineMessageId = inlineMessageId;
        notEmptyString(text, "New text should be provided");
        this.text = text;
        this.parseMode = parseMode;
        this.disablePreview = disablePreview;
        this.replyMarkup = replyMarkup;
    }

    /**
     * @return the chatId
     */
    @JsonProperty("chat_id")
    public String getChatId() {
        return this.chatId;
    }

    /**
     * @return the messageId
     */
    @JsonProperty("message_id")
    public Long getMessageId() {
        return this.messageId;
    }

    /**
     * @return the inlineMessageId
     */
    @JsonProperty("inline_message_id")
    public String getInlineMessageId() {
        return this.inlineMessageId;
    }

    /**
     * @return the text
     */
    @JsonProperty("text")
    public String getText() {
        return this.text;
    }

    /**
     * @return the parseMode
     */
    @JsonProperty("parse_mode")
    public ParseMode getParseMode() {
        return this.parseMode;
    }

    /**
     * @return the disablePreview
     */
    @JsonProperty("disable_web_page_preview")
    public Boolean getDisablePreview() {
        return this.disablePreview;
    }

    @JsonProperty("reply_markup")
    public String getReplyMarkupJson() throws JsonProcessingException {
        if (this.replyMarkup == null) {
            return null;
        }
        return JsonUtil.getObjectMapper().writeValueAsString(this.replyMarkup);
    }

    /**
     * @return the replyMarkup
     */
    @JsonIgnore
    public ReplyMarkup getReplyMarkup() {
        return this.replyMarkup;
    }

}
