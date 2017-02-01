package com.elpassion.intelijidea.task

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage

@State(name = "MFBeforeTaskDefaultSettingsProvider", storages = arrayOf(Storage("mainframer.xml")))
class MFBeforeTaskDefaultSettingsProvider : PersistentStateComponent<MFBeforeTaskDefaultSettingsProvider.State> {
    private val myState = State()

    override fun getState(): State? = myState

    override fun loadState(state: State) {
        myState.defaultBuildCommand = state.defaultBuildCommand
        myState.defaultTaskName = state.defaultTaskName
        myState.defaultMainframerPath = state.defaultMainframerPath
    }

    class State {
        var defaultMainframerPath: String? = null
        var defaultBuildCommand: String? = null
        var defaultTaskName: String? = null
    }

    fun setDefaultMainframerScript(text: String) {
        myState.defaultMainframerPath = text
    }

    fun setDefaultBuildCommand(text: String) {
        myState.defaultBuildCommand = text
    }

    fun setDefaultTaskName(text: String) {
        myState.defaultTaskName = text
    }

    fun getDefaultMainframerScript(): String? = myState.defaultMainframerPath

    fun getDefaultBuildCommand(): String? = myState.defaultBuildCommand

    fun getDefaultTaskName(): String? = myState.defaultTaskName

    companion object {
        val INSTANCE: MFBeforeTaskDefaultSettingsProvider
            get() = ServiceManager.getService(MFBeforeTaskDefaultSettingsProvider::class.java)
    }
}




