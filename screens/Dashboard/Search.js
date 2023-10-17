import React from 'react';
import {
    View,
    Text
} from 'react-native';
import { SIZES ,FONTS} from '../../constants';
const Search = () => {

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
                        Search
                </Text>             
            </View>
        )
    }
    return (
        <View>
           {/* Header */}
           {renderHeader()}
        </View>
    )
}

export default Search;