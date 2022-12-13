use std::time::{SystemTime, UNIX_EPOCH};

use sqlx::MySql;

use crate::dto::Book;
use crate::{Error, Result};

pub(crate) fn gen_book() -> Result<Book> {
    let now = SystemTime::now();
    let duration = now.duration_since(UNIX_EPOCH)?;
    Ok(
        Book {
            id: scru128::new_string(),
            title: String::from("Book title"),
            preview: String::from("Preview content of this book"),
            created_at: duration.as_secs(),
        }
    )
}

pub(crate) async fn save(book: Book) -> Result<()> {
    sqlx::query("INSERT INTO books(id, title, preview, created_at)VALUES(?,?,?,?)")
        .bind(book.id)
        .bind(book.title)
        .bind(book.preview)
        .bind(book.created_at)
        .execute(crate::db::DATASOURCE.get().unwrap())
        .await
        .map(|r| ())
        .map_err(|e| {
            let s = format!("{:?}", e);
            eprintln!("{}", &s);
            Error {
                detail: s,
            }
        })
}

pub(crate) async fn get_latest_book() -> Result<Book> {
    sqlx::query_as::<MySql, Book>("SELECT * FROM books ORDER BY id DESC LIMIT 1")
        .fetch_one(crate::db::DATASOURCE.get().unwrap())
        .await
        .map_err(|e| {
            let s = format!("{:?}", e);
            eprintln!("{}", &s);
            Error {
                detail: s,
            }
        })
}
