use serde::{Deserialize, Serialize};

#[derive(Deserialize, Serialize, sqlx::FromRow)]
pub(crate) struct Book {
    pub(crate) id: String,
    pub(crate) title: String,
    pub(crate) preview: String,
    pub(crate) created_at: u64,
}
