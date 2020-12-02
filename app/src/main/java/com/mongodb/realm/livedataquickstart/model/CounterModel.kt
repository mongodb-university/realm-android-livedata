package com.mongodb.realm.livedataquickstart.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.realm.Realm
import io.realm.kotlin.where
import io.realm.mongodb.App
import io.realm.mongodb.AppConfiguration
import io.realm.mongodb.Credentials
import io.realm.mongodb.User
import io.realm.mongodb.sync.SyncConfiguration


class CounterModel : ViewModel() {
    private var realm: Realm? = null
    private val _counter: LiveRealmObject<Counter> = LiveRealmObject(null)
    val counter: LiveData<Counter>
        get() = _counter

    fun incrementCounter() {
        realm?.executeTransaction {
            counter.value?.let { counterValue ->
                counterValue.add()
                _counter.postValue(counterValue)
                Log.v("QUICKSTART", "Incremented counter. New value: ${counterValue.value.get()}")
            }
        }
    }

    override fun onCleared() {
        realm?.close()
    }
}
