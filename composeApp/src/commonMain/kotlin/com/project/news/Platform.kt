package com.project.news

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform