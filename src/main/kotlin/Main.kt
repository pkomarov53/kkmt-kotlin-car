import classes.*

fun engineInformationFiller(): Engine {
    println("\nДанные для класса Engine")
    print("\tПроизводитель двигателя: ")
    val engineManufacturer = readln()
    print("\tМощность двигателя: ")
    val enginePower = readln().toInt()
    print("\tМасса двигателя: ")
    val engineWeight = readln().toInt()

    return Engine(engineManufacturer, enginePower, engineWeight)
}

fun trailerInformationFiller(): Trailer {
    print("\nДанные для класса Trailer\n")
    print("\tПроизводитель прицепа: ")
    val trailerManufacturer = readln()
    print("\tМасса пустого прицепа: ")
    val emptyTrailerWeight = readln().toInt()
    print("\tМаксимально допустимая масса прицепа: ")
    val maxTrailerWeight = readln().toInt()
    print("\tТекущая масса прицепа: ")
    val curTrailerWeight = readln().toInt()

    return Trailer(trailerManufacturer, emptyTrailerWeight, maxTrailerWeight, curTrailerWeight)
}

fun carInformationFiller(engineInfo: Engine, trailerInfo: Trailer): Car {
    print("\nДанные для класса Car\n")
    print("\tМарка автомобиля: ")
    val carBrand = readln()
    print("\tМодель автомобиля: ")
    val carModel = readln()
    print("\tМасса автомобиля: ")
    val carWeight = readln().toInt()

    return Car(carBrand, carModel, carWeight, engineInfo, trailerInfo)
}
fun main() {
    val engineInfo = engineInformationFiller()
    val trailerInfo = trailerInformationFiller()
    val carInfo = carInformationFiller(engineInfo, trailerInfo)
    println("Меню программы:\n" +
            "1 - Вывести информацию об авто\n" +
            "2 - Вывести удельную мощность двигателя\n" +
            "3 - Добавить груз в прицеп\n" +
            "4 - Прицепить/отцепить прицеп\n" +
            "0 - Завершить работу программы\n")

    while (true) {
        when(readLine()) {
            "1" -> println(carInfo.informationOutput())
            "2" -> println(engineInfo.powerDensityCalculator(carInfo.carWeight +
                    engineInfo.engineWeight +
                    trailerInfo.curWeight, engineInfo.power))
            "3" -> println(trailerInfo.addWeight())
            "4" -> carInfo.trailerAssemble()
            "0" -> break
        }
    }
}