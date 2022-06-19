package com.saxenasachin.remote.models.reddit.pics

import com.google.gson.annotations.SerializedName

/**
Created by Sachin Saxena on 19/06/22.
 */
data class RedditPic(
    @SerializedName("data")
    val data: RedditPicData
) {
    data class RedditPicData(
        @SerializedName("children")
        val children: List<Children>
    ) {
        data class Children(
            @SerializedName("data")
            val data: ChildData
        ) {
            data class ChildData(
                @SerializedName("title")
                val title: String?,

                @SerializedName("author_fullname")
                val authorFullname: String,

                @SerializedName("thumbnail")
                val thumbnail: String,

                @SerializedName("thumbnail_width")
                val thumbnailWidth: Int,

                @SerializedName("thumbnail_height")
                val thumbnailHeight: Int,

                @SerializedName("preview")
                val preview: ImagePreview
            ) {
                data class ImagePreview(
                    @SerializedName("images")
                    val images: List<PreviewImage>
                ) {
                    data class PreviewImage(
                        @SerializedName("id")
                        val id: String,

                        @SerializedName("source")
                        val source: PreviewImageDetail,

                        @SerializedName("resolutions")
                        val resolutions: List<PreviewImageDetail>
                    ) {
                        data class PreviewImageDetail(
                            @SerializedName("url")
                            val url: String,

                            @SerializedName("width")
                            val width: Int,

                            @SerializedName("height")
                            val height: Int
                        )
                    }
                }
            }
        }
    }
}