// WatchlistActions.js
export const SET_WATCHLIST = "SET_WATCHLIST";
export const ADD_TO_WATCHLIST = "ADD_TO_WATCHLIST";
export const REMOVE_FROM_WATCHLIST = "REMOVE_FROM_WATCHLIST";

export const setWatchlist = (coinIds) => ({
  type: SET_WATCHLIST,
  payload: coinIds,
});

export const addToWatchlist = (coinId) => ({
  type: ADD_TO_WATCHLIST,
  payload: coinId,
});

export const removeFromWatchlist = (coinId) => ({
  type: REMOVE_FROM_WATCHLIST,
  payload: coinId,
});
