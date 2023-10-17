import React from "react";
import { View, Text, Image } from "react-native";
import { FONTS, SIZES } from "../constants";


const PriceArea = ({currentPrice, percentChange }) => {
 
  return (
      <View 
        style={{
            marginTop:20,
            right:35
        }}
        >
        <View 
            style={{
                flexDirection:'row',
                justifyContent:'space-evenly'
          }}>
            <Text style={{fontSize:35,fontWeight:'bold'}}>{currentPrice}</Text>
            <Text style={{fontSize:18, top:17, right:10}}>{percentChange} %</Text>
        </View>
      </View>
  );
};

export default PriceArea;
