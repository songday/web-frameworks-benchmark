use core::convert::From;

use serde::{Deserialize, Serialize};
use time::format_description;

use crate::model::BookModel;

#[derive(Deserialize, Serialize)]
pub(crate) struct Book {
    pub(crate) id: String,
    pub(crate) title: String,
    pub(crate) preview: String,
    pub(crate) price: u16,
    pub(crate) created_at: String,
}

impl From<BookModel> for Book {
    fn from(m: BookModel) -> Self {
        let format =
            format_description::parse("[year]-[month]-[day] [hour]:[minute]:[second]").unwrap();
        Book {
            id: m.id,
            title: m.title,
            preview: m.preview,
            price: m.price,
            created_at: m.created_at.format(&format).unwrap(),
        }
    }
}
