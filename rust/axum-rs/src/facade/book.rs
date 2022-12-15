use axum::http::StatusCode;
use axum::response::IntoResponse;
use axum::Json;

use crate::dto::{Book, Response};
use crate::service::book;

pub(crate) async fn get_book() -> impl IntoResponse {
    let r = book::save(book::gen_book()).await;
    let res: Response<Book> = if let Ok(_) = r {
        book::get_latest_book().await.into()
    } else {
        r.map(|_| Book {
            id: String::new(),
            title: String::new(),
            preview: String::new(),
            price: 0,
            created_at: String::new(),
        })
        .into()
    };
    (StatusCode::OK, Json(res))
}
