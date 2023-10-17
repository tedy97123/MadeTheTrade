import { View, Text } from 'react-native'
import React from 'react'
import { COLORS } from '../constants'

const LineDivider = ({lineStyle}) => {
  return (
    <View
        style={{
            height:1,
            marginTop:15,
            width:"94%",
            marginLeft:10,
            backgroundColor:COLORS.gray20,
            ...lineStyle
        }}
    >
    </View>
  )
}

export default LineDivider