package com.sybylle.android.architecture.ui

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow

interface InternalStateDelegate<State> {

    /**
     * Get the internal state as data flow.
     */
    val InternalStateDelegate<State>.internalStateFlow: Flow<State>

    /**
     * Get the current internal state.
     */
    val InternalStateDelegate<State>.internalState: State

    /**
     * Transforms internal state using the specified transformation.
     *
     * @param transform  - function to transform internal state.
     */
    suspend fun InternalStateDelegate<State>.updateInternalState(
        transform: (state: State) -> State,
    )

    /**
     * Changing the state without blocking the coroutine.
     */
    fun InternalStateDelegate<State>.asyncUpdateInternalState(
        coroutineScope: CoroutineScope, transform: (state: State) -> State
    ): Job
}