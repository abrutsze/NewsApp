package com.project.shared.mapper

import com.project.models.UiArticle
import com.project.models.UiUser
import com.project.response.ArticleResponse
import com.project.response.UserResponse
import com.project.shared.core.utils.orDefault

fun UserResponse.toUiUser(): UiUser =
    UiUser(
        name = name.orEmpty(),
        profileImage = profileImage.orEmpty(),
    )

