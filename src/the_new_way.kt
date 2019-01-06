import kotlin.system.measureNanoTime

class TheNewOne {
    private var numberOFItems = 0
    private var itmes = IntArray(0)
    private var max = 10000000
    private var min = 0
    private var biggestOne: Int = 0
    private var finalCountArray = BooleanArray(0)
    fun run(max: Int, min: Int):String {
        this.max = max
        this.min = min
        this.numberOFItems = this.max
        this.biggestOne = this.max + 1

        this.itmes = IntArray(this.numberOFItems)
        this.getNumbers()
        val runTime = measureNanoTime {
            this.getBiggestOne()
            this.createArray()
            this.laying()
        }
//            println("(${runTime.div(1E4).toInt()},${this.numberOFItems.div(1E4).toInt()})")
        return "($runTime,${this.numberOFItems})"


    }

    fun show() {
        for (i in 0 until this.biggestOne) {
            if (this.finalCountArray[i]) {
                println(i)
            }
        }
    }

    private fun laying() {
        for (i in 0 until this.numberOFItems) {
            this.finalCountArray[this.itmes[i]] = true
        }
    }

    private fun createArray() {
        this.finalCountArray = BooleanArray(this.biggestOne)
    }

    private fun getBiggestOne() {
        var max = 0
        for (i in 0 until this.itmes.size) {
            if (this.itmes[i] > max) {
                max = this.itmes[i]
            }
        }
        this.biggestOne = max + 1
    }

    private fun getNumbers() {
        for (i in 0 until this.numberOFItems) {
            this.itmes[i] = ((Math.random() * this.max + 1).toInt() + this.min)
        }
    }
}

