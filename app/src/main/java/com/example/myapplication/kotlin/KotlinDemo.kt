package com.example.myapplication.kotlin

class KotlinDemo {

    private var name: String? = null
    private var age: Int? = null
    val sex: String?
        get() {
            TODO()
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

}


/** 我是main入口函数 **/
fun main(args: Array<String>) {
   var kotlinDemo = KotlinDemo()
    kotlinDemo.testNpe()
}