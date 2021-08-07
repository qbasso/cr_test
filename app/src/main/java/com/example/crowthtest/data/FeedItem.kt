package com.example.crowthtest.data

sealed class FeedItem {
    object Header: FeedItem()
    object UpperIcons: FeedItem()
    data class CarouselItemList(val items: List<CarouselItem>): FeedItem()

}