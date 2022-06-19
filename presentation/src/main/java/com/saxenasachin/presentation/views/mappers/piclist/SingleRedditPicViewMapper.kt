package com.saxenasachin.presentation.views.mappers.piclist

import com.saxenasachin.domain.models.piclist.RedditPicModel
import com.saxenasachin.presentation.mapper.Mapper
import com.saxenasachin.presentation.views.views.*
import javax.inject.Inject

class SingleRedditPicViewMapper @Inject constructor() : Mapper<RedditPicView, RedditPicModel> {

    override fun mapToView(type: RedditPicModel): RedditPicView {
        return RedditPicView(
            data = RedditPicDataView(
                children = type.data.children.map { childrenModel ->
                    ChildrenView(
                        data = ChildDataView(
                            title = childrenModel.data.title,
                            authorFullname = childrenModel.data.authorFullname,
                            thumbnail = childrenModel.data.thumbnail,
                            thumbnailWidth = childrenModel.data.thumbnailWidth,
                            thumbnailHeight = childrenModel.data.thumbnailHeight,
                            preview = ImagePreviewView(
                                images = childrenModel.data.preview.images.map { previewImageModel ->
                                    PreviewImageView(
                                        id = previewImageModel.id,
                                        source = PreviewImageDetailView(
                                            url = previewImageModel.source.url,
                                            width = previewImageModel.source.width,
                                            height = previewImageModel.source.height
                                        ),
                                        resolutions = previewImageModel.resolutions.map { previewImageDetailModel ->
                                            PreviewImageDetailView(
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