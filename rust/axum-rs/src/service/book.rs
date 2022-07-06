use std::time::{SystemTime,UNIX_EPOCH};

use crate::Result;
use crate::dto::Book;

pub(crate) fn get_book() -> Result<Book> {
    let now = SystemTime::now();
    let duration = now.duration_since(UNIX_EPOCH)?;
    Ok(Book { id: 1, title: String::from("Book title"), preview: String::from("Book content preview"), created_at: duration.as_millis() })
}