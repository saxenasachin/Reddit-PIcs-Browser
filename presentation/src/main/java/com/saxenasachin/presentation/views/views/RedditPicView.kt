package com.saxenasachin.presentation.views.views

/**
Created by Sachin Saxena on 19/06/22.
 */
data class RedditPicView(
    val data: RedditPicDataView
)

data class RedditPicDataView(
    val children: List<ChildrenView>
)

data class ChildrenView(
    val data: ChildDataView
)

data class ChildDataView(
    val title: String?,
    val authorFullname: String,
    val thumbnail: String,
    val thumbnailWidth: Int,
    val thumbnailHeight: Int,
    val preview: ImagePreviewView
)

data class ImagePreviewView(
    val images: List<PreviewImageView>
)

data class PreviewImageView(
    val id: String,
    val source: PreviewImageDetailView,
    val resolutions: List<PreviewImageDetailView>
)

data class PreviewImageDetailView(
    val url: String,
    val width: Int,
    val height: Int
)