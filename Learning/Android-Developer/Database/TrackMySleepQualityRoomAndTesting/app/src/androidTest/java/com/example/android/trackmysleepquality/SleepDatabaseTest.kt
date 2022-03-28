/*
 * Copyright 2019, The Android Open Source Project
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

package com.example.android.trackmysleepquality

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.android.trackmysleepquality.database.SleepDatabase
import com.example.android.trackmysleepquality.database.SleepDatabaseDao
import com.example.android.trackmysleepquality.database.SleepNight
import org.junit.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException


/**
 * This is not meant to be a full set of tests. For simplicity, most of your samples do not
 * include tests. However, when building the Room, it is helpful to make sure it works before
 * adding the UI.
 */

//The @RunWith annotation identifies a test runner, which is the program that sets up and runs the test.
@RunWith(AndroidJUnit4::class)
// class UnitTest
class SleepDatabaseTest {

    private lateinit var sleepDao: SleepDatabaseDao
    private lateinit var db: SleepDatabase

    /*
    * - During setup, the function described with @Before is executed, and it creates a deep SleepDatabase
    *   memory with SleepDatabaseDao. "In memory" means this database is not stored in the file system and
    *   will be deleted after the test is run.
    *
    * - Also when building an in-memory database, the code calls another test-specific method, allowMainThreadQueries.
    *   By default, you get an error if you try to run the query on the main thread. This method allows you to run
    *   tests on the main thread, which you should only do during testing
    * */
    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, SleepDatabase::class.java)
                // Allowing main thread queries, just for testing.
                .allowMainThreadQueries()
                .build()
        sleepDao = db.sleepDatabaseDao
    }

//    When the test is complete, the function described with @After executes to close the database.
    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    /*
    * In the test method annotated with @Test, you create, insert, and retrieve a SleepNight,
    * and assert that they are the same. If something goes wrong, throw an exception. In real
    * tests, you will have many @Testmethods.
    * */
    @Test
    @Throws(Exception::class)
    fun insertAndGetNight() {
        val night = SleepNight()
        sleepDao.insert(night)
        val tonight = sleepDao.getTonight()
        assertEquals(tonight?.sleepQuality, -1)
    }
}