package com.mocanu.clean_tests_presentation.x_05_magic_constant

class PersonStore {

    var name: String = ""
        private set

    var state: Int = 0
        private set

    fun setName(name: String) {
        this.name = name

        state = 1
    }

    enum class State {
        NEW,
        UPDATED,
    }

}
