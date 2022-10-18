package com.example.viewmodelstate_app

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

// ViewModel 中使用 SavedStateHandle，避免旋轉造成資料遺失
class SaveStateViewModel(state: SavedStateHandle): ViewModel() {
    val counterLiveData = state.getLiveData<Int>("Counter")

    fun increment() {
        // counter value += 1
        counterLiveData.value = (counterLiveData.value ?: 0) + 1
    }
}