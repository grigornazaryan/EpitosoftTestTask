package com.grigor.epitosofttesttask.extencions

import ch.hsr.geohash.GeoHash
import ch.hsr.geohash.WGS84Point

fun convertGeoHash(geoHashCode: String?): WGS84Point? {
    val geoHash = GeoHash.fromGeohashString(geoHashCode)
    return geoHash.originatingPoint
}