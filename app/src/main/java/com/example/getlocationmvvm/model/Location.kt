package com.example.getlocationmvvm.model

import java.io.Serializable

class Location: Serializable {
    private var latitude:String=""
    private var longitude:String=""
    constructor(){}
    constructor(latitude: String, longitude: String){
        this.latitude = latitude
        this.longitude = longitude
    }
}