package com.saxenasachin.domain.models.piclist

/**
Created by Sachin Saxena on 19/06/22.
 */
data class RedditPicModel(
    val data: RedditPicDataModel
)

data class RedditPicDataModel(
    val children: List<ChildrenModel>
)

data class ChildrenModel(
    val data: ChildDataModel
)

data class ChildDataModel(
    val title: String?,
    val authorFullname: String,
    val thumbnail: String,
    val thumbnailWidth: Int,
    val thumbnailHeight: Int,
    val preview: ImagePreviewModel
)

data class ImagePreviewModel(
    val images: List<PreviewImageModel>
)

data class PreviewImageModel(
    val id: String,
    val source: PreviewImageDetailModel,
    val resolutions: List<PreviewImageDetailModel>
)

data class PreviewImageDetailModel(
    val url: String,
    val width: Int,
    val height: Int
)