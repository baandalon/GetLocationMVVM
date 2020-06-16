package com.example.getlocationmvvm.model

import java.io.Serializable

class location: Serializable {
    public var latitude:String=""
    public var longitude:String=""
    constructor(){}
    constructor(latitude: String, longitude: String){
        this.latitude = latitude
        this.longitude = longitude
    }
}