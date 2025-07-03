package com.sybylle.android.architecture.ui

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

/**
 * UiState - must be Data class, immutable
 */
interface UiStateDelegate<UiState, Event> {

    /**
     * Declarative description of the UI based on the current state.
     */
    val uiStateFlow: StateFlow<UiState>

    val singleEvents: Flow<Event>

    /**
     * State is read-only
     * The only way to change the state is to emit[reduce] an action,
     * an object describing what happened.
     */
    val UiStateDelegate<UiState, Event>.uiState: UiState

    /**
     * Transforms UI state using the specified transformation.
     *
     * @param transform  - function to transform UI state.
     */
    suspend fun UiStateDelegate<UiState, Event>.updateUiState(
        transform: (uiState: UiState) -> UiState,
    )

    /**
     * Changing the state without blocking the coroutine.
     */
    fun UiStateDelegate<UiState, Event>.asyncUpdateUiState(
        coroutineScope: CoroutineScope,
        transform: (state: UiState) -> UiState,
    ): Job

    suspend fun UiStateDelegate<UiState, Event>.sendEvent(event: Event)
}