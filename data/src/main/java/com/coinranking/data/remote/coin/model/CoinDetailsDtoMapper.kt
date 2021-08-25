package com.coinranking.data.remote.coin.model

import com.coinranking.domain.model.AllTimeHigh
import com.coinranking.domain.model.CoinDetails
import com.coinranking.domain.model.Link
import com.coinranking.domain.model.Supply
import com.coinranking.domain.util.DomainMapper
import com.coinranking.domain.util.TimeUtils
import java.math.BigDecimal

class CoinDetailsDtoMapper : DomainMapper<CoinDetailsDto, CoinDetails> {
    override fun toDomainModel(model: CoinDetailsDto): CoinDetails {
        return CoinDetails(
            coinId = model.coinId,
            volume = BigDecimal(model.volume),
            allTimeHigh = AllTimeHighDtoMapper().toDomainModel(model.allTimeHigh),
            btcPrice = BigDecimal(model.btcPrice),
            change = BigDecimal(model.change),
            coinRankingUrl = model.coinRankingUrl,
            color = model.color,
            description = model.description,
            iconUrl = model.iconUrl,
            links = LinkDtoMapper().toDomainList(model.links),
            lowVolume = model.lowVolume,
            marketCap = BigDecimal(model.marketCap),
            name = model.name,
            numberOfExchanges = model.numberOfExchanges,
            numberOfMarkets = model.numberOfMarkets,
            price = BigDecimal(model.price),
            rank = model.rank,
            sparkline = model.sparkline.toBigDecimal(),
            supply = SupplyDtoMapper().toDomainModel(model.supply),
            symbol = model.symbol,
            tier = model.tier,
            websiteUrl = model.websiteUrl
        )
    }

    override fun fromDomainModel(domainModel: CoinDetails): CoinDetailsDto {
        return CoinDetailsDto(
            coinId = domainModel.coinId,
            volume = domainModel.volume.toString(),
            allTimeHigh = AllTimeHighDtoMapper().fromDomainModel(domainModel.allTimeHigh),
            btcPrice = domainModel.btcPrice.toString(),
            change = domainModel.change.toString(),
            coinRankingUrl = domainModel.coinRankingUrl,
            color = domainModel.color,
            description = domainModel.description,
            iconUrl = domainModel.iconUrl,
            links = LinkDtoMapper().fromDomainList(domainModel.links),
            lowVolume = domainModel.lowVolume,
            marketCap = domainModel.marketCap.toString(),
            name = domainModel.name,
            numberOfExchanges = domainModel.numberOfExchanges,
            numberOfMarkets = domainModel.numberOfMarkets,
            price = domainModel.price.toString(),
            rank = domainModel.rank,
            sparkline = domainModel.sparkline.toStringList(),
            supply = SupplyDtoMapper().fromDomainModel(domainModel.supply),
            symbol = domainModel.symbol,
            tier = domainModel.tier,
            websiteUrl = domainModel.websiteUrl,
        )
    }

    fun toDomainList(coinDetails: List<CoinDetailsDto>): List<CoinDetails> {
        return coinDetails.map {
            toDomainModel(it)
        }
    }

    fun fromDomainList(coinDetails: List<CoinDetails>): List<CoinDetailsDto> {
        return coinDetails.map {
            fromDomainModel(it)
        }
    }

    inner class AllTimeHighDtoMapper() : DomainMapper<AllTimeHighDto, AllTimeHigh> {
        override fun toDomainModel(model: AllTimeHighDto): AllTimeHigh {
            return AllTimeHigh(
                price = BigDecimal(model.price),
                timeStamp = TimeUtils.epochToDate(model.timeStamp),
            )
        }

        override fun fromDomainModel(domainModel: AllTimeHigh): AllTimeHighDto {
            return AllTimeHighDto(
                price = domainModel.price.toString(),
                timeStamp = TimeUtils.dateToEpoch(domainModel.timeStamp)
            )
        }

    }

    inner class LinkDtoMapper() : DomainMapper<LinkDto, Link> {
        override fun toDomainModel(model: LinkDto): Link {
            return Link(
                name = model.name,
                type = model.type,
                url = model.url
            )
        }

        override fun fromDomainModel(domainModel: Link): LinkDto {
            return LinkDto(
                name = domainModel.name,
                type = domainModel.type,
                url = domainModel.url
            )
        }

        fun toDomainList(links: List<LinkDto>): List<Link> {
            return links.map {
                LinkDtoMapper().toDomainModel(it)
            }
        }

        fun fromDomainList(links: List<Link>): List<LinkDto> {
            return links.map {
                fromDomainModel(it)
            }
        }
    }

    inner class SupplyDtoMapper() : DomainMapper<SupplyDto, Supply> {
        override fun toDomainModel(model: SupplyDto): Supply {
            return Supply(
                circulating = model.circulating.toLong(),
                confirmed = model.confirmed,
                total = model.total.toLong()
            )
        }

        override fun fromDomainModel(domainModel: Supply): SupplyDto {
            return SupplyDto(
                circulating = domainModel.circulating.toString(),
                confirmed = domainModel.confirmed,
                total = domainModel.total.toString()
            )
        }

    }

}

