import { View, Text, Image} from 'react-native'
import React from 'react'
import { FONTS,SIZES,COLORS} from '../constants'
const IconLabel = ({containerStyle,icon,iconStyle,label,labelStyle}) => {
  return (
    <View
        style={{
            flexDirection:'row',
            alignItems:'center',
            ...containerStyle,
            marginTop:3
        }}> 
        <Image
        source={icon}
            style={{
                width:17,
                height:17,
                tintColor:COLORS.gray30,
                ...iconStyle
            }}
            />
            <Text
                style={{
                    marginLeft:SIZES.base,
                    color:COLORS.gray30,
                    ...FONTS.body3,
                    ...labelStyle
                }}
                >
                    {label}
                </Text>

    </View>
  )
}

export default IconLabel