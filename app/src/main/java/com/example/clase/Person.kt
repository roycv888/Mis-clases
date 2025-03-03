package com.example.clase

open class Person(var name:String= "Anonimo", var passport: String?=null, var height: Float = 1.6f){

        var alive: Boolean = true

        fun Person() {
            name = "Juan"
            passport = "88042212"
        }

        fun die() {
            alive = false
        }

        fun checkPolicia(fn:(Float)->Boolean): Boolean {
            return fn(height)
        }
    }
