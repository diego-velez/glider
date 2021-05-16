package org.coquicoding.glider.api.photos.getInfo

data class Owner(
    val nsid: String,
    val username: String,
    val realname: String,
    val location: String,
    val iconserver: String,
    val iconfarm: Int,
    val path_alias: String
)
