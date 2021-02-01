package com.example.filingcabinet.data.remote.entity

import com.google.gson.annotations.SerializedName

/*
* JSON Example:
* {
*   "response" : [
*       {
*           "f_name" : "string",
*           "l_name" : "string",
*           "birthday" : "string",
*           "avatr_url" : "string",
*           "specialty" : [{
*               "specialty_id" : int,
*               "name" : "string"
*           ]}
*       },
*       .
*       .
*   ]
*}
* */

data class EmployeesRemoteEntity(
    @SerializedName("response") val employees : List<EmployeeRemoteEntity>
)

data class EmployeeRemoteEntity(
    @SerializedName("f_name") val firstName: String?,
    @SerializedName("l_name") val lastName: String?,
    @SerializedName("birthday") val birthday: String?,
    @SerializedName("avatr_url") val avatar: String?,
    @SerializedName("specialty") val specialty: List<Specialty>
) {
    data class Specialty(
        @SerializedName("specialty_id") val id: Int,
        @SerializedName("name") val name: String?
    )
}