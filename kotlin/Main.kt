import kotlin.system.measureNanoTime

fun sortString(input: String): String = input.chars().sorted().toString()

fun main(args: Array<String>) {
    System.loadLibrary("rust_kotlin")

    val str = "Kotlin <3 Rust"

    // How many times to run the micro-benchmark
    val times = 2048

    var rustTotal = 0L
    var kotlinTotal = 0L

    var count = 0

    for (i in 0..times) {
        var sortedRust: String = ""
        var sortedKotlin: String = ""

        val rustTime = measureNanoTime {
            sortedRust = sortLetters(str)
        }

        val kotlinTime = measureNanoTime {
            sortedKotlin = sortString(str)
        }

        assert(sortedRust == sortedKotlin)

        rustTotal += rustTime
        kotlinTotal += kotlinTime

        count += 1
    }

    val rustAvg = rustTotal / count
    val kotlinAvg = kotlinTotal / count

    println("Rust time: ${rustAvg} ns")
    println("Kotlin time: ${kotlinAvg} ns")
}
