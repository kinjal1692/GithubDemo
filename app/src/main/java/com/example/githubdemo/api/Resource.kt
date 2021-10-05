package com.example.githubdemo.api

/**
 * A generic class that describes data with a status
 */
/*
class Resource<T> constructor(
    val status: Status, var data: T? = null, val message: String? = null, val date: Date? = null
) {

    companion object {
        fun <T> success(data: T?, date: Date?): Resource<T> {
            return Resource(status = Status.SUCCESS, data = data, date = date)
        }

        fun <T> error(msg: String?, data: T?, date: Date?): Resource<T> {
            return Resource(Status.ERROR, data, msg, date)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(status = Status.LOADING, data = data)
        }

        fun <T> cached(data: T?, date: Date?): Resource<T> {
            return Resource(status = Status.CACHED, data = data, date = date)
        }

        fun <T> reAuthenticate(): Resource<T> {
            return Resource(Status.REAUTH)
        }

        fun <T> logout(): Resource<T> {
            return Resource(Status.LOGOUT)
        }
    }

}

enum class Status {
    SUCCESS, ERROR, LOADING, CACHED, REAUTH, LOGOUT
}
*/


data class Resource<out T>(val status: Status, val data: T?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(message: String, data: T? = null): Resource<T> {
            return Resource(Status.ERROR, data, message)
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}