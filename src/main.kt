import kotlin.concurrent.thread

fun main(args: Array<String>) {
    // Compare time between the My way time O(n) old way time N!
    thread {
        var max = 10
        while (true) {
            val theOldOne = TheOldOne()
            print("TheOldOne ${theOldOne.run(max, 0)}")
            max += 1000000
            println("\n")
        }
    }
    thread {
        var max1 = 10
        while (true){
            val theNewOne = TheNewOne()
            println("TheNewOne ${theNewOne.run(max1, 0)}")
            max1 += 1000000
            println("\n")
        }
    }
}