fun main(args: Array<String>) {
    val person = Person("Man", 28f, "Palak")
    person.walk()
    println("")
    val baby = Baby("Baby", 0.1f, "Vivaan")
    baby.walk()

   /* println(C.getC(1))
    println(C.getC("Str"))*/

    println(MyClass().toString())
    println(MyClass(1).toString())
    println(MyClass(1,"2").toString())
    println(MyClass(1,"2",0.5).toString())
}

data class MyClass(val a: Int? = null, val b: String? = null, val c: Double? = null)

/*data class MyClass(val a: Int?, val b: String?, val c: Double?){
    constructor() : this(null,null,null)
    constructor(a : Int) : this(a,null,null)
    constructor(a : Int, b: String) : this(a,b,null)
}*/

class C private constructor(a: Int){
    companion object{
        fun getC(a : String) = C(a.length)
        fun getC(a : Int) = C(a)
    }
}

open class Human(open val type: String, open val age: Float) {
    open fun walk(): Boolean =
        if (age > 1) {
            println("$type is walking ")
            true
        } else {
            println("$type with $age age cant walk as of now.")
            false
        }
}

open class Person(val thistype: String, override val age: Float, name: String) : Human(thistype, age) {
    init {
        println("Name is $name of type $thistype.")
    }
    override fun walk(): Boolean {
        val walked = super.walk()
        if (!walked) {
            println("$thistype will learn to walk soon")
        }
        return walked
    }
}

class Baby (override val type: String, override val age: Float, name: String) : Person(type, age, name){

    init {
        println("Naam to suna hi honga! Hayye!")
    }

    override fun walk(): Boolean {
        val walked = super.walk()
        if (!walked) {
            println("But hey, I can crawl. Watch me!")
        }
        return walked
    }
}
