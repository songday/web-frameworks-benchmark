use axum::routing::get;
use axum::Router;

use crate::facade::book;

pub(crate) fn gen_router() -> Router {
    Router::new().route("/book/latest", get(book::get_book))
}
