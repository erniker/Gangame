package silmood.com.gangame.data

import silmood.com.gangame.TopGame

object TopGameMapper {

    fun fromSdk(topGame: silmood.com.gangamesdk.TopGame): TopGame {
        return TopGame(topGame.title,
                topGame.owners,
                topGame.steamRating,
                topGame.publisher,
                topGame.price,
                position,
                topGame.thumb)
    }
}
