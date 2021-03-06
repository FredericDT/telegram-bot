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
package io.sgr.telegram.bot.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.sgr.telegram.bot.api.utils.JsonUtil;
import io.sgr.telegram.bot.api.utils.Preconditions;

/**
 * @author SgrAlpha
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class File {

    private final String fileId;
    private final Long fileSize;
    private final String filePath;

    /**
     * @param fileId   Unique identifier for this file.
     * @param fileSize Optional. File size, if known.
     * @param filePath Optional. File path. Use https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt; to get the file.
     */
    public File(
            @JsonProperty("file_id") String fileId,
            @JsonProperty("file_size") Long fileSize,
            @JsonProperty("file_path") String filePath) {
        Preconditions.notEmptyString(fileId, "File ID should be provided");
        this.fileId = fileId;
        this.fileSize = fileSize;
        this.filePath = filePath;
    }

    @JsonProperty("file_id")
    public String getFileId() {
        return fileId;
    }

    @JsonProperty("file_size")
    public Long getFileSize() {
        return fileSize;
    }

    @JsonProperty("file_path")
    public String getFilePath() {
        return filePath;
    }

    public String toJSON() {
        return JsonUtil.toJson(this);
    }

    @Override public String toString() {
        return this.toJSON();
    }

}
