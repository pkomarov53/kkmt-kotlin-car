package classes

class Engine(val manName: String, val power: Int, val engineWeight: Int) {

    fun powerDensityCalculator(weight: Int, power: Int): Float {
        return (weight.toFloat() / power.toFloat())
    }
}