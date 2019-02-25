/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.newsapp;

// The NewsArticle class holds information regarding the particular news article. These objects
// are held in the ArrayList.
public class NewsArticle {

    private String articleTitle;
    private String articleDate;
    private String articleCategory;
    private String articleURL;

    public NewsArticle(String articleTitle, String articleDate, String articleCategory, String url) {
        this.articleTitle = articleTitle;
        this.articleDate = articleDate;
        this.articleCategory = articleCategory;
        articleURL = url;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public String getDate() {
        return articleDate;
    }

    public String getArticleCategory() {
        return articleCategory;
    }

    public String getUrl() {
        return articleURL;
    }
}