import React,{useState,useEffect} from 'react';
import {
    View,
    Text,
    FlatList,
    RefreshControl
} from 'react-native';
import { SIZES ,FONTS} from '../../constants';
import { CoinItem } from '../../components';
import { getMarketData } from '../../services/requests';
 

const Stocks = () => {
    const [coins, setCoins] = useState([]);
    const [loading, setLoading] = useState(false);
  
    const fetchCoins = async (pageNumber) => {
      if (loading) {
        return;
      }
      setLoading(true);
      const coinsData = await getMarketData(pageNumber);
      setCoins((existingCoins) => [...existingCoins, ...coinsData]);
      setLoading(false);
    };
  
    const refetchCoins = async () => {
      if (loading) {
        return;
      }
      setLoading(true);
      const coinsData = await getMarketData();
      setCoins(coinsData);
      setLoading(false);
    };
  
    useEffect(() => {
      fetchCoins();
    }, []);

    function renderHeader() {
        return(
            <View
                style={{
                    flexDirection:'row',
                    marginTop:50,
                    paddingHorizontal:SIZES.padding,
                    justifyContent:'space-between'
                }}
            >
                <Text 
                    style={{
                        ...FONTS.h1
                    }}
                    >
                        Watchlist
                </Text>             
            </View>
        )
    }

    function renderStockList(){
        return (
            <FlatList
                data={coins}
                renderItem={({ item, index }) =>  <CoinItem marketCoin={item} key={index} />}
                onEndReached={() => fetchCoins(coins.length / 50 + 1)}
                keyExtractor={(item) => item.id}
                refreshControl={
                <RefreshControl
                    refreshing={loading}
                    tintColor="black"
                />
             }
            />
        )
    }
    return (
        <View>
           {/* Header */}
           {renderHeader()}
           {/* StockItems */}
          {renderStockList()} 
        </View>
    )
}

export default Stocks;