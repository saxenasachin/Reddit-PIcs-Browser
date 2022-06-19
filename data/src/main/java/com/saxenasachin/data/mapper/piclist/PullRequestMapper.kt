package com.saxenasachin.data.mapper.piclist

import com.saxenasachin.data.mapper.Mapper
import com.saxenasachin.data.models.redditpics.*
import com.saxenasachin.domain.models.piclist.*
import javax.inject.Inject

/**
Created by Sachin Saxena on 19/06/22.
 */
class PicModelMapper @Inject constructor() : Mapper<RedditPicEntity, RedditPicModel> {

    override fun mapFromEntity(type: RedditPicEntity): RedditPicModel {
        return RedditPicModel(
            data = RedditPicDataModel(
                children = type.data.children.map { childrenEntity ->
                    ChildrenModel(
                        data = ChildDataModel(
                            title = childrenEntity.data.title,
                            authorFullname = childrenEntity.data.authorFullname,
                            thumbnail = childrenEntity.data.thumbnail,
                            thumbnailWidth = childrenEntity.data.thumbnailWidth,
                            thumbnailHeight = childrenEntity.data.thumbnailHeight,
                            preview = ImagePreviewModel(
                                images = childrenEntity.data.preview?.images?.map { previewImageEntity ->
                                    PreviewImageModel(
                                        id = previewImageEntity.id,
                                        source = PreviewImageDetailModel(
                                            url = previewImageEntity.source.url,
                                            width = previewImageEntity.source.width,
                                            height = previewImageEntity.source.height
                                        ),
                                        resolutions = previewImageEntity.resolutions.map { previewImageDetailEntity ->
                                            PreviewImageDetailModel(
                                                url = previewImageDetailEntity.url,
                                                width = previewImageDetailEntity.width,
                                                height = previewImageDetailEntity.height
                                            )
                                        }
                                    )
                                }
                            )
                        )
                    )
                }
            )
        )
    }

    override fun mapToEntity(type: RedditPicModel): RedditPicEntity {
        return RedditPicEntity(
            data = RedditPicDataEntity(
                children = type.data.children.map { childrenModel ->
                    ChildrenEntity(
                        data = ChildDataEntity(
                            title = childrenModel.data.title,
                            authorFullname = childrenModel.data.authorFullname,
                            thumbnail = childrenModel.data.thumbnail,
                            thumbnailWidth = childrenModel.data.thumbnailWidth,
                            thumbnailHeight = childrenModel.data.thumbnailHeight,
                            preview = ImagePreviewEntity(
                                images = childrenModel.data.preview.images?.map { previewImageModel ->
                                    PreviewImageEntity(
                                        id = previewImageModel.id,
                                        source = PreviewImageDetailEntity(
                                            url = previewImageModel.source.url,
                                            width = previewImageModel.source.width,
                                            height = previewImageModel.source.height
                                        ),
                                        resolutions = previewImageModel.resolutions.map { previewImageDetailModel ->
                                            PreviewImageDetailEntity(
                                                url = previewImageDetailModel.url,
                                                width = previewImageDetailModel.width,
                                                height = previewImageDetailModel.height
                                            )
                                        }
                                    )
                                }
                            )
                        )
                    )
                }
            )
        )
    }
}