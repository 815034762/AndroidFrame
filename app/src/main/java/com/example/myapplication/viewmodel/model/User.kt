package com.example.myapplication.viewmodel.model

/**
 * @Description:
 * @Author: ch
 * @CreateDate: 2019/7/23 15:53
 */
class User {
    var name: String? = null
    var city: String? = null
    var age = 0

    constructor() {}
    constructor(name: String?, city: String?, age: Int) {
        this.name = name
        this.city = city
        this.age = age
    }
}