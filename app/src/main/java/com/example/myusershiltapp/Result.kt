package com.example.myusershiltapp

/**
 * Response Result
 */
data class Result<T>(val status: Status, val data: T?, val message: String?) {


    companion object {
        /**
         * Success with data
         */
        fun <T> success(data: T?, message: String? = "Successfully retrieved"): Result<T> {
            return Result(Status.SUCCESS, data, message)
        }

        /**
         * Error with message
         */
        fun <T> error(message: String?): Result<T> {
            return Result(Status.ERROR, null, message)
        }

        /**
         * Loading state
         */
        fun <T> loading(data: T? = null, message: String? = "Showing cached results"): Result<T> {
            return Result(Status.LOADING, data, message)
        }
    }
}

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}