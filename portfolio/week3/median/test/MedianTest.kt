// COMP2850 Portfolio: Week 3
// Tests for median()

import io.kotest.core.spec.style.FreeSpec
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.matchers.floats.plusOrMinus

const val tolerance = 0.000001f

@Suppress("Unused")
class MedianTest : FreeSpec({
    "Exception when size=0" {
        shouldThrow<IllegalArgumentException> {
            median(listOf())
        }
    }

    // Write four more tests here
    
    "Size=1" {
        median(listOf(3.0f)) shouldBe 3.0
    }
    
    "Size=2" {
        median(listOf(3.0f, 5.0f)) shouldBe 4.0
    }
    
    "Size=3" {
        median(listOf(3.0f, 5.0f, 9.0f)) shouldBe 5.0
    }
    
    "Size=4" {
        median(listOf(3.0f, 5.0f, 9.0f, 12.0f)) shouldBe 7.0
    }
})
