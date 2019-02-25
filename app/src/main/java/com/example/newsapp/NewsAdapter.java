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

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


// The NewsAdapter is responsible for sifting through the array of NewsArticle objects and assigning
// data to the layouts.
public class NewsAdapter extends ArrayAdapter<NewsArticle> {

    private static final String LOCATION_SEPARATOR = " of ";

    public NewsAdapter(Context context, List<NewsArticle> newsArticles) {
        super(context, 0, newsArticles);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.article_list_item, parent, false);
        }
        NewsArticle currentNewsArticle = getItem(position);
        TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.article_title);
        primaryLocationView.setText(currentNewsArticle.getArticleTitle());
        TextView articleCategory = (TextView) listItemView.findViewById(R.id.article_category);
        articleCategory.setText(currentNewsArticle.getArticleCategory());
        String rawDate = currentNewsArticle.getDate();
        rawDate = rawDate.substring(0, 10);
        SimpleDateFormat oldDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat newDateFormat = new SimpleDateFormat("LLL dd, yyyy");
        Date dateObject = new Date();
        String formattedDate = "Unknown";
        try {
            dateObject = oldDateFormat.parse(rawDate);
            formattedDate = newDateFormat.format(dateObject);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        dateView.setText(formattedDate);
        return listItemView;
    }
}