import java.util.*
import kotlin.math.round

fun main() {
    var purchaseAmount = 0.0 //Сумма затрат на все покупки
    var musicLover = 1.0  //Скидка для меломана 1%
    var rubl: Int //В рублях
    var kop: Int //В копейках
    var result: Double //Результат после применения скидок
    val scan = Scanner(System.`in`)
    var purchaseCounter: Int = 0 //Счетчик покупок свыше 10 покупок становится меломаном
    println("Вы зашли в магазин музыки. Минимальная стоимость покупки 150 рублей")
    println("В нашем магазине присутствует система скидок")
    println("Скидка в 100 рублей при сумарной стоимости покупок за все время больше 1000 рублей")
    println("Скидка в 5% при сумарной стоимости покупок за все время больше 10000 рублей")
    println("Скидка в +1% для меломанов сделавших больше 10 покупок")
    while (true){
        println("На какую сумму вы хотите преобрести музыку?")
        purchaseCounter = purchaseCounter++
        var purchase = scan.nextInt()
        if (purchase < 150){
            println("Сумма покупки меньше 150 рублей")
        } else {
            purchaseCounter++
            purchaseAmount += purchase
            if (purchaseCounter > 10){
                musicLover = 0.99
            }
            if ((purchaseAmount >= 1001) && (purchaseAmount <= 10000)) {
                purchaseAmount -= purchase
                result = ((purchase - 100).toDouble()) * musicLover
                purchaseAmount = purchaseAmount + result
                rubl = round(result).toInt()
                kop = round((result - round(result)) * 100).toInt()
                println("Стоимость покупки с учетом скидки в 100 рублей составляет: $rubl рублей $kop копеек")
                println("Общая сумма ваших покупок за все время: $purchaseAmount")
                println("Всего сделано покупок: $purchaseCounter")
            } else if (purchaseAmount >= 10001) {
                purchaseAmount -= purchase
                result = (purchase.toDouble() * 0.95) * musicLover  //Стоимость покупки с учетом 5% скидки
                purchaseAmount = purchaseAmount + result
                rubl = round(result).toInt()
                kop = round((result - round(result)) * 100).toInt()
                println("Стоимость покупки с учетом скидки в 5% рублей составляет: $rubl рублей $kop копеек")
                println("Общая сумма ваших покупок за все время: $purchaseAmount")
                println("Всего сделано покупок: $purchaseCounter")
            }
            if (purchaseAmount <= 1000){
                purchaseAmount -= purchase
                result = purchase.toDouble() * musicLover
                purchaseAmount = purchaseAmount + result
                rubl = round(result).toInt()
                kop = round((result - round(result)) * 100).toInt()
                println("Стоимость покупки составляет: $rubl рублей $kop копеек")
                println("Общая сумма ваших покупок за все время: $purchaseAmount")
                println("Всего сделано покупок: $purchaseCounter")
            }
        }
    }


}