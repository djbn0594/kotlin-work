// COMP2850 Portfolio: Week 4
// Triangle class

import kotlin.math.sqrt

class Triangle (var sideA: Double, var sideB: Double, var sideC: Double) {
    
    val perimeter: Double = sideA + sideB + sideC
    val semiPerimeter: Double = perimeter / 2
    val area: Double
    
    init {
        if (!isValidTriangle()) {
            throw IllegalArgumentException("Invalid triangle sides")
        }
        
        area = triangleArea()
    }
    
    fun isValidTriangle(): Boolean {
        return (sideA + sideB > sideC) && (sideA + sideC > sideB) && (sideB + sideC > sideA)
    }

    fun triangleArea(): Double {  
        val area = Math.sqrt(semiPerimeter * (semiPerimeter - sideA) * (semiPerimeter - sideB) * (semiPerimeter - sideC))        
        return area
    }
    
    override fun toString(): String {
        return "Triangle($sideA, $sideB, $sideC)"
    }
}