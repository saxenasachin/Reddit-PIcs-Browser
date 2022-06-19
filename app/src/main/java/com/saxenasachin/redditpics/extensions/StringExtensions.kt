package com.saxenasachin.redditpics.extensions

/**
Created by Sachin Saxena on 19/06/22.
 */
fun String?.isValid(): Boolean {
    return this != null && this.isNotEmpty() && this.isNotBlank()
}