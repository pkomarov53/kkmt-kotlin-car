package classes

class Car(val brand: String, val model: String, val carWeight: Int, val engineInfo: Engine, val trailerInfo: Trailer) {

    private val tempTrailerWeight = trailerInfo.curWeight

    fun informationOutput() {
        val fullWeight = carWeight + engineInfo.engineWeight + trailerInfo.curWeight
        println("Мощность двигателя -> ${engineInfo.power}\n" +
                "Производитель двигателя -> ${engineInfo.manName}\n" +
                "Вес двигателя -> ${engineInfo.engineWeight}\n" +
                "Удельная мощность двигателя -> ${engineInfo.powerDensityCalculator(fullWeight, engineInfo.power)}\n")

        println("\nТекущая масса прицепа -> ${trailerInfo.curWeight}\n" +
                "Максимально допустимый масса прицепа -> ${trailerInfo.maxWeight}\n" +
                "Производитель прицепа -> ${trailerInfo.manName}\n")

        println("\nМарка машины -> $brand\n" +
                "Модель машины -> $model\n" +
                "Вес машины -> $carWeight\n" +
                "Максимальная скорость машины -> ${((engineInfo.power / (fullWeight * 9.8))).toFloat()}")
    }


    fun trailerAssemble() {
        var flag: Boolean = false
        if (!flag) {
            flag = true
            println("Прицеп был отцеплен")
            trailerInfo.curWeight = 0
        }
        else {
            println("Прицеп был прицеплен")
            trailerInfo.curWeight = tempTrailerWeight
        }
    }
}