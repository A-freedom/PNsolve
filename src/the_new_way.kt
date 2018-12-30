import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

var numberOFItems = 0
var itmes = IntArray(0)
const val max = 1000000
const val min = 0
var biggestOne:Int =0
var finalCountArray = BooleanArray(0)
fun main(args: Array<String>) {
    numberOFItems = max
    biggestOne = max+1
    for (i in 0 until 100){
        numberOFItems += 10000
        itmes = IntArray(numberOFItems)
        getNmpers()
        val runTime = measureNanoTime {
            getBagerOne()
            createArray()
            laying()
        }
//        println("(${runTime.div(1E4).toInt()},${numberOFItems.div(1E4).toInt()}) k=${(runTime.div(1E4).toInt().div(numberOFItems.div(1E4).toInt()))}")
        println("(${runTime.div(1E4).toInt()},${numberOFItems.div(1E4).toInt()})")
    }
}

fun show() {
    for (i in 0 until numberOFItems){
        if (finalCountArray[i]){
            println(i)
        }
    }
}

fun laying() {
    for (i in 0 until numberOFItems){
//        println(itmes[i])
        finalCountArray[itmes[i]]  = true
    }
}

fun createArray() {
    finalCountArray = BooleanArray(biggestOne)
}

fun getBagerOne() {
    //TODO fix this function i dont have any idea how should fix this
}

fun getNmpers() {
    for (i in 0 until numberOFItems){
        itmes[i] = ((Math.random() * max+1).toInt() + min)
    }
}
