package interview.kotlin

open class Player constructor(open var name: String, open var age: Int) {
    open fun getPlayerName(): String {
        return this.name
    }
}

class SoccerPlayer constructor(
    name: String,
    age: Int,
    teamName: String,
    country: String = "KOR"
): Player(name, age) {
    override var name: String = super.name
    override var age: Int = super.age
    private var teamName: String = teamName
    private var country: String = country

    override fun getPlayerName(): String {
        return "Hi! I'm soccer player ${this.name} in ${this.teamName}"
    }
}

class GolfPlayer constructor(
    name: String,
    age: Int,
    sponsor: String,
    awards: List<String>
): Player(name, age) {
    override var name: String = super.name
    override var age: Int = super.age
    private var sponsor: String = sponsor
    private var awards: List<String> = awards

    override fun getPlayerName(): String {
        return "Hi! I'm golf player ${this.name}"
    }
}

fun main() {
    val mySoccerPlayer = SoccerPlayer("Son", 29, "Tottenham")
    val golfPlayer = GolfPlayer("Park", 39, "Hyundai", listOf("LPGA"))
    println(mySoccerPlayer.getPlayerName()) // Hi! I'm soccer player Son in Tottenham
    println(golfPlayer.getPlayerName()) // Hi! I'm golf player Park
}