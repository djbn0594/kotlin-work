// Task 7.7.1: statistics functions

fun median (list: List<Float>) : Float {
    val len = list.size
    
    if (len < 1.0) {
        throw IllegalArgumentException()
    }
    
    else if (len % 2 == 1) {
        println(len)
        return list[len / 2]
    }
    else {
        return (list[len / 2] + list[(len / 2) - 1]) / 2
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