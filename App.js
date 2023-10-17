import React from "react";
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { GestureHandlerRootView } from "react-native-gesture-handler";
import { CoinDetailedScreen, MainLayout } from "./screens";
import store from "./components/Redux/store/WatchlistStore";
import { Provider } from "react-redux";
import { navigationRef } from "./RootNavigation";

const Stack = createNativeStackNavigator();

const App = () => {
    return (
        <Provider store={store}> 
            <GestureHandlerRootView style={{ flex: 1 }}>
                    <NavigationContainer ref={navigationRef}>
                        <Stack.Navigator
                            screenOptions={{
                                headerShown: false
                            }}
                            initialRouteName={'Dashboard'}
                        >
                            <Stack.Screen
                                name="Dashboard"
                                component={MainLayout}
                            />
                            <Stack.Screen
                                name="CoinDetailedScreen"
                                component={CoinDetailedScreen}
                            />
                        </Stack.Navigator>
                    </NavigationContainer>
            </GestureHandlerRootView>
        </Provider>
    )
}

export default App;
