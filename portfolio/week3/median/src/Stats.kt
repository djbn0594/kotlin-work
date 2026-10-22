// Task 7.7.1: statistics functions

fun median (list: List<Float>) : Float {
    val sorted = list.sorted()
    val len = list.size
    
    if (len < 1.0) {
        throw IllegalArgumentException()
    }
    
    else if (len % 2 == 1) {
        println(len)
        return sorted[len / 2]
    }
    else {
        return (sorted[len / 2] + sorted[(len / 2) - 1]) / 2
    }
}

fun stats (list: List<Float>) : List<Float> {
    var final = listOf(
        list.minOrNull()!!, 
        list.maxOrNull()!!, 
        list.average().toFloat(), 
        median(list)
        )

    return final
}