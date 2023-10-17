// store.js
import { combineReducers, configureStore } from '@reduxjs/toolkit';
import  WatchlistReducer  from '../reducer/WatchlistReducer';

const rootReducer = combineReducers(
    {
        watchlist: WatchlistReducer,
    }
);

const store = configureStore({
  reducer: rootReducer,
});

export default store;
