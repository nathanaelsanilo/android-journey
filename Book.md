# Book

### Composable

_work in progress_

### Lifecycle of composables

When Jetpack Compose runs your composables for the first time, during initial composition, it will keep track of the composables that you call to describe your UI in a composition. Then, when the state of your app changes, Jetpack Compose schedule a [recomposition](#recomposition).

1. Initial composition
2. Recomposition
3. Leaving the composition

reference: [Lifecycle overview](https://developer.android.com/develop/ui/compose/lifecycle#lifecycle-overview)

### Composition

A Composition is a tree-structure of the composables that describe your UI. Composition describe the UI of your app and is produced by running composables.

### Remember in composables

`remember` API can store an object in memory. A value computed by `remember` is stored in the Composition during initial composition, and the stored value is returned during recomposition.
`remember` can be used to store both mutable and immutable objects.

`remember` stores objects in the Composition, and forgets the object when the composable that called remember is removed from the Composition

reference: [State in composables](https://developer.android.com/develop/ui/compose/state#state-in-composables)

### Recomposition

Recomposition is when Jetpack Compose re-executes the composables that may have changed in response to state changes, and then updates the Composition to reflect any changes. The only way to modify a Composition is through recomposition.
