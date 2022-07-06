use axum::Router;
use axum::routing::get;

use crate::facade::book;

pub(crate) fn gen_router() -> Router {
    Router::new()
        .route("/", get(book::get_book))
}