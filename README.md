# Kotlin - Rust interop
This repository contains some sample code for using Rust together with Kotlin.

## Contents
The app runs a simple micro-benchmark between Kotlin and Rust.
It consists of sorting a random string lexicographically.

Both the Kotlin and Rust implementation are using functional-programming,
with Kotlin using [streams][streams] and Rust using [iterators][iter].

[streams]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.streams/index.html
[iter]: https://doc.rust-lang.org/std/iter/

## Dependencies
You will need:
- a Java runtime (such as Oracle's JRE on Windows or OpenJDK on Linux)
- [Kotlin](https://github.com/JetBrains/kotlin)
- [Rust](https://www.rust-lang.org)
- GNU [Make](https://www.gnu.org/software/make/)

## Building / Running
Just run `make`.

## Results
Rust is consistently 3-5 times faster than the equivalent Kotlin code.

## Support libraries
The [jni-rs](https://github.com/prevoty/jni-rs) crate is used in Rust to access JVM types,
and a simple Kotlin app loads and runs the Rust code.
