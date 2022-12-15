use sqlx::MySql;
use time::OffsetDateTime;

use crate::dto::Book;
use crate::model::BookModel;
use crate::{Error, Result};

pub(crate) fn gen_book() -> BookModel {
    BookModel {
        id: scru128::new_string(),
        title: String::from("Book title"),
        preview: String::from("Preview content of this book"),
        price: 20,
        created_at: OffsetDateTime::now_utc(),
    }
}

pub(crate) async fn save(book: BookModel) -> Result<()> {
    sqlx::query("INSERT INTO books(id, title, preview, price, created_at)VALUES(?,?,?,?,?)")
        .bind(book.id)
        .bind(book.title)
        .bind(book.preview)
        .bind(book.price)
        .bind(book.created_at)
        .execute(crate::db::DATASOURCE.get().unwrap())
        .await
        .map(|r| {
            println!("{:?}", r);
            ()
        })
        .map_err(|e| {
            let s = format!("{:?}", e);
            eprintln!("{}", &s);
            Error { detail: s }
        })
}

pub(crate) async fn get_latest_book() -> Result<Book> {
    sqlx::query_as::<MySql, BookModel>("SELECT * FROM books ORDER BY id DESC LIMIT 1")
        .fetch_one(crate::db::DATASOURCE.get().unwrap())
        .await
        .map(|b| b.into())
        .map_err(|e| {
            let s = format!("{:?}", e);
            eprintln!("{}", &s);
            Error { detail: s }
        })
}
