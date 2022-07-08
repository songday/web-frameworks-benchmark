use serde::{Deserialize, Serialize};

#[derive(Deserialize, Serialize)]
pub(crate) struct Book {
    pub(crate) id: u64,
    pub(crate) title: String,
    pub(crate) preview: String,
    pub(crate) created_at: u128,
}
