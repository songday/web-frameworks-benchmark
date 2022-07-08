use axum::http::StatusCode;
use axum::response::IntoResponse;
use axum::Json;

use crate::dto::Book;
use crate::facade::Response;
use crate::service::book;

pub(crate) async fn get_book() -> impl IntoResponse {
    let res: Response<Book> = book::get_book().into();
    (StatusCode::OK, Json(res))
}
