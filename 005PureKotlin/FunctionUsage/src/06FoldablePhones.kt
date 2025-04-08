


fun main() {
    val foldablePhone = FoldablePhone(isFolded = false)

    foldablePhone.checkPhoneScreenLight()
    foldablePhone.switchOn()
    foldablePhone.checkPhoneScreenLight()
    foldablePhone.unfold()
    foldablePhone.checkPhoneScreenLight()
    foldablePhone.switchOn()
    foldablePhone.checkPhoneScreenLight()
}

class FoldablePhone(var isFolded: Boolean = true): Phone() {

    override fun switchOn() {
        if(!isFolded) {
            isScreenLightOn = true
        }
    }

    fun fold() {
        isFolded = true
    }
    fun unfold() {
        isFolded = false
    }
}

open class Phone(var isScreenLightOn: Boolean = false) {

    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight")
    }

}