use warp::{reply::json, Rejection, Reply};

use crate::dto::Book;
use crate::facade::Response;
use crate::service::book;

pub async fn get_book() -> Result<impl Reply, Rejection> {
    let res: Response<Book> = book::get_book().into();
    Ok(json(&res))
}
