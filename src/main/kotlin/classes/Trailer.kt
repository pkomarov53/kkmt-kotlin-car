package classes

class Trailer(val manName: String, emptyWeight: Int, val maxWeight: Int, var curWeight: Int) {

    fun addWeight() {
        print("Введите массу груза: ")
        val cargo = readln().toInt()
        if ((cargo + curWeight) <= maxWeight) {
            curWeight += cargo
            print("Груз добавлен в прицеп.")
        }
        else {
            println("Недопустимая масса")
            return
        }
    }
}