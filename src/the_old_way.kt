import kotlin.system.measureNanoTime

class TheOldOne{
    private var numberOFItems = 0
    private var items = ArrayList<Int>(0)
    private var max = 0
    private var min = 0
    private var finalCountArray = ArrayList<Int>()

    fun run(max:Int ,min:Int):String{
        this.max = max
        this.min = min
        this.numberOFItems = this.max
        this.getNumbers()
        val runTime = measureNanoTime {
            this.laying()
        }
//        println("(${runTime.div(1E4).toInt()},${this.numberOFItems.div(1E4).toInt()})")
        return "($runTime,${this.numberOFItems})"
    }

    private fun laying() {
        while (!items.isEmpty()) {
            var it = items[0]
            var saveI = 0
            for (i in 0 until items.size) {
                if (it > items[i]) {
                    it = items[i]
                    saveI = i
                }
            }
            finalCountArray.add(it)
            this.items = ArrayList(this.items).apply { removeAt(saveI) }
        }
    }

    fun show() {
        if (!this.finalCountArray.isEmpty()){
            println(this.finalCountArray.distinct().toList())
            println("show is done")
        }
    }

    private fun getNumbers() {
        for (i in 0 until this.numberOFItems) {
            this.items.add((Math.random() * this.max + 1).toInt() + this.min)
        }
    }
}

