package com.example.myusershiltapp

/**
 * Response Result
 */
data class ResponseResult<T>(val status: Status, val data: T?, val error: Error?, val message: String?) {
    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        /**
         * Success with data
         */
        fun <T> success (data: T?): ResponseResult<T> {
            return ResponseResult(Status.SUCCESS, data, null, null)
        }

        /**
         * Error with message
         */
        fun <T> error(message: String?, error: Error?): ResponseResult<T> {
            return ResponseResult(Status.ERROR, null, error, message)
        }

        /**
         * Loading state
         */
        fun <T> loading(data: T? = null): ResponseResult<T> {
            return ResponseResult(Status.LOADING, data, null, null)
        }
    }
}

data class Error(val status_code: Int = 0,
                 val status_message: String? = null)