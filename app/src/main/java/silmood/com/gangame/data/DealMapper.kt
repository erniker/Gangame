package silmood.com.gangame.data

import silmood.com.gangamesdk.Deal

object DealMapper {
    fun fromSdk(deal: silmood.com.gangamesdk.Deal): Deal {
        return Deal(deal.title,
                deal.salePrice,
                deal.normalPrice,
                deal.metacriticScore,
                deal.steamRating,
                deal.thumb)
    }
}
