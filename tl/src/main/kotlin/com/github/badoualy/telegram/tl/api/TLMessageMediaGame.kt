package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messageMediaGame#fdb19008
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageMediaGame() : TLAbsMessageMedia() {
    var game: TLGame = TLGame()

    private val _constructor: String = "messageMediaGame#fdb19008"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(game: TLGame) : this() {
        this.game = game
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(game)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        game = readTLObject<TLGame>(TLGame::class, TLGame.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += game.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageMediaGame) return false
        if (other === this) return true

        return game == other.game
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xfdb19008.toInt()
    }
}