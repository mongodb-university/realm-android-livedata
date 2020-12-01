package com.mongodb.realm.livedataquickstart.model

import android.util.Log
import androidx.lifecycle.ViewModel
import io.realm.Realm
import io.realm.kotlin.where
import io.realm.mongodb.App
import io.realm.mongodb.AppConfiguration
import io.realm.mongodb.Credentials
import io.realm.mongodb.User
import io.realm.mongodb.sync.SyncConfiguration

class CounterModel : ViewModel() {
    private var realm: Realm
    var counter: LiveRealmObject<Counter>

    init {
    }

    fun incrementCounter() {
        realm.executeTransaction {
            counter.value?.add()
        }
    }

    override fun onCleared() {
        realm.close()
    }
}
