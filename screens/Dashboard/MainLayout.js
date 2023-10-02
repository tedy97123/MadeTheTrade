import React from 'react';
import {View, Text, TouchableOpacity, Image, Animated} from 'react-native';
import {Home, Profile, Search} from '../Dashboard';
import {COLORS, SIZES, FONTS, constants} from '../../constants';
import { Shadow } from 'react-native-shadow-2';
const MainLayout = () => {
  const flatListRef = React.useRef();
  const scrollX = React.useRef(new Animated.Value(0)).current;
  const renderContent = () => {
    return (
      <View style={{flex: 1}}>
        <Animated.FlatList
          ref={flatListRef}
          horizontal
          pagingEnabled
          snapToAlignment="center"
          snapToInterval={SIZES.width}
          decelerationRate="fast"
          showsHorizontalScrollIndicator={false}
          data={constants.bottom_tabs}
          keyExtractor={item => `Main-${item.id}`}
          onScroll={Animated.event(
            [{nativeEvent: {contentOffset: {x: scrollX}}}],
            {
              useNativeDriver: false,
            },
          )}
          renderItem={(item, index) => {
            return (
              <View
                style={{
                  height: SIZES.height,
                  width: SIZES.width,
                }}>
                {item.label == constants.screens.home && <Home />}
                {item.label == constants.screens.search && <Search />}
                {item.label == constants.screens.profile && <Profile />}
              </View>
            );
          }}
        />
      </View>
    );
  };

  return (
    <View style={{flex: 1, backgroundColor: COLORS.white}}>
      {/* Content */}
      {renderContent()}
      {/* Bottom Tab */}
    </View>
  );
};

export default MainLayout;
