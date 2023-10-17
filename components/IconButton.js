import { View, Text,TouchableOpacity,Image } from 'react-native'
import React from 'react'
import { COLORS } from '../constants'

function IconButton({containerStyle,icon,iconStyle,onPress ,color,name}){
    return (
        <TouchableOpacity
        style={{
            ...containerStyle,
            color
        }}
        onPress={onPress}
        >
            {name}
            <Image
                source ={icon}
                resizeMode="contain"
                style={{
                    height:30,
                    width:30,
                    tintColor:COLORS.white,
                    ...iconStyle
                }}
            />
        </TouchableOpacity>
    )
}

export default IconButton;