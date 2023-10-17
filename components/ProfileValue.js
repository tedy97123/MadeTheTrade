import { View, Text, TouchableOpacity, Image } from 'react-native'
import React from 'react'
import { COLORS, FONTS, SIZES,icons } from '../constants'

const ProfileValue = ({icon,label,value,onPress}) => {
  return (
  <TouchableOpacity style={{
    flexDirection:'row',
    height:80,
    alignItems:'center'
  }}
  onPress={onPress}
  >
    {/* Icon */}
    <View style={{
        width:40,
        height:40,
        left:1,
        alightItems:'cennter',
        justifyContent:'center',
        borderRadius:20,
        backgroundColor:COLORS.additionalColor11
    }}>
        <Image 
        style={{
                width:25,
                left:5,
                height:25,
                tintColor:COLORS.primary
        }}
        source={icon}
        resizeMode="contain"
        />
    </View>
    {/* Label & Value */}
    <View style={{
        flex:1,
        marginLeft: SIZES.radius
    }}
    >
        {label && 
           <Text style={{
            color: COLORS.gray30,
            ...FONTS.body3
          }}>
            {label}
          </Text>
        }
         <Text style={{
            ...FONTS.body3,
            fontWeight:'bold',
            fontSize:13,
          }}>
            {value}
          </Text> 
    </View>
           {/* Icon */}
           <Image
            source={icons.right_arrow}
            style={{
                width:15,
                height:15
            }}
            />
  </TouchableOpacity>
  )
}

export default ProfileValue