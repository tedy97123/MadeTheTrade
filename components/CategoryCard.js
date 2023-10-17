import { View, Text , TouchableOpacity, ImageBackground} from 'react-native'
import React from 'react'
import { COLORS, FONTS , SIZES } from '../constants'

const CategoryCard = ({category,containerStyle}) => {
  return (
    <TouchableOpacity>
        <ImageBackground
        source={category?.thumbnail}
        resizeMode='cover'
        style={{
            height:150,
            width:250,
            paddingVertical:SIZES.padding,
            paddingHorizontal:SIZES.radius,
            justifyContent:'flex-end',
            ...containerStyle
        }}
        >
            <Text
            style={{
                color: COLORS.white,
                ...FONTS.h2,
                fontWeight:'light',
                fontSize:19
            }}
            >
                {category?.title}
            </Text>

        </ImageBackground>
    </TouchableOpacity>
  )
}

export default CategoryCard;