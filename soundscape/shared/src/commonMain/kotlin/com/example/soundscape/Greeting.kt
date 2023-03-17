package com.example.soundscape

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}