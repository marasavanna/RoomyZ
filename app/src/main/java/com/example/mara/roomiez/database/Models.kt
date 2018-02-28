package com.example.mara.roomiez.database

/**
 * Created by Akitektuo on 28.02.2018.
 */
class Models {

    data class User(
            var name: String = "",
            var email: String = "",
            var age: Int = 0,
            var image: String = "",
            var id: String = ""
    )

}