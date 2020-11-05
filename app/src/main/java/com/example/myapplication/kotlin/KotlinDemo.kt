package com.example.myapplication.kotlin

class KotlinDemo {

    private var name: String? = null
    private var age: Int
    get() {
        return age
    }
    set(value) {
        age = value
    }

    var sex: String
        get() {
            return sex
        }
        set(value) {
            sex = value
        }

    private lateinit var kotlinDemo: KotlinDemo

    fun testNpe() {
//      var a = "kdsfajkl"
//      a = null.toString()
        try {
            kotlinDemo = KotlinDemo()
        } finally {

        }

//        kotlinDemo = null
        print(kotlinDemo?.toString())
    }

    fun vars(vararg v:Int) {
        for (vt in v) {
            println(vt)
        }
    }

}


/** 我是main入口函数 **/
fun main(args: Array<String>) {
    var kotlinDemo = KotlinDemo()
    kotlinDemo.testNpe()
    kotlinDemo.vars(12,232,43,43)
    val a = 100;


}