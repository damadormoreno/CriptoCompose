package com.deneb.criptocompose.features.coin.model


import com.google.gson.annotations.SerializedName

data class CoinDetailDto(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("symbol")
    val symbol: String = "",
    @SerializedName("rank")
    val rank: Int = 0,
    @SerializedName("is_new")
    val isNew: Boolean = false,
    @SerializedName("is_active")
    val isActive: Boolean = false,
    @SerializedName("type")
    val type: String = "",
    @SerializedName("tags")
    val tags: List<Tag> = listOf(),
    @SerializedName("team")
    val team: List<TeamMember> = listOf(),
    @SerializedName("description")
    val description: String = "",
    @SerializedName("message")
    val message: String = "",
    @SerializedName("open_source")
    val openSource: Boolean = false,
    @SerializedName("started_at")
    val startedAt: String = "",
    @SerializedName("development_status")
    val developmentStatus: String = "",
    @SerializedName("hardware_wallet")
    val hardwareWallet: Boolean = false,
    @SerializedName("proof_type")
    val proofType: String = "",
    @SerializedName("org_structure")
    val orgStructure: String = "",
    @SerializedName("hash_algorithm")
    val hashAlgorithm: String = "",
    @SerializedName("links")
    val links: Links = Links(),
    @SerializedName("links_extended")
    val linksExtended: List<LinksExtended> = listOf(),
    @SerializedName("whitepaper")
    val whitepaper: Whitepaper = Whitepaper(),
    @SerializedName("first_data_at")
    val firstDataAt: String = "",
    @SerializedName("last_data_at")
    val lastDataAt: String = ""
) {
    data class Tag(
        @SerializedName("id")
        val id: String = "",
        @SerializedName("name")
        val name: String = "",
        @SerializedName("coin_counter")
        val coinCounter: Int = 0,
        @SerializedName("ico_counter")
        val icoCounter: Int = 0
    )

    data class TeamMember(
        @SerializedName("id")
        val id: String = "",
        @SerializedName("name")
        val name: String = "",
        @SerializedName("position")
        val position: String = ""
    )

    data class Links(
        @SerializedName("explorer")
        val explorer: List<String> = listOf(),
        @SerializedName("facebook")
        val facebook: List<String> = listOf(),
        @SerializedName("reddit")
        val reddit: List<String> = listOf(),
        @SerializedName("source_code")
        val sourceCode: List<String> = listOf(),
        @SerializedName("website")
        val website: List<String> = listOf(),
        @SerializedName("youtube")
        val youtube: List<String> = listOf()
    )

    data class LinksExtended(
        @SerializedName("url")
        val url: String = "",
        @SerializedName("type")
        val type: String = "",
        @SerializedName("stats")
        val stats: Stats = Stats()
    ) {
        data class Stats(
            @SerializedName("subscribers")
            val subscribers: Int = 0,
            @SerializedName("contributors")
            val contributors: Int = 0,
            @SerializedName("stars")
            val stars: Int = 0,
            @SerializedName("followers")
            val followers: Int = 0
        )
    }

    data class Whitepaper(
        @SerializedName("link")
        val link: String = "",
        @SerializedName("thumbnail")
        val thumbnail: String = ""
    )
}

fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = isActive,
        tags = tags.map { it.name },
        team = team
    )
}