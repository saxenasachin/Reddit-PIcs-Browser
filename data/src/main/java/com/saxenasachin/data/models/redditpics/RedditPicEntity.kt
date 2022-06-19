package com.saxenasachin.data.models.redditpics

/**
Created by Sachin Saxena on 19/06/22.
 */
data class RedditPicEntity(
    val data: RedditPicDataEntity
)

data class RedditPicDataEntity(
    val children: List<ChildrenEntity>
)

data class ChildrenEntity(
    val data: ChildDataEntity
)

data class ChildDataEntity(
    val title: String?,
    val authorFullname: String,
    val thumbnail: String,
    val thumbnailWidth: Int,
    val thumbnailHeight: Int,
    val preview: ImagePreviewEntity?
)

data class ImagePreviewEntity(
    val images: List<PreviewImageEntity>?
)

data class PreviewImageEntity(
    val id: String,
    val source: PreviewImageDetailEntity,
    val resolutions: List<PreviewImageDetailEntity>
)

data class PreviewImageDetailEntity(
    val url: String,
    val width: Int,
    val height: Int
)