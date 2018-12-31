import kotlin.system.measureNanoTime

class TheNewOne {
    private var numberOFItems = 0
    private var itmes = IntArray(0)
    private val max = 10000000
    private val min = 0
    private var biggestOne: Int = 0
    private var finalCountArray = BooleanArray(0)
    init {
        numberOFItems = max
        biggestOne = max + 1
        for (i in 0 until 100) {
            numberOFItems += 10000
            itmes = IntArray(numberOFItems)
            getNumber()
            val runTime = measureNanoTime {
                getBiggestOne()
                createArray()
                laying()
            }
            println("(${runTime.div(1E4).toInt()},${numberOFItems.div(1E4).toInt()})")
        }
    }

    fun show() {
        for (i in 0 until biggestOne) {
            if (finalCountArray[i]) {
                println(i)
            }
        }
    }

    private fun laying() {
        for (i in 0 until numberOFItems) {
            finalCountArray[itmes[i]] = true
        }
    }

    private fun createArray() {
        finalCountArray = BooleanArray(biggestOne)
    }

    private fun getBiggestOne() {
        var max = 0
        for (i in 0 until itmes.size) {
            if (itmes[i] > max) {
                max = itmes[i]
            }
        }
        biggestOne = max + 1
    }

    private fun getNumber() {
        for (i in 0 until numberOFItems) {
            itmes[i] = ((Math.random() * max + 1).toInt() + min)
        }
    }
}

fun main(args: Array<String>) {
    while (true){
        print("do you wanna show the data : ")
        val s = readLine()
        if ("n" == s){
            TheNewOne()
        }else{
            val d = TheNewOne()
            d.show()
        }
    }
}
