import { SET_WATCHLIST , ADD_TO_WATCHLIST, REMOVE_FROM_WATCHLIST} from "../actions/WatchlistAction";


const initialState = [];

const WatchlistReducer = (state = initialState, action) => {
  switch (action.type) {
    case SET_WATCHLIST:
      return action.payload;
    case ADD_TO_WATCHLIST:
      return [...state, action.payload];
    case REMOVE_FROM_WATCHLIST:
      return state.filter(coinId => coinId !== action.payload);
    default:
      return state;
  }
};

export default WatchlistReducer;
