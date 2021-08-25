package com.coinranking.data.remote.util

object MockWebServiceResponse {
    const val exchangeResponse: String = "{\n" +
            "  \"status\": \"success\",\n" +
            "  \"data\": {\n" +
            "    \"stats\": {\n" +
            "      \"24hVolume\": \"6554685985.623574\",\n" +
            "      \"total\": 198\n" +
            "    },\n" +
            "    \"exchanges\": [\n" +
            "      {\n" +
            "        \"coinrankingUrl\": \"https://coinranking.com/exchange/-zdvbieRdZ+binance\",\n" +
            "        \"uuid\": \"-zdvbieRdZ\",\n" +
            "        \"name\": \"Binance\",\n" +
            "        \"iconUrl\": \"https://cdn.coinranking.com/mDTK5qrmq/binance.svg\",\n" +
            "        \"numberOfMarkets\": 3,\n" +
            "        \"24hVolume\": \"776337030.2052088\",\n" +
            "        \"rank\": 1,\n" +
            "        \"marketShare\": \"12.22\",\n" +
            "        \"verified\": true,\n" +
            "        \"recommended\": true\n" +
            "      },\n" +
            "      {\n" +
            "        \"coinrankingUrl\": \"https://coinranking.com/exchange/XHp8eCjIDc+zb\",\n" +
            "        \"uuid\": \"XHp8eCjIDc\",\n" +
            "        \"name\": \"ZB\",\n" +
            "        \"iconUrl\": null,\n" +
            "        \"lastTickerCreatedAt\": 1546960123000,\n" +
            "        \"numberOfMarkets\": 128,\n" +
            "        \"24hVolume\": \"693976176.906341\",\n" +
            "        \"rank\": 2,\n" +
            "        \"marketShare\": \"10.92\",\n" +
            "        \"verified\": false,\n" +
            "        \"recommended\": false\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}"
}