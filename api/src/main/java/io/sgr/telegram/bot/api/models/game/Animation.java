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
package io.sgr.telegram.bot.api.models.game;

import static io.sgr.telegram.bot.api.utils.Preconditions.notEmptyString;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.sgr.telegram.bot.api.models.PhotoSize;
import io.sgr.telegram.bot.api.utils.JsonUtil;

/**
 * You can provide an animation for your game so that it looks stylish in chats (check out Lumberjack for an example).
 * This object represents an animation file to be displayed in the message containing a game.
 *
 * @author SgrAlpha
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Animation {

    private final String fileId;
    private final PhotoSize thumb;
    private final String fileName;
    private final String mimeType;
    private final long fileSize;

    /**
     * @param fileId   Unique identifier for this file.
     * @param thumb    Optional. Animation thumbnail as defined by sender.
     * @param fileName Optional. Original animation filename as defined by sender.
     * @param mimeType Optional. MIME type of the file as defined by sender.
     * @param fileSize Optional. File size.
     */
    @JsonCreator
    public Animation(
            @JsonProperty("file_id") String fileId,
            @JsonProperty("thumb") PhotoSize thumb,
            @JsonProperty("file_name") String fileName,
            @JsonProperty("mime_type") String mimeType,
            @JsonProperty("file_size") long fileSize) {
        notEmptyString(fileId, "File ID should be provided");
        this.fileId = fileId;
        this.thumb = thumb;
        this.fileName = fileName;
        this.mimeType = mimeType;
        this.fileSize = fileSize;
    }

    @JsonProperty("file_id")
    public String getFileId() {
        return fileId;
    }

    @JsonProperty("thumb")
    public PhotoSize getThumb() {
        return thumb;
    }

    @JsonProperty("file_name")
    public String getFileName() {
        return fileName;
    }

    @JsonProperty("mime_type")
    public String getMimeType() {
        return mimeType;
    }

    @JsonProperty("file_size")
    public long getFileSize() {
        return fileSize;
    }

    public String toJSON() {
        return JsonUtil.toJson(this);
    }

    @Override public String toString() {
        return this.toJSON();
    }

}
