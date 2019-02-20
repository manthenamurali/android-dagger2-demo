# android-dagger2-demo
Learning application using dagger2 and constraint layout.

## Annotations :-

    Most commonly used annotations,

     @Inject — base annotation whereby the “dependency is requested”
     @Module — classes which methods “provide dependencies”
     @Provide — methods inside @Module, which “tell Dagger how we want to build and present a dependency“
     @Component — bridge between @Inject and @Module
     @Scope — enables to create global and local singletons
     @Qualifier — if different objects of the same type are necessary

## References :-
https://android.jlelse.eu/dagger-2-part-i-basic-principles-graph-dependencies-scopes-3dfd032ccd82
https://stackoverflow.com/questions/42387631/singleton-component-cannot-depend-on-scoped-components

Constraint layout :- https://www.raywenderlich.com/9475-constraintlayout-tutorial-for-android-complex-layouts
Butterknife :- http://jakewharton.github.io/butterknife/