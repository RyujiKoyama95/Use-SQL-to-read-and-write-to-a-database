/*
 * Copyright (C) 2021 The Android Open Source Project
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
package com.example.sqlbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.launch {
            AppDatabase.getDatabase(applicationContext).californiaParkDao().getAll()
        }
        // SQL文

        // *(ワイルドカード)は全てのカラム
        // SELECT * FROM テーブル名;

        // カラム名を,区切りで複数選択可能
        // SELECT name, city, type  FROM park;

        // 集計関数
        // SELECT COUNT(name) FROM park;
        // SELECT city, COUNT(*) FROM park;

        // 重複する値をクエリ
        // SELECT DISTINCT type FROM park;
        // SELECT COUNT(DISTINCT type) FROM park;

        // WHERE句 文字列は""ではなく''で囲む。読みやすさを考えて句ごとに改行。
        // 等価演算子は==ではなく=。不等価演算子は!=。
        // SELECT * FROM park
        // WHERE city = 'San Diego';

        // WHERE A AND B;
        // WHERE A OR B;
        // WHERE NOT A;
        // SELECT * FROM park
        // WHERE type = 'national_park' AND city = 'San Francisco';
        // SELECT * FROM park
        // WHERE NOT city = 'San Francisco'; 下の書き方でも同じ
        // WHERE city != 'San Francisco';

        // LIKE 検索
        // SELECT * FROM park
        // WHERE city LIKE '%San Francisco%'; 検索文字列は%%で囲む
        // WHERE city LIKE 'Sa%'; プレフィックッスは先頭だけ%を省略
        // WHERE city LIKE '%co'; サフィックスは末尾だけ%省略

        // INSERT
        // INSERT INTO park
        // VALUES ( 24, 'addName', 'Japan', '9999', null, '999999999', 'aaa' );

        // UPDATE
        // UPDATE park
        // SET city = 'Kyoto',
        // type = 'ccc'
        // WHERE name = 'Cabrillo';

        // DELETE
        // DELETE FROM park
        // WHERE name = 'Castle Mountains';
    }
}
