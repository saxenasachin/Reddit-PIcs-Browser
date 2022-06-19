package com.saxenasachin.remote.mappers.reddit.piclist

import com.saxenasachin.data.models.redditpics.*
import com.saxenasachin.remote.mappers.EntityMapper
import com.saxenasachin.remote.models.picslist.RedditPic
import javax.inject.Inject

class RedditPicsEntityMapper @Inject constructor() :
    EntityMapper<RedditPic, RedditPicEntity> {

    override fun mapFromModel(model: RedditPic): RedditPicEntity {
        return RedditPicEntity(
            data = RedditPicDataEntity(
                children = model.data.children.map { children ->
                    ChildrenEntity(
                        data = ChildDataEntity(
                            title = children.data.title,
                            authorFullname = children.data.authorFullname,
                            thumbnail = children.data.thumbnail,
                            thumbnailWidth = children.data.thumbnailWidth,
                            thumbnailHeight = children.data.thumbnailHeight,
                            preview = ImagePreviewEntity(
                                images = children.data.preview?.images?.map { previewImage ->
                                    PreviewImageEntity(
                                        id = previewImage.id,
                                        source = PreviewImageDetailEntity(
                                            url = previewImage.source.url,
                                            width = previewImage.source.width,
                                            height = previewImage.source.height
                                        ),
                                        resolutions = previewImage.resolutions.map { previewImageDetail ->
                                            PreviewImageDetailEntity(
                                                url = previewImageDetail.url,
                                                width = previewImageDetail.width,
                                                height = previewImageDetail.height
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