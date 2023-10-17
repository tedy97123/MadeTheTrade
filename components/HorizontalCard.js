import { View, Image,TouchableOpacity, ImageBackground, Text } from 'react-native'
import React from 'react'
import { SIZES,COLORS,FONTS,icons} from '../constants'
import IconLabel from './IconLabel'

const HorizontalCard = ({containerStyle,course}) => {
  return (
   <TouchableOpacity
    style={{
        flexDirection:'row',
        ...containerStyle
    }}
   >
    {/* Thumbnail */}
    <ImageBackground
        source={course.thumbnail}
        resizeMode='cover'
        style={{
            width:130,
            height:130,
            marginBottom:SIZES.radius
        }}
        imageStyle={{
            borderRadius: SIZES.radius
        }}
    >
        <View
        style={{
            position:'absolute',
            top:10,
            right:10,
            width:30,
            height:30,
            alignItem:'center',
            justifyContent:'center',
            borderRadius:5,
            backgroundColor:COLORS.white
        }}
        >
            <Image 
                source={icons.favourite}
                resizeMode='contain'
                style={{
                    width:20,
                    height:20,
                    left:5,
                    tintColor:course.is_favorite ?
                    COLORS.secondary : COLORS.additionalColor4
                }}
                />

        </View>
    </ImageBackground>
    {/* Detail Section */}
    <View style={{
        flex:1,
        marginLeft:SIZES.base
    }}>
        {/* Details */}
        <Text style={{...FONTS.h3,fontSize:18,fontWeight:'bold'}}>
            {course.title}
        </Text>
        {/* Instruction and duration */}
        <View
            style={{
                flexDirection:'row',
                alignItem:'center',
                marginTop: SIZES.base
            }}
        >
            <Text
                style={{
                    ...FONTS.body4
                }}
            >
                By {course.instructor}
            </Text>
        </View>
        <IconLabel
        icon={icons.star}
        label={course.ratings}
        containerStyle={{
            marginLeft:SIZES.base
        }}
        iconStyle={{
            width:15,
            height:15,
            tintColor: COLORS.primary2,
        }}
        labelStyle={{
            marginLeft: 5,
            color:COLORS.black,
            ...FONTS.h3
        }}
        />

    </View>
   </TouchableOpacity>
  )
}

export default HorizontalCard