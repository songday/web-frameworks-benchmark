use warp::Filter;

use crate::facade::book;

pub fn gen_filters() -> impl Filter<Extract = (impl warp::Reply,), Error = warp::Rejection> + Clone
{
    warp::get().and(warp::path::end()).and_then(book::get_book)
}
